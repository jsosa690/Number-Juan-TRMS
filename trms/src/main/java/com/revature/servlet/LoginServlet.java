package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
        	Integer usertype = udi.verify(au.username, au.password);
            if ( usertype > 0) {
                System.out.println("logged in");
                Cookie c = new Cookie("username",au.username);
                c.setMaxAge(1800);
                response.addCookie(c);
                Cookie typecookie = new Cookie("usertype",usertype.toString());
                response.addCookie(typecookie);
                response.sendRedirect("/trms/home.html");
                
            } else {
                System.out.println("Not logged in");
                RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/trmslogin.html");
			    dispatcher.forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        	
		
		
	}

}
