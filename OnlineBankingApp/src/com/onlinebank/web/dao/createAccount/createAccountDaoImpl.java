package com.onlinebank.web.dao.createAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.onlinebank.forms.Account;
import com.onlinebank.utils.DBUtils;

public class createAccountDaoImpl implements createAccountDao {

	@Override
	public int createAccount(Account account) {
		
		int count = 0;
		Connection connection = DBUtils.getDBConnection();
	//	Class.forName(DB_DRIVER);
		//Connection	connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);

		
		try {
			String create_Account = "INSERT INTO ACCOUNT_DETAILS VALUES (?,?,?,?,?)";

			PreparedStatement pstmt = connection.prepareStatement(create_Account);

			pstmt.setString(1, account.getAccountName());
			pstmt.setInt(2, account.getAccountNumber());
			pstmt.setString(3, account.getAccountType());
			pstmt.setString(4, account.getAccountDetails());
			pstmt.setInt(5, account.getBalance());
			
			return pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
