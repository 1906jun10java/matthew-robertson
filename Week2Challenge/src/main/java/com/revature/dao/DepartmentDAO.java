package com.revature.dao;

import java.sql.SQLException;

public interface DepartmentDAO {
	
	public abstract void createDepartment(String departmentName)
			throws SQLException;
}
