package com.sslim.jobweb.dao;

import com.sslim.jobweb.model.User;

public interface UserDao {

	public User findUserByPassword(String username,String password);
}
