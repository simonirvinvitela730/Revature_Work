package com.simonirvinvitela.junit_test2;

public class Counter {
	
	private int count = 0;
	
	public Counter() {
		
	}
	
	public int increment() {
		this.count++;
		return this.count;
	}
	
	public int decrement() {
		this.count--;
		return this.count;
	}
}
