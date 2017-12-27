package com.onlinebank.web.dao.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.onlinebank.forms.Customer;
import com.onlinebank.utils.DBUtils;

public class LoginDaoImpl implements loginDao {
	
	
	private static final String DB_DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String DB_CONNECTION = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String DB_USER = "SYSTEM";
	private static final String DB_PASSWORD = "Batch1pwd";

	@Override
	public boolean login(String userName, String password) throws SQLException {
		
		boolean isValid = false;
		
		Connection connection = DBUtils.getDBConnection();
		String login_query = "select USERNAME , PASSWORD  from CUSTOMER where USERNAME = ? and password = ? ";
		PreparedStatement pstment = connection.prepareStatement(login_query);
		pstment.setString(1, userName);
		pstment.setString(2, password);
		
		 ResultSet rs = pstment.executeQuery();
		 while (rs.next()) {
			 
			 String uname = rs.getString(1);
			 System.out.println("username:::"+uname);
			 
			 String pwd = rs.getString(2);
			 System.out.println("password:::"+pwd);
			 isValid = true;
		}
		
		return isValid;
	}

	@Override
	public int register(Customer cust) throws SQLException {
		// Getting Connection
		int register_count = 0;
		//Connection connection = DBUtils.getDBConnection();
		try {
			
		Class.forName(DB_DRIVER);
		Connection	connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

		String register_Query = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?,?,?)";

		PreparedStatement pstmt = connection.prepareStatement(register_Query);

		pstmt.setString(1, cust.getUSERNAME());
		pstmt.setString(2, cust.getPASSWORD());
		pstmt.setString(3, cust.getSEC_QUESTION());
		pstmt.setString(4, cust.getANSWER());
		pstmt.setString(5, cust.getADDRESS());
		pstmt.setString(6, cust.getEMAIL_ADDRESS());
		pstmt.setString(7, cust.getMOBILE_NUMBER());

		register_count = pstmt.executeUpdate();
		
		} catch (Exception e) {
			// TODO: handle exception
		}

		return register_count;
	}

}
