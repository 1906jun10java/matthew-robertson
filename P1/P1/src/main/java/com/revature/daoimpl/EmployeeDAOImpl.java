package com.revature.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Employee;
import com.revature.dao.EmployeeDAO;
import com.revature.util.ConnFactory;

public class EmployeeDAOImpl implements EmployeeDAO {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	@Override
	public void createEmployee(String firstName, String lastName, String userName, String passWord, String email, int managerClass) throws SQLException {
		Connection conn = cf.getConnection("database.properties");
		String sql = "INSERT INTO EMPLOYEES VALUES(EMPSEQ.NEXTVAL,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, passWord);
		ps.setString(5, email);
		ps.setInt(6, managerClass);
		ps.executeUpdate();
	}
	
	@Override
	public Employee getEmpById(int id) throws SQLException {
		Connection conn = cf.getConnection("database.properties");
		String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEES_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Employee e = null;
		while(rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
		}
		return e;
	}

	@Override
	public ArrayList<Employee> getEmpListByMClass(int id) throws SQLException {
		ArrayList<Employee> empList = new ArrayList<>();
		Connection conn = cf.getConnection("database.properties");
		String sql = "SELECT * FROM EMPLOYEES WHERE MANAGER_CLASS_ID < ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Employee e = null;
		while(rs.next()) {
			e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
			empList.add(e);
		}
		return empList;
	}
	
	@Override
	public ArrayList<Employee> readEmpList() throws SQLException {
		
		ArrayList<Employee> empList = new ArrayList<Employee>();
		
		try {
				Connection conn = cf.getConnection("database.properties");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES");
				Employee emp = null;
				while(rs.next()) {
					emp = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
					empList.add(emp);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}	
	
	@Override
	public boolean updateEmpInfo(int employeeId, String firstName, String lastName, String userName, String passWord, String email) throws SQLException {
		Connection conn = cf.getConnection("database.properties");
		String sql = "UPDATE EMPLOYEES SET FIRSTNAME = (?), LASTNAME = (?), USERNAME = (?), PASSWORD = (?), EMAIL = (?) WHERE EMPLOYEES_ID = (?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, firstName);
		ps.setString(2, lastName);
		ps.setString(3, userName);
		ps.setString(4, passWord);
		ps.setString(5, email);
		ps.setInt(6, employeeId);
		ps.executeUpdate();
		return true;
	}
}