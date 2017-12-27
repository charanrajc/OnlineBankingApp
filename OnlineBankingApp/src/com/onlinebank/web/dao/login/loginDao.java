package com.onlinebank.web.dao.login;

import java.sql.SQLException;

import com.onlinebank.forms.Customer;

public interface loginDao {

	public boolean login(String userName, String password) throws SQLException;
	public int register(Customer cust) throws SQLException;

}
