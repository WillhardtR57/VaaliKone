package app;
import app.data.UserData;
import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
 
@WebServlet("/logout")
public class AdminLogout extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public AdminLogout() {
        super();
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute("user");
             
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/AdminLogin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
