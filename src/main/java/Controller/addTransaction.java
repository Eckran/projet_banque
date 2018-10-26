package Controller;

import model.Compte;
import model.User;

import javax.servlet.RequestDispatcher;
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

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/addTransaction.jsp");

        String libelle = request.getParameter("libelle");
        String Smontant = request.getParameter("montant");
        String Scompte = request.getParameter("compte");

        float montant = Float.parseFloat(Smontant);

        System.out.println(libelle + "   " + montant + "   " + Scompte);


    }

}
