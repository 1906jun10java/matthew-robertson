package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.R_Request;
import com.revature.dao.R_RequestDAO;
import com.revature.util.ConnFactory;

public class R_RequestDAOImpl implements R_RequestDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();

	@Override
	public boolean createR_Request(int employeeId, String rDate, String rDescription, double rCost, String status, int managerClass) throws SQLException {
		Connection conn = cf.getConnection("database.properties");
		String sql = "INSERT INTO R_REQUEST VALUES(REQSEQ.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, employeeId);
		ps.setString(2, rDate);
		ps.setString(3, rDescription);
		ps.setDouble(4, rCost);
		ps.setString(5, status);
		ps.setInt(6, managerClass);
		ps.executeUpdate();
		return true;
	}
	
	@Override
	public ArrayList<R_Request> getR_RequestById(int id) throws SQLException {
		ArrayList<R_Request> reqList = new ArrayList<>();
		Connection conn = cf.getConnection("database.properties");
		String sql = "SELECT * FROM R_REQUEST WHERE EMPLOYEES_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		R_Request r = null;
		while(rs.next()) {
			r = new R_Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getInt(7));
			reqList.add(r);
		}
		return reqList;
	}
	
	/*@Override
	public R_Request getR_RequestById(int id) throws SQLException {
		Connection conn = cf.getConnection("database.properties");
		String sql = "SELECT * FROM R_REQUEST WHERE REQUEST_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		R_Request r = null;
		while(rs.next()) {
			r = new R_Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5));
		}
		return r;
	}*/
	
	public List<R_Request> getReqList() throws SQLException {
		
		List<R_Request> listOfRequests = new ArrayList<>();
		
		try {
				Connection conn = cf.getConnection("database.properties");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM R_REQUEST");
				R_Request req = null;
				while(rs.next()) {
					req = new R_Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getString(6), rs.getInt(7));
					listOfRequests.add(req);
				}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listOfRequests;
	}

	@Override
	public ArrayList<R_Request> getR_RequestByMClass(int id) throws SQLException {
		ArrayList<R_Request> reqList = new ArrayList<>();
		Connection conn = cf.getConnection("database.properties");
		String sql = "SELECT * FROM R_REQUEST WHERE MANAGER_CLASS_ID < ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		R_Request r = null;
		while(rs.next()) {
			r = new R_Request(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getString(6), rs.getInt(7));
			reqList.add(r);
		}
		return reqList;
	}
	
	@Override
	public boolean deleteR_Request(int requestId) throws SQLException {
		Connection conn = cf.getConnection("database.properties");
		String sql = "DELETE FROM R_REQUEST WHERE REQUEST_ID(?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, requestId);
		ps.executeUpdate();
		return true;
	}
	
	@Override
	public void updateR_Request() {
		
	}

		
	
}
