package com.sslim.jobweb.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sslim.jobweb.dao.UserDao;
import com.sslim.jobweb.model.User;
@Component("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private UserDao userDao;
	public User authenticateLogin(String username, String password) {
		return userDao.findUserByPassword(username, password);
	}

}
