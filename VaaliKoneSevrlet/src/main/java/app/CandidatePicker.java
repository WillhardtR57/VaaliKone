package app;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import app.dao.Dao;
import app.data.Candidates;

@WebServlet(
		name = "Candidatepicker",
		urlPatterns = {"/candidatepicker"}
		)
public class CandidatePicker extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		
		Dao dao = new Dao();
		ArrayList<Candidates> list = dao.readAllCandidates();
		
		session.setAttribute("candidateslist", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("jsp/candidatepicker.jsp");
		rd.forward(request, response);
	
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
		doGet(request, response);
	}
	
}
