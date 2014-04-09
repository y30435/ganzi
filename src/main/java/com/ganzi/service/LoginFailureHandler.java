package com.ganzi.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class LoginFailureHandler implements AuthenticationFailureHandler {
	
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {		
		
		System.out.println("message->"+exception.getMessage());
		
		request.setAttribute("auth", "fail");
		request.setAttribute("ErrorMsg", exception.getMessage());
		
		request.getRequestDispatcher( "/login.do").forward(request, response);;
	}

}
