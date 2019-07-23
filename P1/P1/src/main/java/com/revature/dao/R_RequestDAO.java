package com.revature.dao;

import java.sql.SQLException;
import java.util.List;

import com.revature.beans.R_Request;

public interface R_RequestDAO {

	public abstract void createR_Request(int employeeId, String rDate, String rDescription, double rCost)
		throws SQLException;
	
	public abstract List<R_Request> getR_List()
		throws SQLException;
}
