package com.revature.driver;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.R_Request;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.R_RequestDAOImpl;

public class Driver {
	
	public static void main(String[] args) {
		EmployeeDAOImpl edi = new EmployeeDAOImpl();
		R_RequestDAOImpl rdi = new R_RequestDAOImpl();
		
		try {
			System.out.println(edi.getEmpListByMClass(2));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			rdi.getR_RequestByMClass(2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			edi.createEmployee("Ted", "Logan", "Bogus...", "NotWaynesWorld2", "WildStallions!2@gmail.com", 3);
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
			System.out.println(edi.readEmpList());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*try {
			System.out.println(rdi.getReqList());
		} catch (SQLException e) {
			e.printStackTrace();
		}*/
	}
}
