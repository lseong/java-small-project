package com.sslim.jobweb.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sslim.jobweb.model.User;


@WebFilter(urlPatterns ="*")
public class GatekeeprFilter implements Filter {
	
	//Use regular expression to handler exclude 
	// /js/*.js , /login, /login.jsp ,/images/*.jpg, /css/*.css 
	static final String exclude_regex="(^/js/\\S+.(?i)js$)|(^/login(.jsp)*$)|(^/css/\\S+.(?i)css$)|(^/images/\\S+.(?i)(jpeg|jpg|gif|png|ico)$)";

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest servletRequest,
			ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
		
		String path = httpServletRequest.getServletPath();
		//if user object exits in session or path match exclude_regex
		if(httpServletRequest.getSession().getAttribute(User.SESSION_ATT_NAME) != null||path.matches(exclude_regex)){
			filterChain.doFilter(servletRequest, servletResponse);
		}
		else{
			//redirect to login page if "user" object is null
			httpServletResponse.sendRedirect("login.jsp");
			return;
		}
		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

}
