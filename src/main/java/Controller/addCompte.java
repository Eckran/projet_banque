package Controller;

import Manager.CompteManager;
import model.Compte;
import model.User;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

import static Manager.BaseManager.getEntityManager;

@WebServlet("/banque/addCompte")
public class addCompte extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/addCompte.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String login = request.getParameter("login");
        EntityManager em = getEntityManager();
        User user = em.find(User.class, login);

        String soldeS = request.getParameter("solde");
        float solde = Float.parseFloat(soldeS);

        Date date = new Date();

        Compte newCompte = new Compte();
        newCompte.setRomain(user);
        newCompte.setSolde(solde);
        newCompte.setDate_creation(date);

        if(newCompte != null){
            CompteManager.createNewCompte(newCompte);
        }

        response.sendRedirect(request.getContextPath() + "/banque/comptes");
    }
}
