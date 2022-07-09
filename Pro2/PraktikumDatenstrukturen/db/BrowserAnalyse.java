package db;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BrowserAnalyse {
	
	private static Connection conn;
	
	public static void connect() {
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:.\\places.sqlite");
		} catch ( SQLException e) {
			e.printStackTrace();
		} catch ( ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void insert() {
		Statement st;
		try {
			st = conn.createStatement();
			st.setQueryTimeout(30);
			st.executeUpdate("insert into moz_places values(42,'www.facebook.com','irgendwas','','','','','','','','')");	
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void select() throws SQLException {
		Statement st = conn.createStatement();
		st.setQueryTimeout(30);
		ResultSet rs = st.executeQuery("select * from moz_places");
		
		while (rs.next()) {
			System.out.println(rs.getInt("id") + " " + rs.getString("url"));
		}
	}
	
	public static void writeCSV() throws SQLException, IOException {
		Statement st = conn.createStatement();
		st.setQueryTimeout(30);
		ResultSet rs = st.executeQuery("select * from moz_places");
		FileWriter fw = new FileWriter("ergebnis.csv");
		while(rs.next()) {
			fw.write(rs.getInt("id") + "#" + rs.getString("url") + "#" + rs.getString("rev_host"));
		}
		fw.close();
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		connect();
		select();
		//insert();
		writeCSV();
		conn.close();
	}

}
