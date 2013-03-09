package com.sslim.jobweb.services;

import com.sslim.jobweb.model.User;

public interface UserLoginService {

	public User authenticateLogin(String username,String password);
}
