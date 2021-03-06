package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.R_Request;
import com.revature.daoimpl.R_RequestDAOImpl;
import com.revature.services.R_RequestServices;

@WebServlet("/empCreateR_Request")
public class EmpCreateR_RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	//R_RequestServices rrs = new R_RequestServices();
	R_RequestDAOImpl rrd = new R_RequestDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if(session != null) {
				
			int empId = Integer.parseInt(session.getAttribute("employeeId").toString());
				String date = req.getParameter("date");
				String description = req.getParameter("description");
				double cost = Double.parseDouble(req.getParameter("cost"));
				String status = "Pending";
				int approvedBy = 0;
				int managerClass = Integer.parseInt(session.getAttribute("managerclass").toString());
				
				boolean test = false;
				try {
					test = rrd.createR_Request(empId, date, description, cost, status, approvedBy, managerClass);
					resp.sendRedirect("Profile.html");
				} catch(SQLException e) {
					e.printStackTrace();
				} 
				
			}
		}

}
