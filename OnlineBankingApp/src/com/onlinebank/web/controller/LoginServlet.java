package com.onlinebank.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlinebank.web.service.login.loginServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	loginServiceImpl loginImpl = new loginServiceImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		try {
			boolean isValid = loginImpl.login(userName, password);
			//if (userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("12345")) {
			if(isValid) {
				session.setAttribute("cust_name", userName);
				response.sendRedirect("HomePage.jsp");

			} else {
				request.setAttribute("errorMsg", "Entered credentials are not valid");
				response.sendRedirect("login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
