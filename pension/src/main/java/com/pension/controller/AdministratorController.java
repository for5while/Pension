package com.pension.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pension.service.AdministratorService;
import com.pension.vo.AdministratorVO;

@Controller
public class AdministratorController {

	@Inject
	private AdministratorService administratorService;
	
	@RequestMapping(value = "/administrator/login", method = RequestMethod.GET)
	public String login() {
		return "/administrator/login";
	}
	
	@RequestMapping(value = "/administrator/login", method = RequestMethod.POST)
	public String loginPost(AdministratorVO memberVO, HttpSession session, Model model) {
		AdministratorVO check = administratorService.userCheck(memberVO);
		
		if(check == null) {
			session.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
			return "redirect:/administrator/login";
		} else {
			session.setAttribute("adminId", memberVO.getId());
			session.setAttribute("message", memberVO.getId() + "님 안녕하세요.");
			return "redirect:/index";
		}
	}
	
	@RequestMapping(value = "/administrator/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("adminId");
		session.setAttribute("message", "정상적으로 로그아웃 되었습니다.");
		
		return "redirect:/index";
	}
	
}
