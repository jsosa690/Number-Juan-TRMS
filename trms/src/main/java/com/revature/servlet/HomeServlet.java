package com.revature.servlet;

import java.io.IOException;

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
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/trmshome.html");
			    dispatcher.forward(request, response);
		UserDaoImpl udi = new UserDaoImpl();
		User use = new User();
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			use.username = cookies.toString();
			System.out.println(use.username);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/trmshome.html");
			    dispatcher.forward(request, response);
	}
}
