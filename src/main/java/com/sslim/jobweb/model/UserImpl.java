package com.sslim.jobweb.model;

public class UserImpl implements User{
	
	private final String userName;
	private final boolean admin;
	
	public UserImpl(String userName, boolean admin) {
		super();
		this.userName = userName;
		this.admin = admin;
	}

	public String getUserName() {
		return userName;
	}

	public boolean isAdmin() {
		return admin;
	}

}
