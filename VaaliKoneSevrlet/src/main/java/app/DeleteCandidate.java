package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import app.dao.Dao;
import app.data.Candidates;

@WebServlet(
    name = "DeleteCandidate",
    urlPatterns = {"/deletecandidate"}
    )
public class DeleteCandidate extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
	     throws IOException, ServletException {
		
		Dao dao = new Dao();
		String id = request.getParameter("ehdokas_id");
		ArrayList<Candidates> list = dao.deleteCandidate(id);
		
		request.setAttribute("candidateslist", list);
		RequestDispatcher rd=request.getRequestDispatcher("/candidatepicker");
		rd.forward(request, response);
	}
}