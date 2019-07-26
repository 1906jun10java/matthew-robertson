package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.R_Request;
import com.revature.dao.R_RequestDAO;
import com.revature.daoimpl.R_RequestDAOImpl;

public class R_RequestServices {

	private R_RequestDAO rrd = new R_RequestDAOImpl(); // this is the only line I have to change to swap out dao implementation

	public R_RequestServices() {
	}
	public List<R_Request> getReqList() throws SQLException {
		return rrd.getReqList();
	}

	public ArrayList<R_Request> getR_RequestById(int id) throws SQLException {
		ArrayList<R_Request> reqList = new ArrayList<>();
		try {
			reqList.addAll(rrd.getR_RequestById(id));
			return reqList;
		} catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean createR_Request(int employeeId, String rDate, String rDescription, double rCost) throws SQLException {
		return true;
	}

	public void updateR_Request() {
		
	}

}
