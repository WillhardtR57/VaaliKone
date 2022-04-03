package app;

import app.dao.Dao;
import app.data.Candidates;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		name = "EditCandidate", 
		urlPatterns = { "/editcandidate" }
		)
public class EditCandidate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
	Dao dao = new Dao();
	ArrayList<Candidates> list = dao.readAllCandidates();
	
	request.setAttribute("candidateslist", list);
	RequestDispatcher rd=request.getRequestDispatcher("/jsp/editcandidate.jsp");
	rd.forward(request, response);
	
}
	
}