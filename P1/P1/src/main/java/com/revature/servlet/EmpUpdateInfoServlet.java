package com.revature.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.daoimpl.EmployeeDAOImpl;

@WebServlet("/empUpdateInfo")
public class EmpUpdateInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	//R_RequestServices rrs = new R_RequestServices();
	EmployeeDAOImpl edi = new EmployeeDAOImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession(false);
		
		if(session != null) {
				
			int empId = Integer.parseInt(session.getAttribute("employeeId").toString());
				String firstname = req.getParameter("firstname");
				String lastname = req.getParameter("lastname");
				String username = req.getParameter("username");
				String password = req.getParameter("password");
				String email = req.getParameter("email");
				
				boolean test = false;
				try {
					test = edi.updateEmpInfo(empId, firstname, lastname, username, password, email);
					resp.sendRedirect("EmpUpdatePage.html");
				} catch(SQLException e) {
					e.printStackTrace();
				} 
				
			}
		}

}
