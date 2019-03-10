package com.revature.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Form;
import com.revature.daoimpl.FormDaoImpl;

public class SubmissionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1630794454522168601L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("Inside of doGet");
		
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/form.html");
			    dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		System.out.println("Inside of doPost");
		ObjectMapper om = new ObjectMapper();
		Form root = om.readValue(request.getInputStream(), Form.class);
		System.out.println(root.toString());
		
		FormDaoImpl fdi = new FormDaoImpl();
		fdi.submitForm(root.getFullName(), root.getDate(), root.getStartTime(), root.getEndTime(), root.getLocation(), root.getDescription(), root.getCost(), root.getGradingFormat(), root.getEventType(), root.getSupervisor(), root.getBenCo());
		
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/trmslogin.html");
			    dispatcher.forward(request, response);
		
		
	}
}

