package com.onlinebank.web.service.createAccount;

import com.onlinebank.forms.Account;
import com.onlinebank.web.dao.createAccount.createAccountDaoImpl;

public class CreateAccountServiceImpl implements CreateAccountService {
	
	createAccountDaoImpl accountDao= new createAccountDaoImpl();

	@Override
	public int createAccount(Account account) {
		
		int count = accountDao.createAccount(account);
		return count;
	}

}
