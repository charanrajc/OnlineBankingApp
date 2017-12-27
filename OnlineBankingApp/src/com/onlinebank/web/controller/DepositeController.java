package com.onlinebank.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebank.web.service.balanceCheck.BalanceCheckServiceImpl;
import com.onlinebank.web.service.deposite.depositeServiceImpl;
import com.onlinebank.web.service.viewReport.TransactionDetailsServiceImpl;

import oracle.sql.DATE;

/**
 * Servlet implementation class DepositeController
 */
@WebServlet(description = "DepositeController", urlPatterns = { "/deposite" })
public class DepositeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	depositeServiceImpl depService = new depositeServiceImpl();
	
	BalanceCheckServiceImpl balanceCheckSer = new BalanceCheckServiceImpl();
	
	TransactionDetailsServiceImpl transactionDetails = new TransactionDetailsServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositeController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName	= (String)request.getSession().getAttribute("cust_name");
		
		System.out.println("userName ::"+ userName);
		
		ArrayList<Integer> accountNumberList = depService.getAccountNumber(userName);
		request.getSession().setAttribute("accountNumberList", accountNumberList);
		
		if (accountNumberList.size() > 0 ) {
			
			response.sendRedirect("deposite.jsp");
			
		} else {
			response.sendRedirect("noAcc.jsp");
		}
		
	}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String account_Name = request.getParameter("uname");
		Integer account_Number = Integer.parseInt(request.getParameter("accNo"));
		Integer deposit_Amount =Integer.parseInt(request.getParameter("Amount"));
		
		int current_Balnce=balanceCheckSer.getAccountBalance(account_Number);
		
		boolean isDeposited = depService.depositeAmount(deposit_Amount+current_Balnce, account_Number);
		
		System.out.println("balance :  "+balanceCheckSer.getAccountBalance(account_Number));
		
		request.getSession().setAttribute("Acc_balance", balanceCheckSer.getAccountBalance(account_Number) );
		
		if (isDeposited) {
			
			int insertCount = transactionDetails.insertTransactionOperation(account_Name, account_Number,0 , deposit_Amount, "Deposite", new java.util.Date());
			
			System.out.println("transaction details inserted count is  ::" + insertCount);
				
			response.sendRedirect("doDeposite.jsp");
		}
		
	}

}
