package com.revature.driver;

import java.sql.SQLException;

import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.R_RequestDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		R_RequestDAOImpl rdi = new R_RequestDAOImpl();
		
		/*try {
			edi.createEmployee("Matthew", "Robertson", "LavaLamp", "password", "matthew@gmail.com", 2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			rdi.createR_Request(43, "01-14-1991", "Life Expense", 1.00);
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(edi.getEmpList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			System.out.println(rdi.getReqList());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
