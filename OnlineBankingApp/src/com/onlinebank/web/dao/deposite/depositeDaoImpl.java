package com.onlinebank.web.dao.deposite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.onlinebank.utils.DBUtils;

public class depositeDaoImpl implements depositeDao {

	@Override
	public ArrayList<Integer> getAccountNumber(String userName) {

		ArrayList<Integer> accList = new ArrayList<Integer>();

		Connection connection = DBUtils.getDBConnection();

		String accountQuery = "select ACCOUNT_NUMBER from ACCOUNT_DETAILS where ACCOUNT_HOLDER_NAME = '" + userName
				+ "'";

		try {
			Statement pstmt = connection.createStatement();
			ResultSet rs = pstmt.executeQuery(accountQuery);

			while (rs.next()) {
				accList.add(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return accList;
	}
	

	@Override
	public boolean depositeAmount(int amount, int accountNum) {

		Connection connection = DBUtils.getDBConnection();

		String depositeQuery = "update ACCOUNT_DETAILS set balance = " + amount	+ " where ACCOUNT_NUMBER = " + accountNum;

		try {
			Statement stmt = connection.createStatement();
			int updateCount = stmt.executeUpdate(depositeQuery);

			if (updateCount > 0) {

				return true;

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}


	@Override
	public ArrayList<Integer> getAllAccountNumbers() {
		
		ArrayList<Integer> destAccList = new ArrayList<Integer>();

		Connection connection = DBUtils.getDBConnection();

		String accountQuery = "select ACCOUNT_NUMBER from ACCOUNT_DETAILS";

		try {
			Statement pstmt = connection.createStatement();
			ResultSet rs = pstmt.executeQuery(accountQuery);

			while (rs.next()) {
				destAccList.add(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return destAccList;
		
	}

}
