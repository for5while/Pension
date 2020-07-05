package com.pension.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;

@Configuration
public class AuthenticationFailureHandler implements org.springframework.security.web.authentication.AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		Object errorType = 0;
		
		if(exception instanceof InternalAuthenticationServiceException
		|| exception instanceof BadCredentialsException) { // 존재하지 않는 아이디 또는 비밀번호 불일치
			errorType = 1;
		}
		else if(exception instanceof DisabledException) { // 비활성화 계정
			errorType = 2;
		}
		
		response.sendRedirect(request.getContextPath() + "/administrator/login?error=" + errorType);
	}
}
