package Rest;

import Manager.CompteManager;
import Manager.TransactionManager;
import model.Compte;
import model.Transaction;

import javax.json.*;
import javax.json.JsonArrayBuilder;
import javax.json.stream.JsonGenerator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/rest/transaction/*")
public class TransactionR extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String pathInfo = request.getPathInfo();
        String[] split = pathInfo.split("/");
        String id = split[1];
        int idInt = Integer.parseInt(id);

        List<Transaction> transactions = TransactionManager.loadTransactionByCompteId(idInt);

        JsonArrayBuilder jsonTransArray = Json.createArrayBuilder();

        for(Transaction tran : transactions){

            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date date = tran.getDateTransaction();
            String useDate = df.format(date);

            JsonObjectBuilder transac = Json.createObjectBuilder()
                    .add("montant", tran.getMontant()).add("date", useDate).add("libelle", tran.getLibelle());
            jsonTransArray.add(transac);
        }

        JsonObject transactionOut = Json.createObjectBuilder().add("transaction", jsonTransArray).build();

        Map<String,String> config = new HashMap<String, String>();
        config.put(JsonGenerator.PRETTY_PRINTING, "");
        JsonWriterFactory factory = Json.createWriterFactory(config);

        StringWriter stWriter = new StringWriter();
        JsonWriter jw = factory.createWriter(stWriter);
        jw.writeObject(transactionOut);

        String jsonDB = stWriter.toString();

        response.getWriter().println(jsonDB);

    }

    public void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        response.getWriter().println("123");

        Date date = new Date();
        String libelle = request.getParameter("libelle");
        String Smontant = request.getParameter("montant");
        String ScompteId = request.getParameter("compte");
        String ScompteReceptionId = request.getParameter("compteR");

        float montant = Float.parseFloat(Smontant);
        int compteId = Integer.parseInt(ScompteId);
        int compteReceptionId = Integer.parseInt(ScompteReceptionId);

        Compte compte = CompteManager.loadCompteById(compteId);
        Compte compteR = CompteManager.loadCompteById(compteReceptionId);

        try {
            TransactionManager.addTransaction(-montant, date, libelle, compte);
            TransactionManager.addTransaction(montant, date, libelle, compteR);
            response.sendRedirect(request.getContextPath() + "/banque/comptes");
        } catch (Exception e) {
            response.getWriter().println("error");
        }

    }

}
