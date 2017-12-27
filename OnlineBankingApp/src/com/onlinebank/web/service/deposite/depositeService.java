package com.onlinebank.web.service.deposite;

import java.util.ArrayList;

public interface depositeService {
	
	public ArrayList<Integer> getAccountNumber(String userName);
	
	public ArrayList<Integer> getAllAccountNumbers();
	
	/**
	 * this method is required to deposit amount
	 * 
	 * @param amount
	 * 		deposit amount
	 * @param accountNum
	 *  		 account number to deposit amount
	 * @return
	 * 
	 * 		 return success if amount is deposited else false
	 */
	public boolean depositeAmount(int amount, int accountNum);
	

}
