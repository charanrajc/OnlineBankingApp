package com.onlinebank.web.service.balanceCheck;

import com.onlinebank.web.dao.balanceCheck.balanceCheckDaoImpl;

public class BalanceCheckServiceImpl implements BalanceCheckService {

	balanceCheckDaoImpl balanceDao = new balanceCheckDaoImpl();
	
	@Override
	public int getAccountBalance(int accountNum) {
		
	return balanceDao.getAccountBalance(accountNum);
		
	}

}
