package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BrowserTester {
	
	public static void main(String[] args){
		try{
			Class.forName("org.sqlite.JDBC"); //String siehe DB-Anbieter
			
			Connection con = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\tkremser\\Downloads\\Vorgaben-20220602\\Datenbank_Praktikum\\places.sqlite");
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM moz_places;");
			
			while(rs.next()){
				System.out.println(rs.getString("url"));
			}
			
			con.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
