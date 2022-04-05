
package app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import app.data.UserData;
import app.data.Candidates;

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
	
	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet RS = stmt.executeQuery("select * from ehdokkaat");
			while (RS.next()) {
				Candidates candidate = new Candidates();
				candidate.setEhdokas_id(RS.getInt("ehdokas_id"));
				candidate.setSukunimi(RS.getString("sukunimi"));
				candidate.setEtunimi(RS.getString("etunimi"));
				candidate.setPuolue(RS.getString("puolue"));
				candidate.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				candidate.setIka(RS.getInt("ika"));
				candidate.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				candidate.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				candidate.setAmmatti(RS.getString("ammatti"));
				list.add(candidate);
			}
			return list;
		} catch (SQLException e) {
			return null;
		}
	}
	
	public int editCandidate(Candidates candidate) {

			int count = 0;
			String sql = "update ehdokkaat set sukunimi = ?, etunimi = ?, puolue = ?, kotipaikkakunta = ?, ika = ?, miksi_eduskuntaan = ?, mita_asioita_haluat_edistaa = ?, ammatti = ? where ehdokas_id = ? ";
			try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, candidate.getSukunimi());
			stmt.setString(2, candidate.getEtunimi());
			stmt.setString(3, candidate.getPuolue());
			stmt.setString(4, candidate.getKotipaikkakunta());
			stmt.setInt(5, candidate.getIka());
			stmt.setString(6, candidate.getMiksi_eduskuntaan());
			stmt.setString(7, candidate.getMita_asioita_haluat_edistaa());
			stmt.setString(8, candidate.getAmmatti());
			stmt.setInt(9, candidate.getEhdokas_id());
			count = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} return count;
	}
	
	public Candidates getCandidateId(int id) {
		Candidates candidate = null;
		String sql = "select * from ehdokkaat where ehdokas_id = ?";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet RS = stmt.executeQuery();
			if (RS.next()) {
				candidate = new Candidates();
				candidate.setEhdokas_id(RS.getInt("ehdokas_id"));
				candidate.setSukunimi(RS.getString("sukunimi"));
				candidate.setEtunimi(RS.getString("etunimi"));
				candidate.setPuolue(RS.getString("puolue"));
				candidate.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				candidate.setIka(RS.getInt("ika"));
				candidate.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				candidate.setMita_asioita_haluat_edistaa(RS.getString("mita_asioita_haluat_edistaa"));
				candidate.setAmmatti(RS.getString("ammatti"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} return candidate;
	}
	
	public ArrayList<Candidates> addCandidate(Candidates candidates) {
		String sql = "insert into ehdokkaat (ehdokas_id, sukunimi, etunimi, puolue, kotipaikkakunta, ika, miksi_eduskuntaan, mita_asioita_haluat_edistaa, ammatti) values (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, candidates.getEhdokas_id());
			stmt.setString(2, candidates.getEtunimi());
			stmt.setString(3, candidates.getSukunimi());
			stmt.setString(4, candidates.getPuolue());
			stmt.setString(5, candidates.getKotipaikkakunta());
			stmt.setInt(6, candidates.getIka());
			stmt.setString(7, candidates.getMiksi_eduskuntaan());
			stmt.setString(8, candidates.getMita_asioita_haluat_edistaa());
			stmt.setString(9, candidates.getAmmatti());
			stmt.executeUpdate();
			return readAllCandidates();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public ArrayList<Candidates> deleteCandidate(String id) {
		try {
			String sql = "delete from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllCandidates();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public static UserData checkLogin(String username, String password) throws SQLException,
    ClassNotFoundException {
    String jdbcURL = "jdbc:mysql://localhost:3306/vaalikone";
    String dbUser = "pena";
    String dbPassword = "kukkuu";

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