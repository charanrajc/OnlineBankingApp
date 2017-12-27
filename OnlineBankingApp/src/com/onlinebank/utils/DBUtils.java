package com.onlinebank.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "SYSTEM";
	private static final String DB_PASSWORD = "Batch1pwd";

	//creating connection
	public static Connection getDBConnection() {
		Connection dbConnection = null;

		try {
			Class.forName(DB_DRIVER);
			dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

		} catch (SQLException e) {
			System.out.println(e.getMessage());

		} catch (ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}
		return dbConnection;
	}
	
	//closing connection
	public static void closeConn(Connection c){
		try {
			if(c!=null)
				c.close();    
		}
		catch (Exception ex) {
			System.out.println (ex);
		}
	}//closeConn

}
