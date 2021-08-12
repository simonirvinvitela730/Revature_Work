package com.simonirvinvitela;

public class UserDAOFactory {
	
	private static UserDAO dao;
	
	private UserDAOFactory() {}
	
	public static UserDAO getUserDAO() {
		if(dao == null)
			dao = new UserDAOImpl();
		return dao;
	}
}

