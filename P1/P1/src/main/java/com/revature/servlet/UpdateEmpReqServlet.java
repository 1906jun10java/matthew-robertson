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

@WebServlet("/updateEmpReq")
public class UpdateEmpReqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	//R_RequestServices rrs = new R_RequestServices();
	R_RequestDAOImpl rrd = new R_RequestDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		if(session != null) {
				
			int empId = Integer.parseInt(req.getParameter("employeeId").toString());
				String status = req.getParameter("status");
				
				boolean test = false;
				try {
					test = rrd.updateR_Request(status, empId);
					resp.sendRedirect("ManagerC1.html");
				} catch(SQLException e) {
					e.printStackTrace();
				} 
				
			}
		}

}
