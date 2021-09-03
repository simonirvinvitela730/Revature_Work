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

public class UpdateEmployee extends HttpServlet{
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		String country = request.getParameter("country");
		int id = Integer.parseInt(request.getParameter("id"));
		
		if((name != null) && (name != "") && (email != null) && email != "" && (gender != null) && (gender != "") && (country != null) && (country != "") && (id != 0)) {
			
			RequestDispatcher rd =  request.getRequestDispatcher("/updateEmployee.html");
			rd.include(request, response);
			
			Employee employee = new Employee();
			employee.setName(name);
			employee.setEmail(email);
			employee.setGender(gender);
			employee.setCountry(country);
			employee.setId(id);
			
				try {
					EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
					dao.updateEmployee(employee);
					out.println("Employee has been successfully updated!");
				} catch (SQLException e) {
					e.printStackTrace();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			
			
		}else{
			out.println("All fields must be filled out");
			RequestDispatcher rd =  request.getRequestDispatcher("/updateEmployee.html");
			rd.include(request, response);
		}
		out.close();		
	}

}

