package com.simonirvinvitela;


public class EmployeeDAOFactory {
	
	private static EmployeeDAO dao;
	
	private EmployeeDAOFactory() {}
	
	public static EmployeeDAO getEmployeeDAO() {
		if(dao == null)
			dao = new EmployeeDAOImpl();
		return dao;
	}
}