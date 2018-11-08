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

@WebServlet("/banque/changePassword")
public class ChangePassword extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/changePassword.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/changePassword.jsp");

        String curentPassword = request.getParameter("currentPassword");
        String newPassword = request.getParameter("newPassword");
        String confirm = request.getParameter("newConfirmPassword");
        String login = request.getParameter("id");

        UserManager.changePassword(curentPassword, newPassword, confirm, login);

        response.sendRedirect(request.getContextPath() + "/banque/comptes");
    }
}
