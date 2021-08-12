package com.simonirvinvitela;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeDAO {
	void accountApproval(int accnum) throws SQLException;
	void accountDeclined(int accnum) throws SQLException;
	void accountTerminated(int accnum) throws SQLException;
	void accountReview(int accnum) throws SQLException;
	Employee employeeLogin(String username, String password) throws SQLException;
	User viewAccountById(int accnum) throws SQLException;
	void viewLog();
	ArrayList<String> employeeList(String username, String password) throws SQLException;
}
