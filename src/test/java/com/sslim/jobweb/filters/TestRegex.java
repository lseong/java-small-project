package com.sslim.jobweb.filters;

import org.junit.Test;
public class TestRegex {

	@Test
	public void testLoginRegex() throws Exception {
		String regex="^/login(.jsp)*$";
		org.junit.Assert.assertTrue("/login.jsp failed of excluded", "/login.jsp".matches(regex));
		
		org.junit.Assert.assertTrue("/login failed of excluded", "/login".matches(regex));
		
		org.junit.Assert.assertTrue("/logins.jsp failed of included", "/logins.jsp".matches(regex)==false);
	}
	

	@Test
	public void testIgnoreCaseRegex() throws Exception {
		String regex="(?i)abc";
		org.junit.Assert.assertTrue("Abc", "Abc".matches(regex));
	}
	
	@Test
	public void testJavascriptRegex() throws Exception {
		String regex="(^/js/\\S+.js$)";
		org.junit.Assert.assertTrue("/js/jquery.js failed of excluded", "/js/jquery.js".matches(regex));
		
		org.junit.Assert.assertTrue("/js/any-12553.js failed of excluded", "/js/any-12553.js".matches(regex));
		
		org.junit.Assert.assertTrue("/js/.js failed of excluded", "/js/.js".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/jss/jquery.js failed of included", "/jss/jquery.js".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/js/jquery.js/test failed of included", "/jss/jquery.js/test".matches(regex)==false);
		
	}
	
	@Test
	public void testJoin() throws Exception {
		String regex=GatekeeprFilter.exclude_regex;
		org.junit.Assert.assertTrue("/js/jquery.js failed of excluded", "/js/jquery.js".matches(regex));
		
		org.junit.Assert.assertTrue("/js/any-12553.js failed of excluded", "/js/any-12553.js".matches(regex));
		
		org.junit.Assert.assertTrue("/js/.js failed of excluded", "/js/.js".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/jss/jquery.js failed of included", "/jss/jquery.js".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/js/jquery.js/test failed of included", "/jss/jquery.js/test".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/login.jsp failed of excluded", "/login.jsp".matches(regex));
		
		org.junit.Assert.assertTrue("/login failed of excluded", "/login".matches(regex));
		
		org.junit.Assert.assertTrue("/logins.jsp failed of included", "/logins.jsp".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/css/jquery.css failed of excluded", "/css/jquery.css".matches(regex));
		
		org.junit.Assert.assertTrue("/css/any-12553.css failed of excluded", "/css/any-12553.css".matches(regex));
		
		org.junit.Assert.assertTrue("/css/.js failed of excluded", "/css/.css".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/css/ failed of included", "/css/".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/css/c.css/test failed of included", "/css/c.css/test".matches(regex)==false);
		
		org.junit.Assert.assertTrue("/images/h.ico failed of excluded", "/images/h.ico".matches(regex));
		
		org.junit.Assert.assertTrue("/images/h.iCo failed of excluded", "/images/h.iCo".matches(regex));
		
	}
	
	


}
