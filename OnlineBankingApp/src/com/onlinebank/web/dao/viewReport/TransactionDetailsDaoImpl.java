package com.onlinebank.web.dao.viewReport;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import com.onlinebank.utils.DBUtils;

public class TransactionDetailsDaoImpl implements TransactionDetailsDao {

	@Override
	public int insertTransactionOperation(String accountName, int sourceAccountNum, int destAccNum, int amount,
			String operation, Date transactionTime) {
		
		int updateCount = 0;

		Connection connection = DBUtils.getDBConnection();
		
		String transaction_Query= " INSERT INTO TRANSACTION_DETAILS VALUES ('"+accountName+"' , "+sourceAccountNum+" ,"+destAccNum + " ,'"+operation+"' ," +amount+ " , TO_DATE(sysdate, 'dd/mm/yyyy hh:mi:ss'))"; 
		
		try {
			Statement stmt = connection.createStatement();
			updateCount = stmt.executeUpdate(transaction_Query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return updateCount;
	}

}
