
package app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Ehdokkaat;

public class Dao {
	private Connection conn;
	public Dao() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/gamedb", "pena", "kukkuu");
		} catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<Ehdokkaat> readKaikkiEhdokkaat() {
		ArrayList<Ehdokkaat> list=new ArrayList<>();
		Statement stmt=null;
		int count=0;
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Ehdokkaat ehdokkaat=new Ehdokkaat();
				ehdokkaat.setEhdokasId(rs.getInt("ehdokasId"));
				ehdokkaat.setSukunimi(rs.getString("sukunimi"));
				ehdokkaat.setEtunimi(rs.getString("etunimi"));
				ehdokkaat.setKotiPaikkakunta(rs.getString("kotiPaikkakunta"));
				ehdokkaat.setIka(rs.getInt("ika"));
				ehdokkaat.setMiksiEduskuntaan(rs.getString("miksiEduskuntaan"));
				ehdokkaat.setMitaAsioitaHaluatEdistaa(rs.getString("mitaAsioitaHaluatEdistaa"));
				ehdokkaat.setAmmatti(rs.getString("ammatti"));
				list.add(ehdokkaat);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}