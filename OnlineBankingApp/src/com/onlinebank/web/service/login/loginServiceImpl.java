package com.onlinebank.web.service.login;

import java.sql.SQLException;

import com.onlinebank.forms.Customer;
import com.onlinebank.web.dao.login.LoginDaoImpl;
import com.onlinebank.web.dao.login.RegisterDaoImpl;

public class loginServiceImpl implements loginService {
	
	LoginDaoImpl  loginDaoObj = new LoginDaoImpl();
	RegisterDaoImpl reg = new RegisterDaoImpl();

	@Override
	public boolean login(String userName, String password) throws SQLException {
		return loginDaoObj.login(userName, password);
		//return reg.login(userName, password);
	}

	@Override
	public int register(Customer cust) throws SQLException {
		int register = loginDaoObj.register(cust);
		return register;
	}

}
