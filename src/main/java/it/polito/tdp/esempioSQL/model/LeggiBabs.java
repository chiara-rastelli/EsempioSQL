package it.polito.tdp.esempioSQL.model;

import java.util.List;

import it.polito.tdp.esempioSQL.db.BabsDAO;
import java.sql.*;

public class LeggiBabs {
	
	public void run() {
		
	/*	BabsDAO dao = new BabsDAO() ;
		
		List<Station> tutte = dao.listStation() ;
		
		for(Station s: tutte) {
			System.out.println(s.getName()) ;
		}
		
		System.out.println("----") ;
		List<Station> paloAlto = dao.listStationByLandmark("Palo Alto") ;
		for(Station s: paloAlto) {
			System.out.println(s.getName()) ;
		}
*/
		String jdbcURL = "jdbc:mysql://localhost/babs?user=root&password=root";
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL);
			String sql = "SELECT name FROM station WHERE landmark=?"; //nb in caso di stringhe il punto interrogativo non deve essere messo tra apici
			
			
			PreparedStatement st = conn.prepareStatement(sql);
		
			st.setString(1, "Palo Alto"); //metto le doppie parentesi perchè scrivo in java, non in sql, dove userei le singole
			ResultSet res = st.executeQuery();
			
			while (res.next()) {
				String nomeStazione = res.getString("name");
				System.out.println(nomeStazione);
			}
		
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public static void main(String args[]) {
		LeggiBabs babs = new LeggiBabs() ;
		babs.run();
	}

}
