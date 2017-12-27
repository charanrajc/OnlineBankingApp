package com.onlinebank.web.service.viewReport;

import java.util.Date;

public interface TransactionDetailsService {
	
	public int insertTransactionOperation(String accountName, int sourceAccountNum, int destAccNum,int amount,String operation ,Date transactionime);

}
