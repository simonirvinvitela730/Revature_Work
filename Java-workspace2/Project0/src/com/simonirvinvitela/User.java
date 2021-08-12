package com.simonirvinvitela;

public class User {
	private int accnum;
	private double balance;
	private String status;
	private String transferStatus;
	private String username;
	private String password;
	private String email;
	private String firstname;
	private String middleinitial;
	private String lastname;
	private int age;
	
	public User() {}
	
	public User(int accnum, String username, String password, String email, String firstname, String middleinitial, String lastname, int age, double balance, String transferStatus, String status) {
		this.accnum= accnum;
		this.username = username;
		this.password = password;
		this.email = email;
		this.firstname = firstname;
		this.middleinitial = middleinitial;
		this.lastname = lastname;
		this.age = age;
		this.balance = balance;
		this.transferStatus = transferStatus;
		this.status = status;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTransferStatus() {
		return transferStatus;
	}

	public void setTransferStatus(String transferStatus) {
		this.transferStatus = transferStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddleinitial() {
		return middleinitial;
	}

	public void setMiddleinitial(String middleinitial) {
		this.middleinitial = middleinitial;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAccnum() {
		return accnum;
	}
	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance2) {
		this.balance = balance2;
	}
}
