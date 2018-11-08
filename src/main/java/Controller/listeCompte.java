package Controller;

import Manager.CompteManager;
import Manager.UserManager;
import model.Compte;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/banque/comptes")
public class listeCompte extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //private static final Logger logger = (Logger) LogManager.getLogger(Client.class);
    //private static final org.apache.logging.log4j.Logger logger =  LogManager.getLogger(Client.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("userCon");
        List<Compte> comptes = CompteManager.loadCompteByUtilisateur(user.getLogin());

        request.setAttribute("comptes", comptes);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/comptes.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
    }

}
