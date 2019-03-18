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
		System.out.println(root.formID);
		System.out.println(root.toString());
		Cookie[] cookies = request.getCookies();		
		FormDaoImpl fdi = new FormDaoImpl();
		if(root.formID == 0) {
			fdi.submitForm(root.getFullName(), root.getDate(), root.getStartTime(), root.getEndTime(), root.getLocation(), root.getDescription(), root.getCost(), root.getGradingFormat(), root.getEventType(), root.getSupervisor(), root.getDeptHead(), root.getBenCo());
		} else {
			System.out.println(root.formID);
			Integer usertype = Integer.parseInt(cookies[1].getValue());
			String decision = null,comment = null;
			if (usertype == 2) {
				decision = root.superDecision;
				comment = root.superContext;
			} else if(usertype == 3) {
				decision = root.benCoDecision;
				comment = root.benCoContext;
			} else if(usertype == 4) {
				decision = root.headDecision;
				decision = root.headContext;
			}
			try {
				fdi.updateForm(root.formID, usertype, decision, comment);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher dispatcher = getServletContext()
			      .getRequestDispatcher("/trmshome.html");
			    dispatcher.forward(request, response);
		
		
	}
}

