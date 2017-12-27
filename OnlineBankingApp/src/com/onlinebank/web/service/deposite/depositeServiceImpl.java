package com.onlinebank.web.service.deposite;

import java.util.ArrayList;

import com.onlinebank.web.dao.deposite.depositeDaoImpl;

public class depositeServiceImpl implements depositeService {

	depositeDaoImpl deposite = new depositeDaoImpl();

	@Override
	public ArrayList<Integer> getAccountNumber(String userName) {

		return deposite.getAccountNumber(userName);
	}

	@Override
	public boolean depositeAmount(int amount, int accountNum) {
		
		return deposite.depositeAmount(amount, accountNum);
	}

	@Override
	public ArrayList<Integer> getAllAccountNumbers() {
		
		return deposite.getAllAccountNumbers();
	}

}
