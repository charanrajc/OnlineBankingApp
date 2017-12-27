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
 * Servlet implementation class TransferController
 */
@WebServlet(description = "TransferController", urlPatterns = { "/transfer" })
public class TransferController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	depositeServiceImpl depService = new depositeServiceImpl();

	BalanceCheckServiceImpl balanceCheckSer = new BalanceCheckServiceImpl();

	TransactionDetailsServiceImpl transactionDetails = new TransactionDetailsServiceImpl();

	withdrawAmountServiceImpl withdrawAmount = new withdrawAmountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TransferController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = (String) request.getSession().getAttribute("cust_name");

		ArrayList<Integer> sourceAccountNumberList = depService.getAccountNumber(userName);
		request.getSession().setAttribute("sourceAccountNumberList", sourceAccountNumberList);

		ArrayList<Integer> destAccountNumberList = depService.getAllAccountNumbers();

		System.out.println(" destAccountNumberList  :: " + destAccountNumberList.size());
		request.getSession().setAttribute("destAccountNumberList", destAccountNumberList);

		if (sourceAccountNumberList.size() > 0) {

			response.sendRedirect("transfer.jsp");

		} else {
			response.sendRedirect("noAcc.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.
	 * HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// getting form parameters
		String account_Name = request.getParameter("uname");
		Integer account_Number = Integer.parseInt(request.getParameter("accNo"));
		Integer dest_Account_Number = Integer.parseInt(request.getParameter("daccNo"));
		Integer transfer_Amount = Integer.parseInt(request.getParameter("Amount"));

		// getting source account current balance
		int current_Balance = balanceCheckSer.getAccountBalance(account_Number);

		// getting destination account current balance
		int dest_Account_Current_Balance = balanceCheckSer.getAccountBalance(dest_Account_Number);

		if (current_Balance == 0) {
			response.sendRedirect("noBal.jsp");

		} else if (transfer_Amount > current_Balance) {

			response.sendRedirect("noBal.jsp");

		} else {
			int available_balance = current_Balance - transfer_Amount;

			// withdrawing amount from the source account
			int updateCount = withdrawAmount.withdrawAmount(account_Number, available_balance);
			if (updateCount > 0) {
				// depositing amount in to destination account
				boolean isDeposited = depService.depositeAmount(dest_Account_Current_Balance + transfer_Amount,
						dest_Account_Number);
			
				if (isDeposited) {

					// insert transaction details
					int updateRowCount = transactionDetails.insertTransactionOperation(account_Name, account_Number,
							dest_Account_Number, transfer_Amount, "Transfer", new java.util.Date());

					request.getSession().setAttribute("destAccountNum", dest_Account_Number);
					request.getSession().setAttribute("transferAmount", transfer_Amount);
					if (updateRowCount > 0) {
						response.sendRedirect("TransferSuccess.jsp");
					}

				}
			}
		}
	}

}
