package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.daoimpl.UserDaoImpl;

public class LoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1630794454522168501L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("Inside of doGet");
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/trmslogin.html");
			    dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("Inside of doPost");
		ObjectMapper om = new ObjectMapper();
		User au = om.readValue(request.getInputStream() , User.class);
		System.out.println(au.toString());
		UserDaoImpl udi = new UserDaoImpl();
        try {
            if (udi.verify(au.username, au.password)) {
                System.out.println("logged in");
            } else {
                System.out.println("Not logged in");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/trmslogin.html");
			    dispatcher.forward(request, response);
		
		
	}

}
