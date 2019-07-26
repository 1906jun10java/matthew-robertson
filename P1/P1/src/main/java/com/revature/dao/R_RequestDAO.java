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
	
	public boolean createR_Request(int employeeId, String rDate, String rDescription, double rCost, String status, int managerClass)
			throws SQLException;
	
	public boolean updateR_Request(String status, int requestId) throws SQLException;

	public boolean deleteR_Request(int id) throws SQLException;

	public ArrayList<R_Request> getR_RequestByMClass(int id) throws SQLException;

}
