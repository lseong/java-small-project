package com.sslim.jobweb.services;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.sslim.jobweb.dao.UserDao;
import com.sslim.jobweb.model.User;
import com.sslim.jobweb.model.UserImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestUserLoginService {

	@Mock private UserDao userDao;
	@InjectMocks private UserLoginService userLoginService=new UserLoginServiceImpl();
	
	@Before
	public void init(){
		when(userDao.findUserByPassword("validuser", "validpassword")).thenReturn(new UserImpl("mock user", false));
		
		when(userDao.findUserByPassword("validadmin", "validpassword")).thenReturn(new UserImpl("mock admin", true));
		
		when(userDao.findUserByPassword("invaliduser", "invalidpassword")).thenReturn(null);
	}
	
	@Test
	public void testLoginNonAdminUser(){
		User user=userLoginService.authenticateLogin("validuser", "validpassword");
		org.junit.Assert.assertNotNull("User failed to login",user);
		org.junit.Assert.assertFalse("This user should be non-admin",user.isAdmin());
	}
	
	@Test
	public void testLoginAdminUser(){
		User user=userLoginService.authenticateLogin("validadmin", "validpassword");
		org.junit.Assert.assertNotNull("User failed to login",user);
		org.junit.Assert.assertTrue("This user should be admin",user.isAdmin());
	}
	
	@Test
	public void testLoginInvalideUser(){
		User user=userLoginService.authenticateLogin("invaliduser", "invaliduser");
		org.junit.Assert.assertNull("Login should failed",user);
	}
}
