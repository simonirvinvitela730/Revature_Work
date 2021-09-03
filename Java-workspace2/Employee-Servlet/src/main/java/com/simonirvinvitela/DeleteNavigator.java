package com.simonirvinvitela;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DeleteNavigator extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
			Employee employee = dao.getEmployeeById(id);
			
			out.println("Employee id: "+employee.getId());
			out.println("Employee name: "+ employee.getName());
			out.println("Employee email: "+ employee.getEmail());
			out.println("Employee gender: "+ employee.getGender());
			out.println("Employee country: "+ employee.getCountry());
			
			RequestDispatcher rd =  request.getRequestDispatcher("/deleteEmployee.html");
			rd.include(request, response);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	
		out.close();		
	}

}