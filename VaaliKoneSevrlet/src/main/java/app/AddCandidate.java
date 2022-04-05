package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import app.dao.Dao;
import app.data.Candidates;

@WebServlet(
		name = "AddCandidate", 
		urlPatterns = { "/addcandidate" }
		)
public class AddCandidate extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Dao dao = new Dao();
		ArrayList<Candidates> list = dao.readAllCandidates();
		
		request.setAttribute("candidateslist", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/addcandidate.jsp");
		dispatcher.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		String etunimi = request.getParameter("etunimi");
		String sukunimi = request.getParameter("sukunimi");
		String puolue = request.getParameter("puolue");
		String kotipaikkakunta = request.getParameter("kotipaikkakunta");
		String ika_string = request.getParameter("ika");
		String miksi_eduskuntaan = request.getParameter("miksi_eduskuntaan");
		String mita_asioita_haluat_edistaa = request.getParameter("mita_asioita_haluat_edistaa");
		String ammatti = request.getParameter("ammatti");

		int ika = Integer.parseInt(ika_string);

		Candidates c = new Candidates();
		
		c.setSukunimi(request.getParameter("sukunimi"));
		c.setEtunimi(request.getParameter("etunimi"));
		c.setPuolue(request.getParameter("puolue"));
		c.setKotipaikkakunta(request.getParameter("kotipaikkakunta"));
		c.setIka(request.getParameter("ika"));
		c.setMiksi_eduskuntaan(request.getParameter("miksi_eduskuntaan"));
		c.setMita_asioita_haluat_edistaa(request.getParameter("mita_asioita_haluat_edistaa"));
		c.setAmmatti(request.getParameter("ammatti"));
		c.setEhdokas_id(request.getParameter("ehdokas_id"));

		Dao dao = new Dao();
		ArrayList<Candidates> list = dao.addCandidate(c);
		
		
		request.setAttribute("candidateslist", list);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/candidatepicker");
		dispatcher.forward(request, response);

	}
}