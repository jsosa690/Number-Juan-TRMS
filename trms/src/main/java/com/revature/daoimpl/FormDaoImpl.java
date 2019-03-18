package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.dao.FormDao;
import com.revature.util.ConnFactory;

public class FormDaoImpl implements FormDao{

	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void submitForm(String fullName, String date, String startTime, String endTime, String location,
			String description, Double cost, String gradingFormat, String eventType, String supervisor, String deptHead, String benCo) {
		Connection conn = cf.getConnection();
		String sql = "{ call FORMENTRY(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		CallableStatement cs;
		try {
			cs = conn.prepareCall(sql);
			cs.setString(1, fullName);
			cs.setString(2, date);
			cs.setString(3, startTime);
			cs.setString(4, endTime);
			cs.setString(5, location);
			cs.setString(6, description);
			cs.setDouble(7, cost);
			cs.setString(8, gradingFormat);
			cs.setString(9, eventType);
			cs.setString(10, supervisor);
			cs.setString(11, deptHead);
			cs.setString(12, benCo);
			cs.execute();
			System.out.println("Form entered");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateForm(int account, int position, String decision, String comment) {
		if(position == 2) {
			// supervisor usertype = 2
			Connection conn = cf.getConnection();
			String sql = "{ call SUPERVISORUPDATE( ?, ?, ?)";
			CallableStatement cs;
			try {
				cs = conn.prepareCall(sql);
				cs.setInt(1, account);
				cs.setString(2, decision);
				cs.setString(3, comment);
				cs.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(!decision.equals("Approved")) {
				sql = "{ call HEADUPDATE( ?, ?, ?)";
				try {
					cs = conn.prepareCall(sql);
					cs.setInt(1, account);
					cs.setString(2, decision);
					cs.setString(3, comment);
					cs.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String logic = "{ call BENCOUPDATE( ?, ?, ?)";
				CallableStatement cs1;
				try {
					cs1 = conn.prepareCall(logic);
					cs1.setInt(1, account);
					cs1.setString(2, decision);
					cs1.setString(3, " ");
					cs1.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(position == 3) {
			// dept head usertype = 3;
			Connection conn = cf.getConnection();
			String sql = "{ call HEADUPDATE( ?, ?, ?)";
			CallableStatement cs;
			try {
				cs = conn.prepareCall(sql);
				cs.setInt(1, account);
				cs.setString(2, decision);
				cs.setString(3, comment);
				cs.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			if(!decision.equals("Approved")) {
				String logic = "{ call BENCOUPDATE( ?, ?, ?)";
				CallableStatement cs1;
				try {
					cs1 = conn.prepareCall(logic);
					cs1.setInt(1, account);
					cs1.setString(2, decision);
					cs1.setString(3, " ");
					cs1.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		if(position == 4) {
			// benco usertype = 4;
			Connection conn = cf.getConnection();
			String sql = "{ call BENCOUPDATE( ?, ?, ?)";
			CallableStatement cs;
			try {
				cs = conn.prepareCall(sql);
				cs.setInt(1, account);
				cs.setString(2, decision);
				cs.setString(3, comment);
				cs.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			/*
			if(decision.equals("Approved")) {
				String logic = "{ call TOTALCHANGE(?,?)";
				CallableStatement cs1;
				try {
					cs1 = conn.prepareCall(logic);
					cs1.setInt(1, account);
					cs1.setDouble(2, reimbursement);
					cs1.execute();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}*/
		}
	}

}
