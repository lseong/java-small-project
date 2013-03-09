package com.sslim.jobweb.model;

public interface User {
	
	public static final String SESSION_ATT_NAME="user";

	public String getUserName();
	
	public boolean isAdmin();
}
