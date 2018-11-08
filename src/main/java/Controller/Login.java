package Controller;

import Manager.UserManager;
import model.User;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/banque/userLogin")
public class Login extends HttpServlet {

    private static final long serialVersionUID = 2L;
    private static final Logger logger = (Logger) LogManager.getLogger(User.class);

    public Login(){

    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/userLogin.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/userLogin.jsp");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        User user = UserManager.loadUserByLoginAndPassword(login, password);

        if (user != null) {
            request.getSession().setAttribute("userCon", user);
            request.getSession().setMaxInactiveInterval(2*60);
            response.sendRedirect(request.getContextPath() + "/banque/comptes");

        }
        else {

            request.setAttribute("errorMsg", "login inexistant ou mdp invalid !!");
            loginDispatcher.forward(request, response);

        }
    }

}
