package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.R_Request;
import com.revature.util.ConnFactory;

public class R_RequestDAOImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	public void createR_Request(int employeeId, String rDate, String rDescription, double rCost) throws SQLException {
		Connection conn = cf.getConnection("database.properties");
		String sql = "INSERT INTO R_REQUEST VALUES(REQSEQ.NEXTVAL,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeId);
		ps.setString(2, rDate);
		ps.setString(3, rDescription);
		ps.setDouble(4, rCost);
		ps.executeUpdate();
	}
	
	public List<R_Request> getReqList() throws SQLException {
		
		List<R_Request> listOfRequests = new ArrayList<>();
		
		try {
				Connection conn = cf.getConnection("database.properties");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM R_REQUEST");
				R_Request req = null;
				while(rs.next()) {
					req = new R_Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5));
					listOfRequests.add(req);
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listOfRequests;
	}
		
	
}
