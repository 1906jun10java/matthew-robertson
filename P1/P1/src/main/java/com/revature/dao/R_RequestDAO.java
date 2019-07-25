package com.revature.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.beans.R_Request;

public interface R_RequestDAO {
	
	public abstract List<R_Request> getReqList()
		throws SQLException;
	
	public ArrayList<R_Request> getR_RequestById(int id) throws SQLException;
	
	public abstract void createR_Request(int employeeId, String rDate, String rDescription, double rCost)
			throws SQLException;
	
	public void updateR_Request();

}
