package com.sslim.jobweb.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sslim.jobweb.model.User;
import com.sslim.jobweb.services.UserLoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7404129480802576123L;

	private UserLoginService userLoginService;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		final WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(config.getServletContext());
		this.userLoginService = (UserLoginService)springContext.getBean("userLoginService");
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Always return new session
		HttpSession httpSession = request.getSession(true);
		User user = userLoginService.authenticateLogin(username, password);
		if (user != null) {
			httpSession.setAttribute(User.SESSION_ATT_NAME, user);
			// validate
			// Successfully then forward to welcome page
			// Failed then back to login page
			response.sendRedirect("index.jsp");
		} else {
			response.sendRedirect("login.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}


}
