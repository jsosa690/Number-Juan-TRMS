package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.beans.Form;
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
	
	public void findSubmissions(String username, String json)throws SQLException {
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rsA = stmt.executeQuery("SELECT * FROM REIMBURSEMENT WHERE FULLNAME = "
				+ "(SELECT FULLNAME FROM TRMS_USER WHERE USERNAME = '" + username + "');");
		ArrayList<Form> list = new ArrayList<>();
		while(rsA.next()) {
			/*order: 
			 * FORMID NUMBER PRIMARY KEY,
				FULLNAME VARCHAR2(20),
				EVENTDATE DATE,
				STARTTIME TIMESTAMP,
				ENDTIME TIMESTAMP,
				EVENTLOC VARCHAR2(20),
				DESCRIPT VARCHAR2(20),
				EVENTCOST NUMBER,
				GRADING VARCHAR2(20),
				EVENTTYPE NUMBER,
				SUPERVISOR VARCHAR2(20),
				BENCO VARCHAR2(20)
			 */
			list.add(new Form(rsA.getString(2), rsA.getString(3), rsA.getString(4), rsA.getString(5), rsA.getString(6), rsA.getString(7), rsA.getDouble(8), rsA.getString(9), rsA.getString(10), rsA.getString(11), rsA.getString(12)));
			Gson gson = new Gson();
			json = gson.toJson(list);
		}
	}

}
