package com.simonirvinvitela;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;

import org.junit.jupiter.api.*;

class TestGetUserById {
	
	@Test
	void testUserById() throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		int accnum = 1;
		User user = dao.getUserById(accnum);
		assertEquals(user.getAccnum(), 1);
		assertEquals(user.getUsername(), "siv212");
		assertEquals(user.getPassword(), "password");
		assertEquals(user.getAge(), 23);
		assertEquals(user.getEmail(), "simon.irvinvitela@revature.net");
		System.out.println("Account: "+accnum+" tested...");
		
		int accnum2 = 2;
		User user2 = dao.getUserById(accnum2);
		assertEquals(user2.getAccnum(), 2);
		assertEquals(user2.getUsername(), "monique1");
		assertEquals(user2.getPassword(), "blue"); //returns false
		assertEquals(user2.getAge(), 24);
		assertEquals(user2.getEmail(), "moniquesimmon1@gmail.com");
		System.out.println("Account: "+accnum2+" tested...");
	}

}
