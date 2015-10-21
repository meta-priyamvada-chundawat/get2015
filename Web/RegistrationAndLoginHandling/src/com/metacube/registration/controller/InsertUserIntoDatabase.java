package com.metacube.registration.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.registration.databaseconfiguration.ConnectionUtil;
import com.metacube.registration.helper.UserRegisterationDao;
import com.metacube.registration.model.User;


/**
 * @author Priyamvada
 *
 * Servlet implementation class InsertIntoDatabase
 */
public class InsertUserIntoDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// getting parameters from request
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		// Setting User Details
		User user = new User();
		user.setUsername(username);
		user.setEmail(email);
		user.setPassword(password);
		// getting Connection
		Connection connection = new ConnectionUtil().createConnection();

		// inserting user into database
		UserRegisterationDao registerationDao = new UserRegisterationDao(
				connection);
		boolean flag = registerationDao.insertIntoUserTable(user, connection);
		if (flag) {// if user inserted then redirect to login page
			response.sendRedirect("login.jsp?message="
					+ URLEncoder.encode("Successfully Registered, now Login",
							"UTF-8"));
		} else {
			// if not created then display user already exist
			response.sendRedirect("register.jsp?message="
					+ URLEncoder.encode("User name Already Exist, Try Another",
							"UTF-8"));
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
