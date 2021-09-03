package com.simonirvinvitela;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class EmployeeList extends HttpServlet{
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		RequestDispatcher rd =  request.getRequestDispatcher("/employeeList.html");
		rd.include(request, response);
		
		for(int i=1; i<=8; i++) {
			try {
				EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
				ArrayList<Employee> employees = dao.getEmployees(i);
				
				/*if(employees.get(i).equals(null)) {
					continue;
				}else {*/
				
					Iterator<Employee> iterator = employees.iterator();
					while(iterator.hasNext()) {
							out.println(iterator.next());
							out.println("<br>");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
		}
		out.close();		
	}

}