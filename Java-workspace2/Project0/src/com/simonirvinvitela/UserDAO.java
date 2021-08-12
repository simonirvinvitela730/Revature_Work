package com.simonirvinvitela;

import java.sql.SQLException;
import java.util.ArrayList;

public interface UserDAO {
	void createNewUser(User user) throws SQLException;
	void addAccount(User user) throws SQLException;
	double getBalance(int accnum) throws SQLException;
	void setAccountBalance(double balance, int accnum) throws SQLException;
	void setUserBalance(double balance, int accnum) throws SQLException;
	void transferFunds(int accnum, int accnum2) throws SQLException;
	void transferRequest(int accnum, int accnum2) throws SQLException;
	void processTransferRequest(int accnum, int accnum2) throws SQLException;
	String getTransferStatusById(int accnum) throws SQLException;
	String getStatusById(int accnum) throws SQLException;
	User getUserByLogin(String username, String password) throws SQLException;
	User getUserById(int accnum) throws SQLException;
	Account printAccountById(int accnum) throws SQLException;
	Account getAccountById(int accnum) throws SQLException;
	void startTransaction() throws SQLException;
	void rollback() throws SQLException;
	void commit() throws SQLException;
	ArrayList<String> userList(String username, String password) throws SQLException;
	
}
