package com.simonirvinvitela;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeMain {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
	int option = 0;
	int option2 = 0;
	int option3 = 0;
	
	
	System.out.println("**********");
	System.out.println("Select from the options below");
	System.out.println("**********");
	System.out.println("1 - Employee Login");
	System.out.println("2 - Quit");
	System.out.println("**********");
	
	Scanner in = new Scanner(System.in);
	
	do {
	    try {
	    	System.out.println("Enter your option: ");
			option = in.nextInt();
	    } catch (InputMismatchException e) {
	        System.out.print("Invalid input... ");
	    }
	    in.nextLine(); // clear buffer
	} while (option <= 0);
	
	switch (option) {
	case 1:{
		System.out.println("Employee Login");
		System.out.println("Enter username: ");
		
		String username = in.next();
		
		System.out.println("Enter password: ");
		String password = in.next();
		
		dao.employeeLogin(username, password);
		
		System.out.println("Select from the options below");
		System.out.println("**********");
		System.out.println("1 - Account Approval");
		System.out.println("2 - View Transaction Logs");
		System.out.println("3 - View Account by Account Number");
		System.out.println("4 - Quit");
		System.out.println("**********");
		
		do {
		    try {
		    	System.out.println("Enter your option: ");
				option2 = in.nextInt();
		    } catch (InputMismatchException e) {
		        System.out.print("Invalid input... ");
		    }
		    in.nextLine(); // clear buffer
		} while (option2 <= 0);
		
		switch(option2) {
			case 1:{
				UserDAO dao2 =  UserDAOFactory.getUserDAO();
				int accnum = 0;
				System.out.println("You've selected account approval");
				
				do {
				    try {
				    	System.out.println("Please enter account number for desired account: ");	
						accnum = in.nextInt();
				    } catch (InputMismatchException e) {
				        System.out.print("Invalid input... ");
				    }
				    in.nextLine(); // clear buffer
				} while (accnum <= 0);
				
				
				User user = dao2.getUserById(accnum);
				System.out.println("Account Number: "+user.getAccnum()+"\n"+"Name: "+user.getFirstname()+" "+user.getMiddleinitial()+" "+ user.getLastname()+"\n"+ "Username: "+ user.getUsername()+"\n"+
						"Password: "+ user.getPassword()+"\n"+ "Email: "+user.getEmail()+"\n"+"Age: "+user.getAge());
				
				
				System.out.println("Select from the options below");
				System.out.println("**********");
				System.out.println("1 - Approve Account");
				System.out.println("2 - Decline Account");
				System.out.println("3 - Terminate Account");
				System.out.println("4 - Quit");
				System.out.println("**********");
				do {
				    try {
				    	System.out.println("Enter your option: ");
						option3 = in.nextInt();
				    } catch (InputMismatchException e) {
				        System.out.print("Invalid input... ");
				    }
				    in.nextLine(); // clear buffer
				} while (option3 <= 0);
					
					switch(option3) {
					case 1:{
						dao.accountApproval(accnum);
						dao.accountReview(accnum);
						break;
					}
					
					case 2:{
						dao.accountDeclined(accnum);
						dao.accountReview(accnum);
						break;
					}
					
					case 3:{
						dao.accountTerminated(accnum);
						dao.accountReview(accnum);
						break;
					}
					
					case 4:{
						System.out.println("Exiting...");
						break;
					}
					
					default:{
						System.out.println("Enter a number 1-4");
						break;
					}
				}break;
				
			}
			
			case 2:{
				dao.viewLog();
				break;
			}
			
			case 3:{
				System.out.println("You've selected view account");
				int accnum = 0;
				do {
				    try {
				    	System.out.println("Please enter account number for desired account: ");	
						accnum = in.nextInt();
				    } catch (InputMismatchException e) {
				        System.out.print("Invalid input... ");
				    }
				    in.nextLine(); // clear buffer
				} while (accnum <= 0);
				
				dao.viewAccountById(accnum);
				break;
			}
			
			case 4:{
				System.out.println("Exiting...");
				break;
			}
		}break;
	}
	
	case 2:{
		System.out.println("Exiting...");
		break;
			}
			
	default:{
		System.out.println("Please enter 1 or 2");
		break;
			}
		}
	}
}

