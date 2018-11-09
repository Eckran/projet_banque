package Controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/banque/*")
public class ConnectionFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/banque/userLogin";

        boolean loggedIn = session != null && session.getAttribute("userCon") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);

        // Si identifiants corrects: ok, sinon send vers login
        if (loggedIn || loginRequest) {
            chain.doFilter(request, response);
        } else {
            res.sendRedirect(loginURI);
        }


    }

    public void init(FilterConfig config) throws ServletException {
    }

}
