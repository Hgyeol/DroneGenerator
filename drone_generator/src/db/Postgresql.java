package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Postgresql {

	private final String dbDriver = "org.postgresql.Driver";
	
	private final String dbUrl = "jdbc:postgresql://localhost:5432/drone";
	
	private final String dbUser = "postgres";
	private final String dbPassword = "hangyeol0315";
	
	private static Connection dbConnection = null;
	
	public void dbConnection() {
		try {
			Class.forName(dbDriver);
			dbConnection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);				
			System.out.println("DB Connection Success");
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		if(dbConnection != null) {
			return dbConnection;
		}
		else {
			dbConnection();
			return dbConnection;
		}
	}
	
}
