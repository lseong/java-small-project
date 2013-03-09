package com.sslim.jobweb.dao;

import org.springframework.stereotype.Component;

import com.sslim.jobweb.model.User;
import com.sslim.jobweb.model.UserImpl;

@Component
public class UserDaoImpl implements UserDao {

	public User findUserByPassword(String username, String password) {
		// mock data
		if ("ahmoi".equals(username) && "password".equals(password)) {
			return new UserImpl("Ah Moi", false);
		} else if ("ahboy".equals(username) && "password".equals(password)) {
			return new UserImpl("Ah Boy", true);
		}
		// TODO may throws Exception here
		return null;
	}

}
