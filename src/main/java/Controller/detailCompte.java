package Controller;

import Manager.CompteManager;
import model.Compte;
import model.Transaction;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/banque/transaction")
public class detailCompte extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        List<JSONObject> transactionList = new ArrayList<JSONObject>();

        String id = request.getParameter("id");
        OkHttpClient client = new OkHttpClient();

        Request req = new Request.Builder()
                .url("http://localhost:8080/rest/transaction/"+id)
                .build();

        Response res = client.newCall(req).execute();
        String data = res.body().string();
        JSONObject tran = new JSONObject(data);

        JSONArray tranA = tran.getJSONArray("transaction");

        for(int i = 0; i < tranA.length(); i++){

            float montant = tranA.getJSONObject(i).getFloat("montant");
            String libelle = tranA.getJSONObject(i).getString("libelle");
            String date = tranA.getJSONObject(i).getString("date");

            String montantS = Float.toString(montant);

            JSONObject jsonObj = new JSONObject();

            jsonObj.put("libelle", libelle);
            jsonObj.put("date", date);
            jsonObj.put("montant", montantS);

            request.setAttribute("transactionO", jsonObj);

            transactionList.add(i, jsonObj);

            request.setAttribute("transactionList", transactionList);
        }

        int idInt = Integer.parseInt(id);
        Compte compte = CompteManager.loadCompteById(idInt);

        request.setAttribute("compte", compte);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/detailCompte.jsp");
        dispatcher.forward(request, response);


    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}