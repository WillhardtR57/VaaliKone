
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
			conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
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
		try {
			stmt = conn.createStatement();
			ResultSet rs=stmt.executeQuery("select * from ehdokkaat");
			while (rs.next()) {
				Ehdokkaat ehdokkaat=new Ehdokkaat();
				ehdokkaat.setEhdokas_id(rs.getInt("ehdokas_id"));
				ehdokkaat.setSukunimi(rs.getString("sukunimi"));
				ehdokkaat.setEtunimi(rs.getString("etunimi"));
				ehdokkaat.setKotipaikkakunta(rs.getString("kotipaikkakunta"));
				ehdokkaat.setIka(rs.getInt("ika"));
				ehdokkaat.setMiksi_eduskuntaan(rs.getString("miksi_eduskuntaan"));
				ehdokkaat.setMita_asioita_haluat_edistaa(rs.getString("mita_asioita_haluat_edistaa"));
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