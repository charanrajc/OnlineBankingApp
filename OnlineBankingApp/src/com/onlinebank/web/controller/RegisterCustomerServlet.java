package com.onlinebank.web.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlinebank.forms.Customer;
import com.onlinebank.web.service.login.loginServiceImpl;

/**
 * Servlet implementation class RegisterCustomerServlet
 */
@WebServlet(description = "RegisterCustomerController", urlPatterns = { "/RegisterCustomer" })
public class RegisterCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	loginServiceImpl loginImpl = new loginServiceImpl();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterCustomerServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("RegisterCustomer.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		response.setContentType("text/html");

		// populating form data to Customer object
		Customer customer = new Customer();
		customer.setUSERNAME(request.getParameter("username"));
		customer.setPASSWORD(request.getParameter("password"));
		customer.setSEC_QUESTION(request.getParameter("question"));
		customer.setANSWER(request.getParameter("answer"));
		customer.setADDRESS(request.getParameter("address"));
		customer.setEMAIL_ADDRESS(request.getParameter("email"));
		customer.setMOBILE_NUMBER(request.getParameter("mobile"));

		try {
			int register_count = loginImpl.register(customer);
			request.getSession().setAttribute("count", register_count);
			response.sendRedirect("RegisterationSuccess.jsp");

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
