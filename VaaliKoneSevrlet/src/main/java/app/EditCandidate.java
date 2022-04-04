package app;

import app.dao.Dao;
import app.data.Candidates;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		name = "EditCandidate", 
		urlPatterns = { "/editcandidate" }
		)
public class EditCandidate extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		
		String idValue = request.getParameter("ehdokas_id");
		
		if ( idValue != null ) {
			try {
				int id = Integer.parseInt(idValue);
				
				Dao dao = new Dao();
				Candidates candidate = dao.getCandidateId(id);
				
				session.setAttribute("candidate", candidate);
				
				RequestDispatcher rd = request.getRequestDispatcher("jsp/editcandidate.jsp");
				rd.forward(request, response);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			response.sendRedirect("/jsp/editcandidate.jsp");
			
		}
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException {
	
		Dao dao=new Dao();
		Candidates candidate = readCandidate(request);
		
		dao.editCandidate(candidate);
		
		dao.close();
		
		response.sendRedirect("/candidatepicker");
	}
	
	private Candidates readCandidate(HttpServletRequest request) {
		
		Candidates candidate = new Candidates();
		
		candidate.setSukunimi(request.getParameter("sukunimi"));
		candidate.setEtunimi(request.getParameter("etunimi"));
		candidate.setPuolue(request.getParameter("puolue"));
		candidate.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		candidate.setIka(request.getParameter("ika"));
		candidate.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		candidate.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		candidate.setAmmatti(request.getParameter("ammatti"));
		candidate.setEhdokas_id(request.getParameter("ehdokas_id"));
		return candidate;
	}
}