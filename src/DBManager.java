import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	Connection c;
	
	//Metodos holasoyiago
	
	public 
	
	
	public static void main(String args[]) {
		try {
			Class.forName("org.sqlite.JDBC");
			Connection c = DriverManager.getConnection("jdbc:sqlite:./db/company.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			
			c.close();
			System.out.println("Database connection closed.");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
