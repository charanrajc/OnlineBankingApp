package com.onlinebank.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebank.forms.Account;
import com.onlinebank.web.service.createAccount.CreateAccountServiceImpl;

/**
 * Servlet implementation class CreateAccountServlet
 */
@WebServlet("/createAccount")
public class CreateAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	CreateAccountServiceImpl accountService = new CreateAccountServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAccountServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("CreateAccount.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uname = request.getParameter("uname");
		int accno = Integer.parseInt(request.getParameter("accno"));
		String acc_type = request.getParameter("acc_type");
		String details = request.getParameter("details");
		
		Account account = new Account();
		
		account.setAccountName(uname);
		account.setAccountNumber(accno);
		account.setAccountType(acc_type);
		account.setAccountDetails(details);
		account.setBalance(0);
		
		int count = accountService.createAccount(account);
		
		HttpSession session = request.getSession();
		session.setAttribute("accno", accno);
		if (count > 0) {
			response.sendRedirect("doAccount.jsp");
		} else {
			response.sendRedirect("CreateAccount.jsp");
		}
		
		PrintWriter out = response.getWriter();

		out.println("Account created successfully");
	}

}
