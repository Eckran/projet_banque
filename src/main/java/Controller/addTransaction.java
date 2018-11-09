package Controller;

import Manager.CompteManager;
import model.Compte;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/banque/addTransaction")
public class addTransaction extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("client");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/addTransaction.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {



        String libelle = request.getParameter("libelle");
        String Smontant = request.getParameter("montant");
        String ScompteId = request.getParameter("compte");
        String ScompteReceptionId = request.getParameter("compteR");

        float montant = Float.parseFloat(Smontant);
        int compteId = Integer.parseInt(ScompteId);
        int compteReceptionId = Integer.parseInt(ScompteReceptionId);

        Compte compte = CompteManager.loadCompteById(compteId);
        Compte compteReception = CompteManager.loadCompteById(compteReceptionId);

        CompteManager.soldeUpdate(compteId, compteReceptionId, montant);

        System.out.println(libelle + "   " + montant + "   " + compte);

        ServletContext context = this.getServletContext();
        RequestDispatcher dispatcher = context.getRequestDispatcher("/rest/transaction");
        dispatcher.forward(request, response);

    }

}
