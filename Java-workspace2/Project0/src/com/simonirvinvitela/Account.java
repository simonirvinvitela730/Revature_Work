package com.simonirvinvitela;

public class Account {
	private double balance;
	private int accnum;
	private String status;
	
	public Account() {}
	
	public Account(int accnum, double balance, String status) {
		this.accnum = accnum;
		this.balance = balance;
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccnum() {
		return accnum;
	}

	public void setAccnum(int accnum) {
		this.accnum = accnum;
	}
	
}
