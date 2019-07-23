package com.revature.services;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.daoimpl.EmployeeDAOImpl;

public class AuthenticationService {

	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	
	public AuthenticationService() {
		
	}
	
	public Employee authenticateEmp(String username, String password) {
		ArrayList<Employee> emps = new ArrayList<>();
		Employee e = null;
		try {
			emps = edi.readEmpList();
			if(emps != null) {
				for (Employee emp : emps) {
					if(username.equals(emp.getUserName()) && password.equals(emp.getPassWord())) {
						e = new Employee(emp.getEmployeeId(), emp.getFirstName(), emp.getLastName(), emp.getUserName(), emp.getPassWord(), emp.getEmail(), emp.getManagerClass());
					}
				}
			}
		}catch(SQLException e1) {
			e1.printStackTrace();
		}
		return e;
	}
}
