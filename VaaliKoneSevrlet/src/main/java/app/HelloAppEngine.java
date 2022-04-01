package app;
import app.dao.Dao;
import data.Ehdokkaat;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="Ehdokkaat", urlPatterns={"/ehdokkaat"})

public class HelloAppEngine extends HttpServlet {

  private PrintWriter out;

@Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) 
      throws IOException {

	  Ehdokkaat ehdokkaat = readEhdokkaat(request);
	  Dao dao = new Dao();
	  ArrayList<Ehdokkaat> list = dao.readKaikkiEhdokkaat();
	  printEhdokkaat(out, list);
	  dao.close();
  }
  
  private Ehdokkaat readEhdokkaat (HttpServletRequest request) {
	  Ehdokkaat ehdokkaat = new Ehdokkaat();
	  ehdokkaat.setSukunimi(request.getParameter("sukunimi"));
	  ehdokkaat.setEtunimi(request.getParameter("etunimi"));
	  ehdokkaat.setPuolue(request.getParameter("puolue"));
	  ehdokkaat.setKotiPaikkakunta(request.getParameter("kotiPaikkakunta"));
	  ehdokkaat.setIka(request.getParameter("ika"));
	  ehdokkaat.setMiksiEduskuntaan(request.getParameter("miksiEduskuntaan"));
	  ehdokkaat.setMitaAsioitaHaluatEdistaa(request.getParameter("mitaAsioitaHaluatEdistaa"));
	  ehdokkaat.setAmmatti(request.getParameter("ammatti"));
	  return ehdokkaat;
  }
  
  private void printEhdokkaat(PrintWriter out, ArrayList<Ehdokkaat> list) {
	  out.println("<ul>");
	  for (Ehdokkaat g:list) {
		  out.println("<li>"+g);
	  }
	  out.println("</ul>");
  }
}