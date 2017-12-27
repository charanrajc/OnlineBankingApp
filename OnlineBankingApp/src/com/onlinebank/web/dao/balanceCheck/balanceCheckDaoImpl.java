package com.onlinebank.web.dao.balanceCheck;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlinebank.utils.DBUtils;

public class balanceCheckDaoImpl implements balanceCheckDao {
	

	@Override
	public int getAccountBalance(int AccountNumber) {
		
		int balance = 0;
		
		Connection connection = DBUtils.getDBConnection();

		String accountQuery = "select BALANCE from ACCOUNT_DETAILS where ACCOUNT_NUMBER = " + AccountNumber;

		try {
			Statement pstmt = connection.createStatement();
			ResultSet rs = pstmt.executeQuery(accountQuery);

			while (rs.next()) {
				balance = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return balance;
	}
	
}
