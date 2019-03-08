package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.revature.dao.UserDao;
import com.revature.util.ConnFactory;

public class UserDaoImpl implements UserDao {

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public boolean verify(String username, String password) throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rsA = stmt.executeQuery("SELECT * FROM TRMS_USER");
		while(rsA.next()) {
			if (rsA.getString(2).equals(username)) {
				if (rsA.getString(3).equals(password)) {
					return true;
				} else {
					System.out.println("password not correct");
					return false;
				}
			}
		}
		System.out.println("username not found");
		return false;
	}

}
