package com.simonirvinvitela;
import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
	void addEmployee(Employee employee) throws SQLException;
	void updateEmployee(Employee employee) throws SQLException;
	void deleteEmployee(int id) throws SQLException;
	ArrayList<Employee> getEmployees(int id) throws SQLException;
	Employee getEmployeeById(int id) throws SQLException;
}
