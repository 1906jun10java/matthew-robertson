package com.revature.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.Employee;

@WebServlet("/session")
public class SessionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("employeeId") != null) {
			try {
				int employeeId = Integer.parseInt(session.getAttribute("employeeId").toString());
				String firstname = session.getAttribute("firstname").toString();
				String lastname = session.getAttribute("lastname").toString();
				String username = session.getAttribute("username").toString();
				String password = session.getAttribute("password").toString();
				String email = session.getAttribute("email").toString();
				int managerclass = Integer.parseInt(session.getAttribute("managerclass").toString());
				Employee e = new Employee(employeeId, firstname, lastname, username, password, email, managerclass);
				resp.getWriter().write((new ObjectMapper()).writeValueAsString(e));
			} catch (Exception e1) {
				e1.printStackTrace();
				resp.getWriter().write("{\"session\":null}");
			}
		} else {
			resp.getWriter().write("{\"session\":null}");
		}
	}
}
