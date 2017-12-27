package com.onlinebank.web.dao.deposite;

import java.util.ArrayList;

public interface depositeDao {
	
	public ArrayList<Integer> getAccountNumber(String userName);
	
	public boolean depositeAmount(int amount, int accountNum);
	
	public ArrayList<Integer> getAllAccountNumbers();

}
