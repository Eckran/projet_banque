package Controller;

import Manager.UserManager;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/banque/comptes")
public class listeCompte extends HttpServlet {

    private static final long serialVersionUID = 1L;
    //private static final Logger logger = (Logger) LogManager.getLogger(Client.class);
    //private static final org.apache.logging.log4j.Logger logger =  LogManager.getLogger(Client.class);

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("client");
        //logger.info("Client : " + user.getLogin() + " Bien r�cup�r�");
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/comptes.jsp");
        dispatcher.forward(request, response);
    }
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/userLogin.jsp");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = UserManager.loadUserByLoginAndPassword(login, password);
        if (user == null) {
            request.setAttribute("errorMsg", "login inexistant ou mdp invalid !!");
            loginDispatcher.forward(request, response);
        }
        else {
            request.setAttribute("name", user.getNom());
            request.getSession().setAttribute("user", user);
            response.sendRedirect(request.getContextPath()+"/banque/comptes");
        }
    }

}
