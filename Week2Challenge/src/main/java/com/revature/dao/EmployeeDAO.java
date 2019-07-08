package com.revature.dao;

import java.sql.SQLException;

public interface EmployeeDAO {

	public abstract void createEmployee(String empName)
			throws SQLException;
}
