package com.revature.daoimpl;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.revature.dao.FormDao;
import com.revature.util.ConnFactory;
public class FormDaoImpl implements FormDao{
<<<<<<< HEAD

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
	
	public void updateForm(int account, int position, String decision, String comment)throws SQLException{
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
			if(decision.contains("dis")) {
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
			
			if(decision.equals("Approved")) {
				String logic = "{ call TOTALCHANGE(?,?)";
				CallableStatement cs1;
				Double comparator;
				Double reimbursement;
				PreparedStatement statement = conn.prepareStatement("SELECT REIMBURSEMENT FROM TRMS_USER WHERE FULLNAME = WHERE FULLNAME = (SELECT FULLNAME FROM FINALDECISION WHERE FORMID = '" + account + "')");
				ResultSet rsA = statement.executeQuery();
				comparator = rsA.getDouble(1);
				
				PreparedStatement statement2 = conn.prepareStatement("SELECT EVENTTYPE FROM FINALDECISION WHERE FORMID = '" + account + "'");
				ResultSet rsB = statement2.executeQuery();
				String casetype = rsB.getString(1);
				
				PreparedStatement statement3 = conn.prepareStatement("SELECT EVENTCOST FROM FINALDECISION WHERE FORMID = '" + account + "'");
				ResultSet rsC = statement3.executeQuery();
				reimbursement = rsC.getDouble(1);
				
				if(casetype.equals("University Class")) {
					reimbursement = reimbursement*0.8;
				}else if(casetype.equals("Seminar")) {
					reimbursement = reimbursement*0.6;
				}else if(casetype.equals("Certificate Class")) {
					reimbursement = reimbursement*0.75;
				}else if(casetype.equals("Certification")) {
					
				}else if(casetype.equals("Technical Training")) {
					reimbursement = reimbursement*0.9;
				}else if(casetype.equals("Other")) {
					reimbursement = reimbursement*0.3;
				}
				if(reimbursement <= comparator) {
					cs1 = conn.prepareCall(logic);
					cs1.setInt(1, account);
					cs1.setDouble(2, reimbursement);
					cs1.execute();
				}else {
					System.out.println("TOO MUCH");
				}
					
			}
		}
	}

}
=======
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
    
    public void updateForm(int account, int position, String decision, String comment)throws SQLException{
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
            if(decision.contains("dis")) {
            	System.out.println("sucks");
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
            if(decision.contains("dis")) {
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
            
            if(decision.contains("dis")) {
                String logic = "{ call TOTALCHANGE(?,?)";
                CallableStatement cs1;
                Double comparator;
                Double reimbursement;
                PreparedStatement statement = conn.prepareStatement("SELECT REIMBURSEMENT FROM TRMS_USER WHERE FULLNAME = WHERE FULLNAME = (SELECT FULLNAME FROM FINALDECISION WHERE FORMID = '" + account + "')");
                ResultSet rsA = statement.executeQuery();
                comparator = rsA.getDouble(1);
                
                PreparedStatement statement2 = conn.prepareStatement("SELECT EVENTTYPE FROM FINALDECISION WHERE FORMID = '" + account + "'");
                ResultSet rsB = statement2.executeQuery();
                String casetype = rsB.getString(1);
                
                PreparedStatement statement3 = conn.prepareStatement("SELECT EVENTCOST FROM FINALDECISION WHERE FORMID = '" + account + "'");
                ResultSet rsC = statement3.executeQuery();
                reimbursement = rsC.getDouble(1);
                
                if(casetype.equals("University Class")) {
                    reimbursement = reimbursement*0.8;
                }else if(casetype.equals("Seminar")) {
                    reimbursement = reimbursement*0.6;
                }else if(casetype.equals("Certificate Class")) {
                    reimbursement = reimbursement*0.75;
                }else if(casetype.equals("Certification")) {
                    
                }else if(casetype.equals("Technical Training")) {
                    reimbursement = reimbursement*0.9;
                }else if(casetype.equals("Other")) {
                    reimbursement = reimbursement*0.3;
                }
                if(reimbursement <= comparator) {
                    cs1 = conn.prepareCall(logic);
                    cs1.setInt(1, account);
                    cs1.setDouble(2, reimbursement);
                    cs1.execute();
                }else {
                    System.out.println("TOO MUCH");
                }
                    
            }
        }
    }
}
>>>>>>> 4f0ff62805c57caa3a1ae1021e083892dac8dd3c
