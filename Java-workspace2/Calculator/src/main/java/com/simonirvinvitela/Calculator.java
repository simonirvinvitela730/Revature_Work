package com.simonirvinvitela;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Calculator extends HttpServlet {
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html");;
		PrintWriter out = response.getWriter();
		out.println("<h1>Welcome to Calculator</h1>");
		
		 String operator = request.getParameter("operator");
		 if(null != operator) {
			 System.out.println("<h1>Your calculation is complete</h1>");
		 }else {
			 out.println("<h1>You have not selected an operation</h1>");
		 }
	}

}