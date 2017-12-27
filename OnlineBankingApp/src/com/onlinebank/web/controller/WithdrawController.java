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
import com.onlinebank.web.service.withdraw.withdrawAmountServiceImpl;

/**
 * Servlet implementation class WithdrawController
 */
@WebServlet(description = "WithdrawController", urlPatterns = { "/withdraw" })
public class WithdrawController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	depositeServiceImpl depService = new depositeServiceImpl();

	BalanceCheckServiceImpl balanceCheckSer = new BalanceCheckServiceImpl();

	TransactionDetailsServiceImpl transactionDetails = new TransactionDetailsServiceImpl();
	
	withdrawAmountServiceImpl withdrawAmount = new withdrawAmountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WithdrawController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = (String) request.getSession().getAttribute("cust_name");

		System.out.println("userName ::" + userName);

		ArrayList<Integer> accountNumberList = depService.getAccountNumber(userName);
		request.getSession().setAttribute("accountNumbers", accountNumberList);

		if (accountNumberList.size() > 0) {

			response.sendRedirect("withdraw.jsp");

		} else {
			response.sendRedirect("noAcc.jsp");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String account_Name = request.getParameter("uname");
		Integer account_Number = Integer.parseInt(request.getParameter("accNo"));
		Integer withdraw_Amount = Integer.parseInt(request.getParameter("Amount"));

		int current_Balance = balanceCheckSer.getAccountBalance(account_Number);

		if (current_Balance == 0) {
			response.sendRedirect("noBal.jsp");

		} else if (withdraw_Amount > current_Balance) {

			response.sendRedirect("noBal.jsp");

		} else
		{
			int available_balance = current_Balance - withdraw_Amount;
			
			int updateCount = withdrawAmount.withdrawAmount(account_Number, available_balance);
			if (updateCount >  0) {
				
				int insertCount = transactionDetails.insertTransactionOperation(account_Name, account_Number,0 , withdraw_Amount, "Withdraw", new java.util.Date());
				
				System.out.println("transaction details inserted count is  ::" + insertCount);
					
				response.sendRedirect("WithdrawSuccess.jsp");
			}
		}

	}

}
