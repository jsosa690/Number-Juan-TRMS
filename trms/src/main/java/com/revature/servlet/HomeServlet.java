package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.daoimpl.UserDaoImpl;

public class HomeServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6195015553769926269L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("Inside of doGet");
		UserDaoImpl udi = new UserDaoImpl();
		User use = new User();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			use.username = cookies[0].getValue();
			RequestDispatcher dispatcher = getServletContext()
					.getRequestDispatcher("/trmshome.html");
			dispatcher.forward(request, response);
		} else {
			System.out.println("cookies not found");
			response.sendRedirect("/trms/login");
		}


	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/trmshome.html");
		dispatcher.forward(request, response);
	}
}
