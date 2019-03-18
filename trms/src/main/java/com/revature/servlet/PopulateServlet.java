package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.beans.User;
import com.revature.daoimpl.UserDaoImpl;

public class PopulateServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6902201675967604688L;

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int formID = Integer.parseInt(req.getReader().readLine());
		System.out.println(formID);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		User use = new User();
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			use.username = cookies[0].getValue();
			try {
				UserDaoImpl udi = new UserDaoImpl();
				String json = "";
				json = udi.findSubmissions(use.username);
				System.out.println(json.toString());
				PrintWriter out = res.getWriter();
				out.print(json.toString());
				out.flush();
				out.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
