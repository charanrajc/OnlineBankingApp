package com.onlinebank.web.service.viewReport;

import java.util.Date;

import com.onlinebank.web.dao.viewReport.TransactionDetailsDaoImpl;

public class TransactionDetailsServiceImpl implements TransactionDetailsService {
	
	TransactionDetailsDaoImpl transactionsDao = new TransactionDetailsDaoImpl();

	@Override
	public int insertTransactionOperation(String accountName, int sourceAccountNum, int destAccNum, int amount,
			String operation, Date transactionime) {
		return transactionsDao.insertTransactionOperation(accountName, sourceAccountNum, destAccNum, amount, operation, transactionime) ;
	}

}
