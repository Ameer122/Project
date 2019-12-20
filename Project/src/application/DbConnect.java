package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.net.ssl.SSLException;

public class DbConnect {
	static private final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	// update USER, PASS and DB URL according to credentials provided by the website:
	// https://remotemysql.com/
	// in future move these hard coded strings into separated config file or even better env variables
	static private final String DB = "sHYZRwpFi8";
	static private final String DB_URL = "jdbc:mysql://remotemysql.com/"+ DB + "?useSSL=false";
	static private final String USER = "sHYZRwpFi8";
	static private final String PASS = "ANXhS8DJ9K";
	public Connection conn;

public Connection getConnection() throws SSLException
{
	
	//Statement stmt = null;
	try {
		Class.forName(JDBC_DRIVER);
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		//stmt = conn.createStatement();
	} catch (SQLException se) {
		se.printStackTrace();
		System.out.println("SQLException: " + se.getMessage());
        System.out.println("SQLState: " + se.getSQLState());
        System.out.println("VendorError: " + se.getErrorCode());
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return conn;
}
}
