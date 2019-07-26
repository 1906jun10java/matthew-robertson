package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.beans.Credentials;
import com.revature.beans.Employee;
import com.revature.services.AuthenticationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	
	private AuthenticationService authService = new AuthenticationService();

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("LoginP1.html").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		HttpSession session = req.getSession();
		
		//Credentials creds = new Credentials(req.getParameter("username"), req.getParameter("password"));
		Employee e = authService.authenticateEmp(req.getParameter("username"), req.getParameter("password"));
		if (e != null) {
			session.setAttribute("employeeId", e.getEmployeeId());
			session.setAttribute("firstname", e.getFirstName());
			session.setAttribute("lastname", e.getLastName());
			session.setAttribute("username", e.getUserName());
			session.setAttribute("password", e.getPassWord());
			session.setAttribute("email", e.getEmail());
			session.setAttribute("managerclass", e.getManagerClass());
			session.setAttribute("problem", null);
			//resp.sendRedirect("profile");
			
			if(e.getManagerClass() == 1) {
				resp.sendRedirect("profile");
			} else if(e.getManagerClass() == 2) {
				resp.sendRedirect("managerC1");
			}else if(e.getManagerClass() == 3) {
				resp.sendRedirect("managerC2");
			}
			
		} else {
			session.setAttribute("problem", "invalid credentials");
			
			resp.sendRedirect("login");
		}
	}
}
