package com.pension.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdministratorController {

	@RequestMapping(value = "/administrator/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, HttpSession session, @RequestParam(value = "error", required = false, defaultValue = "0") int error) {
		switch(error) {
		case 1:
			session.setAttribute("error", "입력하신 계정과 일치하는 정보가 없습니다.");
			break;
		case 2:
			session.setAttribute("error", "비활성화 된 계정입니다.");
		}
		
		return "/administrator/login";
	}
	
}
