
package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import data.UserData;
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
	public static UserData checkLogin(String username, String password) throws SQLException,
    ClassNotFoundException {
    String jdbcURL = "jdbc:mysql://localhost:3306/vaalikone";
    String dbUser = "root";
    String dbPassword = "password";

    Class.forName("com.mysql.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/vaalikone", "pena", "kukkuu");
    String sql = "SELECT * FROM users WHERE username = ? and password = ?";
    PreparedStatement statement = conn.prepareStatement(sql);
    statement.setString(1, username);
    statement.setString(2, password);

    ResultSet result = statement.executeQuery();

    UserData user = null;

    if (result.next()) {
    user = new UserData();
    user.setUsername(result.getString("username"));
    
}

conn.close();

    return user;
	}
	
}