package com.simonirvinvitela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
	private static Statement statement = null;
    Connection connection = null;

    public EmployeeDAOImpl() throws ClassNotFoundException  {
        try {
            this.connection = ConnectionFactory.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

	@Override
	public void addEmployee(Employee employee) throws SQLException {
		String sql = "insert into employees(name, email, gender, country) values(?, ?, ?, ?)";
		 PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        preparedStatement.setString(1, employee.getName());
	        preparedStatement.setString(2, employee.getEmail());
	        preparedStatement.setString(3, employee.getGender());
	        preparedStatement.setString(4, employee.getCountry());
	        int count = preparedStatement.executeUpdate();
	        if(count > 0)
	            System.out.println("new employee created");
	        else
	            System.out.println("Oops! something went wrong");
	}

	@Override
	public void updateEmployee(Employee employee) throws SQLException {
		
		String sql = "update employees set name = '"+employee.getName()+"', email = '"+employee.getEmail()+"', gender = '"+employee.getGender()+"', country = '"+employee.getCountry()+"' where id = "+employee.getId();
		statement = connection.createStatement();
		statement.executeUpdate(sql);
}

	@Override
	public void deleteEmployee(int id) throws SQLException {
		String sql = "delete from employees where id ="+id;
		statement = connection.createStatement();
		statement.executeUpdate(sql);
	}

	@Override
	public ArrayList<Employee> getEmployees(int id) throws SQLException {
		ArrayList<Employee> employees = new ArrayList<>();
		
		try {
			EmployeeDAO dao = EmployeeDAOFactory.getEmployeeDAO();
			Employee employee = dao.getEmployeeById(id);
			employees.add(employee);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}return employees;
	}

	@Override
	public Employee getEmployeeById(int id) throws SQLException {
		Employee employee = new Employee();
		String sql = "select * from employees where id ="+id;
		statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while(resultSet.next()) {
			String name = resultSet.getString(2);
			String email = resultSet.getString(3);
			String gender = resultSet.getString(4);
			String country = resultSet.getString(5);
			
			employee.setId(id);
			employee.setName(name);
			employee.setEmail(email);
			employee.setGender(gender);
			employee.setCountry(country);
			
		}return employee;
	}
}
