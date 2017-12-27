package com.onlinebank.web.dao.viewReport;

import java.util.Date;

public interface TransactionDetailsDao {
	
	public int insertTransactionOperation(String accountName, int sourceAccountNum, int destAccNum,int amount,String operation ,Date transactionime);

}
