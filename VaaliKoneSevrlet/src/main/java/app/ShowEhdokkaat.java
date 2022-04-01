package app;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import data.Ehdokkaat;

@WebServlet(
		name = "ShowEhdokkaat",
		urlPatterns = {"/showehdokkaat"}
		)
public class ShowEhdokkaat extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		// if sessions does not exist, create new one
		HttpSession session = request.getSession();
		
		Dao dao = new Dao();
		ArrayList<Ehdokkaat> ehdokkaat = dao.readKaikkiEhdokkaat();
		
		session.setAttribute("kaikkiehdokkaat", ehdokkaat);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/showallehdokkaat.jsp");
		rd.forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}

}
