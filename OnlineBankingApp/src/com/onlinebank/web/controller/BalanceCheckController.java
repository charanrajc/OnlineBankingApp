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

/**
 * Servlet implementation class BalanceCheckController
 */
@WebServlet(description = "BalanceCheckController", urlPatterns = { "/getBalance" })
public class BalanceCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	depositeServiceImpl depService = new depositeServiceImpl();

	BalanceCheckServiceImpl balanceCheckSer = new BalanceCheckServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BalanceCheckController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = (String) request.getSession().getAttribute("cust_name");

		ArrayList<Integer> accountNumberList = depService.getAccountNumber(userName);
		request.getSession().setAttribute("accountNumberLis", accountNumberList);

		if (accountNumberList.size() > 0) {

			response.sendRedirect("get-balance.jsp");

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
		
		int account_Number = Integer.parseInt(request.getParameter("accNo"));
		
		System.out.println( " account_Number ::"+account_Number);
		request.getSession().setAttribute("account_Num", account_Number);
		
		int current_Balance=balanceCheckSer.getAccountBalance(account_Number);
		
		System.out.println( " current_Balance ::"+current_Balance);
		
		request.getSession().setAttribute("current_Balance", current_Balance);
		
		response.sendRedirect("get-balance-fanal.jsp");
	}

}
