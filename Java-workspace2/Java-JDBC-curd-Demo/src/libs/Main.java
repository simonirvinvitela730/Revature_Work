package libs;

import java.sql.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		EmployeeDAO dao =  EmployeeDAOFactory.getEmployeeDao();
		int option = 0;
		
		System.out.println("**********");
		System.out.println("Select from the options below");
		System.out.println("**********");
		System.out.println("1 - Add Employee");
		System.out.println("2 - Update Employee");
		System.out.println("3 - Delete Employee");
		System.out.println("4 - Read Employee");
		System.out.println("5 - Read Employee by Id");
		System.out.println("6 - Quit");
		System.out.println("**********");
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your option: ");
		option = in.nextInt();
		
		switch (option) {
		case 1:{//working
			System.out.println("Enter name: ");
			String name = in.next();
			System.out.println("Enter email: ");
			String email = in.next();
			Employee employee = new Employee();
			employee.setName(name);
			employee.setEmail(email);
			dao.addEmployee(employee);
			break;
		}case 2:{//working
			System.out.println("Enter updated name: ");
			String name = in.next();
			System.out.println("Enter updated email: ");
			String email = in.next();
			System.out.println("Enter employee Id to update: ");
			int id = in.nextInt();
			Employee employee = new Employee();
			employee.setName(name);
			employee.setEmail(email);
			employee.setId(id);
			dao.updateEmployee(employee);
			
			break;
			
		}case 3:{//working
			System.out.println("Enter employee Id to be deleted: ");
			int id = in.nextInt();
			dao.deleteEmployee(id);
			System.out.println("Employee information deleted.");
			break;
			
		}case 4:{//working
            dao.getEmployees();
            System.out.println("All employees shown");
            break;
            
		}case 5:{//working
			System.out.println("Enter id to retrieve employee: ");
			int id = in.nextInt();
			dao.employeeById(id);
			System.out.println("Employee retrieved by id!");
			break;
		}case 6:{//working
			System.out.println("Exiting...");
			System.out.println("Goodbye.");
			break;
		}
		}
		
		

    }
}

