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

public class DeleteEmployee extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			RequestDispatcher rd =  request.getRequestDispatcher("/deleteEmployee.html");
			rd.include(request, response);
			
		
				try {
					EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
					dao.deleteEmployee(id);
					out.println("Employee has been successfully deleted!");
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
					
		}catch (NumberFormatException e) {
			out.println("Employee has not been deleted");
			RequestDispatcher rd2 =  request.getRequestDispatcher("/deleteById.html");
			rd2.include(request, response);
		}out.close();
	}
}
