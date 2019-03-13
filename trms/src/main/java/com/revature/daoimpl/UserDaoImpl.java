package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
	
	public String findSubmissions(String username)throws SQLException {
		Connection conn = cf.getConnection();
		String name = "";
		int role = 0;
		PreparedStatement statement = conn.prepareStatement("SELECT * FROM REIMBURSEMENT");
		ResultSet rsA = statement.executeQuery();
		PreparedStatement findName = conn.prepareStatement("SELECT * FROM TRMS_USER WHERE USERNAME = '" + username + "'");
		ResultSet rsB = findName.executeQuery();
		ArrayList<Form> list = new ArrayList<>();
		if (rsB.next()){
			role = rsB.getInt(4);
			name = rsB.getString(5);
			
		}
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
			if (rsA.getString(2).equals(name)) {
				System.out.println("MATCH");
				list.add(new Form(rsA.getInt(1), rsA.getString(2), rsA.getString(3), rsA.getString(4), rsA.getString(5), rsA.getString(6), rsA.getString(7), rsA.getDouble(8), rsA.getString(9), rsA.getString(10), rsA.getString(11), rsA.getString(12)));
				
				
			}else if(role == 1 || role == 2) {
				if(rsA.getString(12).equals(name) || rsA.getString(11).equals(name)) {
					System.out.println("MATCH");
					list.add(new Form(rsA.getInt(1), rsA.getString(2), rsA.getString(3), rsA.getString(4), rsA.getString(5), rsA.getString(6), rsA.getString(7), rsA.getDouble(8), rsA.getString(9), rsA.getString(10), rsA.getString(11), rsA.getString(12)));
				}
			}
			
		}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		return json.toString();
		
	}

}
