package com.simonirvinvitela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;


public class UserDAOImpl implements UserDAO{
	
	//private  static  final Logger logger = LogManager.getLogger(UserDAOImpl.class);
	
	private static Statement statement = null;
	private static Statement statement2 = null;
	private static Statement statement3 = null;
	private static Statement statement4 = null;
    Connection connection = null;

    public UserDAOImpl()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    
	@Override
	public void createNewUser(User user) throws SQLException {
		String sql = "insert into users (firstname, middleinitial, lastname, age, email, username, password) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getFirstname());
        preparedStatement.setString(2, user.getMiddleinitial());
        preparedStatement.setString(3, user.getLastname());
        preparedStatement.setInt(4, user.getAge());
        preparedStatement.setString(5, user.getEmail());
        preparedStatement.setString(6, user.getUsername());
        preparedStatement.setString(7, user.getPassword());
        int count = preparedStatement.executeUpdate();
        if(count > 0)
            System.out.println("new user created");
        else
            System.out.println("Oops! something went wrong");
	}

	@Override
	public void addAccount(User user) throws SQLException {
		String sql = "insert into accounts (accnum, balance, status) values (?, ?, 'pending')";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
	    preparedStatement.setInt(1, user.getAccnum());
	    preparedStatement.setDouble(2, user.getBalance());
	    if(user.getBalance()<200) {
	    	System.out.println("Must make an inital deposit of at least $200");
	    }else {
	    	int count = preparedStatement.executeUpdate();
	    	if(count > 0)
            System.out.println("new account pending");
	    		else
            System.out.println("Oops! something went wrong");
		
	    }
	}

	@Override
	public double getBalance(int accnum) throws SQLException {
		
		/*ConsoleAppender consoleAppender = new ConsoleAppender();
	    consoleAppender.setThreshold(Level.INFO);
	    consoleAppender.setLayout(new PatternLayout("%d{HH:mm:ss.SSS} %-5level %class{36} %L %M - %msg%xEx%n"));
	    consoleAppender.activateOptions();
	    LogManager.getRootLogger().addAppender(consoleAppender);*/
	    
		Account account = new Account();
		
		String sql = "select balance from accounts where accnum ="+accnum;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			double balance = resultSet.getDouble(1);
			account.setBalance(balance);
		}return account.getBalance();
		
	}
	
	@Override
	public void setAccountBalance(double balance, int accnum) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		Account account = new Account();
		
		String sql = "update accounts set balance = ? where accnum ="+accnum;
	    
		account.setBalance(balance);
		
	    PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, account.getBalance());
        
        int count = preparedStatement.executeUpdate();
        dao.startTransaction();
        if(count > 0) {
            System.out.println("Account "+accnum+" updated...");
            dao.commit();
        }
        else
            System.out.println("Oops! something went wrong");
        	dao.rollback();   
	}
	
	@Override
	public void setUserBalance(double balance, int accnum) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		User user = new User();

		String sql = "update users set balance = ? where accnum ="+accnum;
		
		user.setBalance(balance);
	    
		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
		 preparedStatement.setDouble(1, user.getBalance());
		 int count = preparedStatement.executeUpdate();
	     dao.startTransaction();  
	        if(count > 0) {
	            System.out.println("User "+accnum+" updated...");
	            dao.commit();
	        }
	        else
	            System.out.println("Oops! something went wrong");
	        	dao.rollback();
		}

	@Override
	public void transferFunds(int accnum, int accnum2) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		Scanner in = new Scanner(System.in);
		String transferStatus1 = dao.getTransferStatusById(accnum);
		String transferStatus2 = dao.getTransferStatusById(accnum2);
		String sql = "select balance from accounts where accnum ="+accnum;
		String sql2 = "select balance from accounts where accnum ="+accnum2;
		
		statement = connection.createStatement();
		statement2 = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	ResultSet resultSet2 = statement2.executeQuery(sql2);
    	
    	if((transferStatus1 == null) || (transferStatus2 == null)) {
    		System.out.println("No active transfer requests in progress");
    	}else if(transferStatus1.equals("accepted")) {
    		System.out.println("Transfer Request has been accepted");
    		while(resultSet.next() && resultSet2.next()) {
        		double balance1 = resultSet.getDouble(1);
        		double balance2 = resultSet2.getDouble(1);
        		
        		dao.startTransaction();
        		
        		System.out.println("Enter amount to transfer from your account to Account: "+accnum2);
        		double amount = in.nextDouble();
        		
        		
        		if(amount < balance1) {
        		double transaction1 = (balance1 - amount);
        		double transaction2 = (balance2 + amount);
        		
        		dao.setAccountBalance(transaction1, accnum);
        		dao.setAccountBalance(transaction2, accnum2);
    			dao.setUserBalance(transaction1, accnum);
    			dao.setUserBalance(transaction2, accnum2);
    			
    			System.out.println(" ");
        		
    			dao.commit();
    			System.out.println("Funds have been successfully transfered from Account:"+accnum+" to Account:"+accnum2);
    			String sql3 = "update users set transfer_status = null where accnum="+accnum;
				String sql4 = "update users set transfer_status = null where accnum="+accnum2;
				
				statement3 = connection.createStatement();
    			statement4 = connection.createStatement();
				
				int update1 = statement3.executeUpdate(sql3);
		    	int update2 = statement4.executeUpdate(sql4);
    			
    		
        		}else {
        			System.out.println("Insufficient funds");
        			dao.rollback();
        		}
    	}
    	
    }else if(transferStatus1.equals("pending")) {
    	System.out.println("Transfer status is still pending");
    	System.out.println("Awaiting response from Account: "+accnum2);
    }else if(transferStatus1.equals("declined")) {
    	System.out.println("Transfer request has been declined");
    }else if(transferStatus1.equals("sent")) {
    	System.out.println("Transfer status sent awaiting response from Account: "+accnum2);
    }
}
	
	@Override
	public void transferRequest(int accnum, int accnum2) throws SQLException {
		String sql2 = "update users set transfer_status = 'pending' where accnum="+accnum2;
		String sql = "update users set transfer_status = 'sent' where accnum="+accnum;
		
		statement = connection.createStatement();
		statement2 = connection.createStatement();
		
		int update = statement.executeUpdate(sql);
    	int update2 = statement2.executeUpdate(sql2);
		
    	System.out.println("Your transfer request has been sent and is pending approval from Account: "+accnum2);
	}
	
	@Override
	public String getTransferStatusById(int accnum) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		User user = dao.getUserById(accnum);
		String sql = "select transfer_status from users where accnum ="+accnum;
		
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			String transferStatus = resultSet.getString(1);
			user.setTransferStatus(transferStatus);
			
		}return user.getTransferStatus();
	}
	
	@Override
	public String getStatusById(int accnum) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		User user = dao.getUserById(accnum);
		String sql = "select status from users where accnum ="+accnum;
		
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()){
			String status = resultSet.getString(1);
			user.setStatus(status);
			
		}return user.getStatus();
	}


	@Override
	public void processTransferRequest(int accnum, int accnum2) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		Scanner in = new Scanner(System.in);
		int option = 0;
		
		String transferStatus1 = dao.getTransferStatusById(accnum);
		String transferStatus2 = dao.getTransferStatusById(accnum2);
		
		if(transferStatus1 == null) {
			System.out.println("No pending transfer proposals");
		}else if(transferStatus1.equals("pending")) {
			System.out.println("You've recieved a transfer proposal");
			System.out.println("Please select an option: ");
			System.out.println("1 - Accept Transfer Proposal");
			System.out.println("2 - Decline Transfer Proposal");
			
			do {
			    try {
			    	System.out.println("Enter your option: ");
					option = in.nextInt();
			    } catch (InputMismatchException e) {
			        System.out.print("Invalid input... ");
			    }
			    in.nextLine(); //clear buffer
			} while (option <= 0);
			
			switch(option) {
			
			case 1:{
				String sql = "update users set transfer_status = 'accepted' where accnum="+accnum;
				String sql2 = "update users set transfer_status = 'accepted' where accnum="+accnum2;
				
				statement = connection.createStatement();
				statement2 = connection.createStatement();
		    	int update1 = statement.executeUpdate(sql);
		    	int update2 = statement2.executeUpdate(sql2);
		    	
		    	System.out.println("Transfer proposal accepted awaiting transfer from Account: "+accnum2);
				break;
			}
			case 2:{
				String sql = "update users set transfer_status = 'declined' where accnum="+accnum;
				String sql2 = "update users set transfer_status = 'declined' where accnum="+accnum2;
				
				statement = connection.createStatement();
				statement2 = connection.createStatement();
		    	int update1 = statement.executeUpdate(sql);
		    	int update2 = statement2.executeUpdate(sql2);
		    	
		    	System.out.println("Transfer proposal declined have a good day");
				break;
			}
			
			}
		}else if(transferStatus1.equals("accepted")) {
			System.out.println("Transfer has been accepted awaiting response from Account: "+accnum2);
    	}else if(transferStatus1.equals("declined")){
    		String sql = "update users set transfer_status = null where accnum="+accnum;
			String sql2 = "update users set transfer_status = null where accnum="+accnum2;
			
			statement = connection.createStatement();
			statement2 = connection.createStatement();
	    	int update1 = statement.executeUpdate(sql);
	    	int update2 = statement2.executeUpdate(sql2);
	    	
	    	System.out.println("Transfer proposal was declined");
    	}else if(transferStatus1.equals("sent")) {
    		System.out.println("Transfer proposal was sent awaiting response from Account: "+accnum2);
    	}
	}

	
	
	@Override
	public User getUserById(int accnum) throws SQLException {
		User user = new User();
		String sql = "call getUserByAccnum("+accnum+")";
		statement = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
           	String email = resultSet.getString(2);
           	String username = resultSet.getString(3);
           	String password = resultSet.getString(4);
           	int age = resultSet.getInt(5);
           	String firstname = resultSet.getString(6);
           	String middleinitial = resultSet.getString(7);
           	String lastname = resultSet.getString(8);
           	
           	user.setAccnum(accnum);
           	user.setFirstname(firstname);
			user.setMiddleinitial(middleinitial);
			user.setLastname(lastname);
			user.setAge(age);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
           	
    	}
		
		return user;
		
	}

	@Override
	public Account getAccountById(int accnum) throws SQLException {
		Account account = new Account();
		String sql = "call getAccountByAccnum("+accnum+")";
		statement = connection.createStatement();
		
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
    		double balance = resultSet.getDouble(2);
    		String status = resultSet.getString(3);

    		account.setAccnum(accnum);
    		account.setBalance(balance);
    		account.setStatus(status);
    	} return account;
	}
	
	@Override
	public Account printAccountById(int accnum) throws SQLException {
		Account account = new Account();
		UserDAO dao =  UserDAOFactory.getUserDAO();
		String sql = "call getAccountByAccnum("+accnum+")";
		statement = connection.createStatement();
	
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
    		double balance = resultSet.getDouble(2);
    		String status = resultSet.getString(3);

    		account.setAccnum(accnum);
    		account.setBalance(balance);
    		account.setStatus(status);
    		
    		System.out.println("Account Number: "+accnum+"\n"+"Balance: "+balance+"\n"+"Account Status: "+status);
    	} return account;
	}

	@Override
	public void startTransaction() throws SQLException {
		String sql = "start transaction";
		statement = connection.createStatement();
    	statement.executeQuery(sql);
		
	}

	@Override
	public void rollback() throws SQLException {
		String sql = "rollback";
		statement = connection.createStatement();
    	statement.executeQuery(sql);
		
	}

	@Override
	public void commit() throws SQLException {
		String sql = "commit";
		statement = connection.createStatement();
    	statement.executeQuery(sql);
	}
	
	@Override
	public User getUserByLogin(String username, String password) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		Scanner in = new Scanner(System.in);
		User user = new User();
		ArrayList list = dao.userList(username, password);
		String sql = "select * from users where username = '"+username+"' and password = '"+password+"'";
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		if(list.isEmpty()) {
			User user2 = new User();
			System.out.println("Incorrect username or password...");
    		System.out.println("Please re-enter username: ");
    		String username2 = in.next();
		
    		System.out.println("Please re-enter password: ");
    		String password2 = in.next();
		
    		user2.setUsername(username);
    		user2.setPassword(password);
			
    		User newuser = dao.getUserByLogin(username2, password2);
    		
    		String status = dao.getStatusById(newuser.getAccnum());
			
			newuser.setStatus(status);
			
    		return newuser;
		}else{
		
		while(resultSet.next()) {
    			int accnum = resultSet.getInt(1);
    			String email = resultSet.getString(2);
               	int age = resultSet.getInt(5);
               	String firstname = resultSet.getString(6);
               	String middleinitial = resultSet.getString(7);
               	String lastname = resultSet.getString(8);
               	
               	user.setAccnum(accnum);
               	user.setFirstname(firstname);
    			user.setMiddleinitial(middleinitial);
    			user.setLastname(lastname);
    			user.setAge(age);
    			user.setEmail(email);
    			user.setUsername(username);
    			user.setPassword(password);
               	
    			String status = dao.getStatusById(accnum);
				
				user.setStatus(status);
				
               	System.out.println("Welcome "+user.getFirstname()+" "+user.getLastname());
               	System.out.println("Unique user id is: "+accnum);  	
				
        	}return user;
		}
	}

	@Override
	public ArrayList<String> userList(String username, String password) throws SQLException {
		User user = new User();
		ArrayList<String> userInfo = new ArrayList<>();
		String sql = "select * from users where username = '"+username+"' and password = '"+password+"'";
		statement = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
    		int accnum = resultSet.getInt(1);
           	String email = resultSet.getString(2);
           	int age = resultSet.getInt(5);
           	String firstname = resultSet.getString(6);
           	String middleinitial = resultSet.getString(7);
           	String lastname = resultSet.getString(8);
           	
           	
           	user.setAccnum(accnum);
           	user.setFirstname(firstname);
			user.setMiddleinitial(middleinitial);
			user.setLastname(lastname);
			user.setAge(age);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
           	
			Integer accobj = accnum;
			userInfo.add(accobj.toString());
			
			userInfo.add(firstname);
			userInfo.add(middleinitial);
			userInfo.add(lastname);
			
			Integer ageobj = age;
			userInfo.add(ageobj.toString());
			
			userInfo.add(email);
			userInfo.add(username);
			userInfo.add(password);
    	}return userInfo;
	}
}
