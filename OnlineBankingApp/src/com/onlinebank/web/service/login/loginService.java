package com.onlinebank.web.service.login;

import java.sql.SQLException;

import com.onlinebank.forms.Customer;

public interface loginService {
	
	public boolean login(String userName, String password) throws SQLException;
	public int register(Customer cust) throws SQLException;

}
