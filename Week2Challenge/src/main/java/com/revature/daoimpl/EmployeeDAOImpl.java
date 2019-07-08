package com.revature.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.revature.util.ConnFactory;

public class EmployeeDAOImpl {
		public static ConnFactory cf = ConnFactory.getInstance();
		
		public void createEmployee(String empName) throws SQLException {
			Connection conn = cf.getConnection();
			String sql = "{ call INSERTEMPLOYEE(?)";
			CallableStatement call = conn.prepareCall(sql);
			call.setString(1, empName);
			call.execute();
		}
		
		
}
