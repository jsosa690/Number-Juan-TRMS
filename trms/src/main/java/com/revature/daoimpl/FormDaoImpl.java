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
			String description, Double cost, String gradingFormat, String eventType, String supervisor, String benCo) {
		Connection conn = cf.getConnection();
		String sql = "{ call FORMENTRY(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			cs.setString(11, benCo);
			cs.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
