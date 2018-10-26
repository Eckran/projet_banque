package Controller;

import Manager.CompteManager;
import Manager.TransactionManager;
import model.Compte;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/rest/transaction")
public class Transaction extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

    }

    public void doPost ( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        response.getWriter().println("123");

        Date date = new Date();
        request.getSession().getAttribute("userCon");
        //Compte compte = CompteManager.loadCompteByUtilisateur();

        /*try {
            TransactionManager.addTransaction(12000, date, "Achat voiture", compte);
        }*/

    }

}
