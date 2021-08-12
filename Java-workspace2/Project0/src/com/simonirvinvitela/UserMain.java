package com.simonirvinvitela;

	import java.sql.*;
	import java.util.*;
	import org.apache.log4j.*;

	public class UserMain {
		
	private  static  final Logger logger = LogManager.getLogger(UserMain.class);
		
		public static void main(String[] args) throws SQLException{
			
			UserDAO dao =  UserDAOFactory.getUserDAO();
			int option = 0;
			int option2 = 0;
			
			System.out.println("**********");
			System.out.println("Select from the options below");
			System.out.println("**********");
			System.out.println("1 - Create New User");
			System.out.println("2 - Existing User Login");
			System.out.println("3 - Quit");
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
				System.out.println("You've selected Create New User");
				System.out.println("Enter first name: ");
				String firstname = in.next();
				
				System.out.println("Enter middle initial: ");
				String middleinitial = in.next();
				
				System.out.println("Enter last name: ");
				String lastname = in.next();
				
				System.out.println("Enter age: ");
				int age = in.nextInt();
				
				System.out.println("Enter email: ");
				String email = in.next();
				
				System.out.println("Enter username: ");
				String username = in.next();
				
				System.out.println("Enter password: ");
				String password = in.next();
				
				System.out.println("Please re-enter password to confirm: ");
				String passwordconfirm = in.next();
				
				while(!password.equals(passwordconfirm)) {
					System.out.println("The password you entered did not match the previous password entered");
					System.out.println("Please try again");
					
					System.out.println("Enter password: ");
					String password2 = in.next();
					
					System.out.println("Please re-enter password to confirm: ");
					String passwordconfirm2 = in.next();
					
					password = password2;
					passwordconfirm = passwordconfirm2;
				}
					User user = new User();
					user.setFirstname(firstname);
					user.setMiddleinitial(middleinitial);
					user.setLastname(lastname);
					user.setAge(age);
					user.setEmail(email);
					user.setUsername(username);
					user.setPassword(password);
					dao.createNewUser(user);
				break;
				
				}
			
			case 2:{
				User user = new User();
				Account account = new Account();
				
				System.out.println("Please enter username: ");
				String username = in.next();
				
				System.out.println("Please enter password: ");
				String password = in.next();
				
				user.setUsername(username);
				user.setPassword(password);
				
				User newuser = dao.getUserByLogin(username, password);
				
				int accnumber = newuser.getAccnum();
				
				account = dao.getAccountById(accnumber); 
				
				String status = newuser.getStatus();
				
				System.out.println("Select from the options below");
				System.out.println("**********");
				System.out.println("1 - Create New Account");
				System.out.println("2 - Check Balance");
				System.out.println("3 - Withdraw Funds");
				System.out.println("4 - Deposit Funds");
				System.out.println("5 - Money Transfer Proposal");
				System.out.println("6 - Review Transfer Proposal");
				System.out.println("7 - Transfer Funds");
				System.out.println("8 - Quit");
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
						EmployeeDAO dao2 =  EmployeeDAOFactory.getEmployeeDAO();
						if(status == null) {
						System.out.println("Thank you for selecting create new account");
						System.out.println("To open an account you must make an initial deposit of at least $200");
						System.out.println("After depositing an inital amount, your account will be processed and pending approval");
						System.out.println("Customers are limited to one account per user");
						System.out.println("Please allow 1-2 business days for this process");
						System.out.println("Rules and exceptions may apply");
						
						System.out.println("Please enter a starting balance to deposit: ");
						double balance = in.nextDouble();
						
						user.setAccnum(accnumber);
						user.setBalance(balance);
						
						dao.addAccount(user);
						dao2.accountPending(accnumber);
						
						}else if(status.equals("pending"))
							System.out.println("Account awaiting approval");
						else if(status.equals("declined")) {
							System.out.println("Your account has been declined");
							System.out.println("Please contatct our help line at 1-800-NEED-HELP");
						}else if(status.equals("closed")) {
							System.out.println("Your account has been closed");
							System.out.println("You may apply for a new account");
							dao2.deleteAccount(accnumber);
							dao2.accountReset(accnumber);
						}else if(status.equals("active")){
							System.out.println("You already have an active account");
						}
						
						break;
						
						}
					case 2:{
						if(status.equals("active")) {
						System.out.println("Thank you for selecting Check Balance");
						dao.printAccountById(accnumber);
						break;
						}else {
							System.out.println("Must have an active account to complete this operation");
							break;
						}
					}
					case 3:{
						if(status.equals("active")) {
						System.out.println("Thank you for selecting withdraw funds");
						
						System.out.println("Please enter amount to withdraw");
						double amount = in.nextDouble();
						
						
						double transaction = account.getBalance() - amount;
						
						if(account.getBalance() > amount) {
							
							dao.setAccountBalance(transaction, accnumber);
							dao.setUserBalance(transaction, accnumber);
							
							logger.info("Account: "+accnumber+" withdrawing funds...");
						}else {
							System.out.println("Insufficient funds");
						}
						
						break;
						}else {
							System.out.println("Must have an active account to complete this operation");
							break;
						}
					}
					case 4:{
						if(status.equals("active")) {
						System.out.println("Thank you for selecting deposit funds");
						
						System.out.println("Please enter amount to deposit");
						double amount = in.nextDouble();
		
						double transaction = account.getBalance() + amount;
						
						dao.setAccountBalance(transaction, accnumber);
						dao.setUserBalance(transaction, accnumber);
						logger.info("Account: "+accnumber+" depositing funds...");
						break;
						}else {
							System.out.println("Must have an active account to complete this operation");
							break;
						}
					}
					
					case 5:{
						if(status.equals("active")) {
						System.out.println("Please enter the account number for the account you wish to transfer funds to...");
						int accnum2 = in.nextInt();
						dao.transferRequest(accnumber, accnum2);
						break;
						}else {
							System.out.println("Must have an active account to complete this operation");
							break;
						}
						
					}
					
					case 6:{
						if(status.equals("active")) {
						System.out.println("Please enter the account number for the account who's transfer you would like to review");
						int accnum2 = in.nextInt();
						dao.processTransferRequest(accnumber, accnum2);
						break;
						}else {
							System.out.println("Must have an active account to complete this operation");
							break;
						}
						
					}
					
					case 7:{
						if(status.equals("active")) {
							System.out.println("Please enter the account number for the account you wish to transfer funds to...");
							int accnum2 = in.nextInt();
							dao.transferFunds(accnumber, accnum2);
							
							logger.info("Account: "+accnumber+" transfered funds to Account: "+accnum2);
							break;
						}else {
							System.out.println("Must have an active account to complete this operation");
							break;
						}
						
					}
					
					case 8:{
						System.out.println("Exiting...");
						System.out.println("Goodbye.");
						break;
					}
					default:{
						System.out.println("Please enter a number 1-7");
						break;
					}
				
				}break;
			}
			
			case 3:{
				System.out.println("Exiting...");
				System.out.println("Goodbye.");
				break;
			}
			
			default:{
				System.out.println("Please enter a number 1-3");
				break;
			}
		}
	}
}
