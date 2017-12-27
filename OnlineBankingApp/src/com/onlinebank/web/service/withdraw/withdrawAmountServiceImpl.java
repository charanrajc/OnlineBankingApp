package com.onlinebank.web.service.withdraw;

import com.onlinebank.web.dao.withdraw.withdrawAmountDaoImpl;

public class withdrawAmountServiceImpl implements withdrawAmountService {

	withdrawAmountDaoImpl withdraw = new withdrawAmountDaoImpl();
	
	@Override
	public int withdrawAmount(int accountNum, int remainingBalance) {

		return withdraw.withdrawAmount(accountNum, remainingBalance);
	}

}
