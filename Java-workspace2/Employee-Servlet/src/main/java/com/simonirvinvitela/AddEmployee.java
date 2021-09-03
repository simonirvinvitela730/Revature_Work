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

public class AddEmployee extends HttpServlet{
	
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		
		if((name != null) && (name != "") && (email != null) && email != "" && (gender != null) && (gender != "") && (country != null) && (country != "")) {
			
			RequestDispatcher rd =  request.getRequestDispatcher("/addEmployee.html");
			rd.include(request, response);
			
			Employee employee = new Employee();
			employee.setName(name);
			employee.setEmail(email);
			employee.setGender(gender);
			employee.setCountry(country);
				try {
					EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
					dao.addEmployee(employee);
					out.println("Employee has been successfully added!");
					out.println("<br>Welcome "+ name);
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
		}else{
			out.println("All fields must be filled out");
			RequestDispatcher rd =  request.getRequestDispatcher("/addEmployee.html");
			rd.include(request, response);
		}
		out.close();		
	}

}

