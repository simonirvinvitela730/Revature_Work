package com.simonirvinvitela;

import java.io.FileInputStream;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDAOImpl implements EmployeeDAO{
	
	private static Statement statement = null;
	private static Statement statement2 = null;
    Connection connection = null;

    public EmployeeDAOImpl()  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

	@Override
	public void accountApproval(int accnum) throws SQLException {
		String sql = "update accounts set status = 'active' where accnum ="+accnum;
		
		statement = connection.createStatement();
		int update = statement.executeUpdate(sql); 
		
		String sql2 = "update users set status = 'active' where accnum ="+accnum;
		
		statement2 = connection.createStatement();
		int update2 = statement.executeUpdate(sql2);
		
		System.out.println("Account is now active");
	}
	
	@Override
	public void accountPending(int accnum) throws SQLException {
		String sql = "update accounts set status = 'pending' where accnum ="+accnum;
		
		statement = connection.createStatement();
		int update = statement.executeUpdate(sql); 
		
		String sql2 = "update users set status = 'pending' where accnum ="+accnum;
		
		statement2 = connection.createStatement();
		int update2 = statement.executeUpdate(sql2);
		
	}
	
	@Override
	public void accountReset(int accnum) throws SQLException {
		String sql = "update accounts set status = null where accnum ="+accnum;
		
		statement = connection.createStatement();
		int update = statement.executeUpdate(sql); 
		
		String sql2 = "update users set status = null where accnum ="+accnum;
		
		statement2 = connection.createStatement();
		int update2 = statement.executeUpdate(sql2);
		
	}
	
	@Override
	public void accountDeclined(int accnum) throws SQLException {
		String sql = "update accounts set status = 'declined' where accnum ="+accnum;
		
		statement = connection.createStatement();
		int update = statement.executeUpdate(sql); 
		
		String sql2 = "update users set status = 'declined' where accnum ="+accnum;
		
		statement2 = connection.createStatement();
		int update2 = statement.executeUpdate(sql2);
		
	}

	@Override
	public void accountTerminated(int accnum) throws SQLException {
		System.out.println("Are you sure you want to delete Account: "+accnum);
		System.out.println("Press 1 for yes or 2 for no");
		Scanner in = new Scanner(System.in);
		int option = 0;
		
		do {
		    try {
		    	System.out.println("Enter your option: ");
				option = in.nextInt();
		    } catch (InputMismatchException e) {
		        System.out.print("Invalid input... ");
		    }
		    in.nextLine(); // clear buffer
		} while (option <= 0);
		
		switch(option) {
		case 1:{
			String sql = "update accounts set status = 'closed' where accnum ="+accnum;
			int update = statement.executeUpdate(sql);
			
			String sql2 = "update users set status = 'closed' where accnum ="+accnum;
			
			statement2 = connection.createStatement();
			int update2 = statement.executeUpdate(sql2);
			
			System.out.println("Account has been closed");
			break;
		}
		case 2:{
			System.out.println("Account has not been terminated.");
			break;
		}
		default:{
			System.out.println("Please enter 1 or 2");
			EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
			dao.accountTerminated(accnum);
		}
	}	
}
	
	@Override
	public void accountReview(int accnum) throws SQLException {
		UserDAO dao =  UserDAOFactory.getUserDAO();
		
		String sql = "select * from accounts where accnum ="+accnum;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		String sql2 = "select * from users where accnum ="+accnum;
		statement = connection.createStatement();
		ResultSet resultSet2 = statement.executeQuery(sql2);

		while(resultSet.next() & resultSet2.next()) {
			double balance = resultSet.getDouble(2);
			String status = resultSet.getString(3);
			
			String email = resultSet2.getString(2);
           	String username = resultSet2.getString(3);
           	String password = resultSet2.getString(4);
           	int age = resultSet2.getInt(5);
           	String firstname = resultSet2.getString(6);
           	String middleinitial = resultSet2.getString(7);
           	String lastname = resultSet2.getString(8);
           	double balance2 = resultSet2.getDouble(9);
           	
           	Account account = new Account(accnum, balance, status);
				
			if(account.getStatus().equals("active")) {
				System.out.println("Account balance updated");
				dao.setAccountBalance(balance, accnum);
				dao.setUserBalance(balance, accnum);
				
			}else if(account.getStatus().equals("declined")) {
				System.out.println("Account has been declined");
			}else if(account.getStatus().equals("pending")) {
				System.out.println("The account is currently pending");
				System.out.println("Account has yet to be reviewed");
			}else {
				System.out.println("The account has been closed");
			}
		}
	}
	
	@Override
	public User viewAccountById(int accnum) throws SQLException {
		User user = new User();
		String sql = "call getUserByAccnum("+accnum+")";
    	
    	statement = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
           	String email = resultSet.getString(2);
           	String firstname = resultSet.getString(6);
           	String middleinitial = resultSet.getString(7);
           	String lastname = resultSet.getString(8);
           	double balance = resultSet.getDouble(9);
           	String transferStatus = resultSet.getString(10);
           	String status = resultSet.getString(11);
           	
           	user.setAccnum(accnum);
           	user.setEmail(email);
           	user.setFirstname(firstname);
           	user.setMiddleinitial(middleinitial);
           	user.setLastname(lastname);
           	user.setBalance(balance);
           	user.setStatus(lastname);
           	
           	
           	System.out.println("Name: "+user.getFirstname()+" "+user.getMiddleinitial()+" "+ user.getLastname()+"\n"+
           	"Email: "+user.getEmail()+"\n"+"Account Number: "+user.getAccnum()+"\n"+"Balance: "+user.getBalance()+" $"
           	+"\n"+"Account Status: "+status+"\n"+"Transfer Status: "+transferStatus);
    	}return user;
		
	}
	@Override
	public void viewLog(){
		try{    
            FileInputStream fin=new FileInputStream("src\\com\\simonirvinvitela\\transactionlog.properties");    
            int i=0;    
            while((i=fin.read())!=-1){    
             System.out.print((char)i);    
            }    
            fin.close(); //gives IOException so I need the catch block    
          }catch(Exception e){System.out.println(e);}        
	}

	@Override
	public Employee employeeLogin(String username, String password) throws SQLException {
		EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDAO();
		Scanner in = new Scanner(System.in);
		Employee employee = new Employee();
		ArrayList list = dao.employeeList(username, password);
		String sql = "select * from employee where username = '"+username+"' and password = '"+password+"'";
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		if(list.isEmpty()) {
			Employee employee2 = new Employee();
			System.out.println("Incorrect username or password...");
    		System.out.println("Please re-enter username: ");
    		String username2 = in.next();
		
    		System.out.println("Please re-enter password: ");
    		String password2 = in.next();
		
    		employee2.setUsername(username);
    		employee2.setPassword(password);
			
    		dao.employeeLogin(username2, password2);
    		
    		return employee;
		}else {
    	while(resultSet.next()){
        		int id = resultSet.getInt(1);
               	String email = resultSet.getString(2);
               	String firstname = resultSet.getString(3);
               	String lastname = resultSet.getString(4);
               	
               	employee.setId(id);
               	employee.setFirstname(firstname);
    			employee.setLastname(lastname);
    			employee.setEmail(email);
    			employee.setUsername(username);
    			employee.setPassword(password);
    			
    			System.out.println("Welcome "+employee.getFirstname()+" "+employee.getLastname());
    	}return employee;	
    } 	
}
	
	public ArrayList<String> employeeList(String username, String password) throws SQLException {
		Employee employee = new Employee();
		ArrayList<String> employeeInfo = new ArrayList<>();
		String sql = "select * from employee where username = '"+username+"' and password = '"+password+"'";
		statement = connection.createStatement();
    	ResultSet resultSet = statement.executeQuery(sql);
    	while(resultSet.next()) {
    		int employeeId = resultSet.getInt(1);
           	String email = resultSet.getString(2);
           	String firstname = resultSet.getString(3);
           	String lastname = resultSet.getString(4);
           	
           	
           	employee.setId(employeeId);
           	employee.setFirstname(firstname);
			employee.setLastname(lastname);
			employee.setEmail(email);
			employee.setUsername(username);
			employee.setPassword(password);
           	
			Integer idObj = employeeId;
			employeeInfo.add(idObj.toString());
			
			employeeInfo.add(firstname);
			employeeInfo.add(lastname);
			
			employeeInfo.add(email);
			employeeInfo.add(username);
			employeeInfo.add(password);
    	}return employeeInfo;
	}

	@Override
	public void deleteAccount(int accnum) throws SQLException {
		String sql = "delete from accounts where accnum ="+accnum;
		statement = connection.createStatement();
    	int update = statement.executeUpdate(sql);
	}
}
