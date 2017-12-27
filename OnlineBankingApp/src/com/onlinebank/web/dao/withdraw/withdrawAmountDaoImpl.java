package com.onlinebank.web.dao.withdraw;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.onlinebank.utils.DBUtils;

public class withdrawAmountDaoImpl implements withdrawAmountDao {

	@Override
	public int withdrawAmount(int accountNum, int remainingBalance) {

		int updateCount = 0;
		Connection connection = DBUtils.getDBConnection();

		String  withdrawQuery = "update ACCOUNT_DETAILS set balance = " + remainingBalance	+ " where ACCOUNT_NUMBER = " + accountNum;

		try {
			Statement stmt = connection.createStatement();
			 updateCount = stmt.executeUpdate(withdrawQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updateCount;
	}

}
