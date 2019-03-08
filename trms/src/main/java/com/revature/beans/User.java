package com.revature.beans;

public class User {
	public String username;
	public String password;
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + "]";
	}
	
	
}
