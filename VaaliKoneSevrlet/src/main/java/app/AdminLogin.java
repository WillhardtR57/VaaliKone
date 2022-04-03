package app;
import app.data.UserData;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.data.LoginData;

@WebServlet(
	    name = "AdminLogin",
	    urlPatterns = {"/login"}
	)

public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public AdminLogin() {
		super();
	}
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	  String username = request.getParameter("username");
	  String password = request.getParameter("password");
		    
	  Dao dao = new Dao ();
	  
	  try {
		  UserData user = Dao.checkLogin(username, password);
		  String destPage = "jsp/AdminLogin.jsp";
		  if (user != null) {
			  HttpSession session = request.getSession();
			  session.setAttribute("user", user);
			  destPage = "jsp/AdminPage.jsp";
		  } else {
			  String message = "Invalid username/password";
			  request.setAttribute("message", message);
		  }
		  RequestDispatcher dispatcher = request.getRequestDispatcher(destPage);
		  dispatcher.forward(request, response);
	  } catch (SQLException | ClassNotFoundException ex) {
		  throw new ServletException(ex);
	  }
	
	 }  
}
