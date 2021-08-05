package day9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	 public static void main(String[] args) throws ClassNotFoundException, SQLException {

	        // Step 1: load the driver
	        //Class.forName("jdbc:mysql://localhost:3306/revature");

	        // Step 2: Create connection Object
		 	String url = "jdbc:mysql://localhost:3306/";
		 	String username = "root";
		 	String password = "66241927S3cr3t?";
		 	String database = "revature2";
		 	
	        Connection conn = DriverManager.getConnection(url+database, username, password);
	        
	        if(conn.isClosed()) {
	        	System.out.println("connection is closed...");
	        }else{
	        	System.out.println("connection is open...");
	        }
	        
	        // Step 3: Create Statement Object
	        Statement statement = conn.createStatement();
	        
	        //Step 4: Execute Query
	        
	        //Demo 1: Create Table
	       /* String query ="create table employee (id integer primary key auto_increment, name char(20), email char(30))";
	        statement.executeUpdate(query);
	        System.out.println("table created successfully");*/
	        
	        //Demo 2: Write data to table
	        
	        /*String query = "insert into employee (id, name, email) values (?, ?, ?)";
	        
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        
	        preparedStatement.setInt(1,  5);
	        preparedStatement.setString(2,  "Richard Feynman");
	        preparedStatement.setString(3,  "particles@gmail.com");
	        
	        int rowAffected = preparedStatement.executeUpdate();
	        
	        preparedStatement.setInt(1,  7);
	        preparedStatement.setString(2,  "Houdini");
	        preparedStatement.setString(3,  "poof@gmail.com");
	        
	        int rowAffected2 = preparedStatement.executeUpdate();
	   
	        System.out.println("("+rowAffected+") rows affected");*/
	        
	        
	        //Demo 3: Update data of our table
	        
	        /*String query = "update employee set name = ?, email = ? where id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setString(1,  "Paul");
	        preparedStatement.setString(2,  "p@gmail.com");
	        preparedStatement.setInt(3,  2);
	        int rowAffected = preparedStatement.executeUpdate();
	        System.out.println("("+rowAffected+") rows affected");
	        */
	        
	        //Demo 4: Delete Data from our table
	        
	        /*String query = "delete from employee where id = ?";
	        PreparedStatement preparedStatement = conn.prepareStatement(query);
	        preparedStatement.setInt(1,  1);
	        int rowAffected = preparedStatement.executeUpdate();
	        System.out.println("("+rowAffected+") rows affected"); */
	        
	        //Demo 5: Read the 
	        String query = "select * from employee";
	        ResultSet resultSet = statement.executeQuery(query);
	        
	        while(resultSet.next()) {
	        	int id = resultSet.getInt(1);
	        	String name = resultSet.getString(2);
	        	String email = resultSet.getString(3);
	        	
	        	System.out.println("Id = "+ id+ ", Name = "+name+", Email = "+email);
	        }
	        
	
	        // Step 5: Close the connection
	        conn.close();

	}

}
