package com.simonirvinvitela;

import java.sql.Timestamp;

public class Ticket {
	private int ticket_id;
	private String status;
	private String type;
	private double amount;
	private String description;
	private Timestamp ts;
	
	private Ticket(){}
	
	public Ticket(int ticket_id, String status, String type, double amount, String description, Timestamp ts) {
		this.ticket_id = ticket_id;
		this.status = status;
		this.type = type;
		this.amount = amount;
		this.description = description;
		this.ts = ts;
	}

	public int getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}
}
