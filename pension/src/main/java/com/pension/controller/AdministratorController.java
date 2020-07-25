package com.pension.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.pension.service.AdministratorService;
import com.pension.vo.AdministratorVO;

@Controller
public class AdministratorController {
	
	@Inject
	AdministratorService administratorService;
	
	// 관리자로 로그인 되어있는지
	public String isAdmin(HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal(); // 익명일 경우 'anonymousUser', 아닐 경우 로그인된 객체 리턴
		
		// 시큐리티로 인증 받지 못한 사용자인지
		if(principal.equals("anonymousUser")) {
			session.setAttribute("error", "권한이 없습니다.");
			return "redirect:/administrator/login";
		}
		
		return null;
	}
	
	@RequestMapping(value = "/administrator/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,
						HttpSession session, 
						@RequestParam(value = "error", required = false, defaultValue = "0") int error) {
		
		switch(error) {
		case 1:
			session.setAttribute("error", "입력하신 계정과 일치하는 정보가 없습니다.");
			break;
		case 2:
			session.setAttribute("error", "비활성화 된 계정입니다.");
		}
		
		return "/administrator/login";
	}
	
	@RequestMapping(value = "/administrator/account", method = RequestMethod.GET)
	public String account(Model model,
						  HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		AdministratorVO accountInfo = administratorService.getAccountInfo();
		
		model.addAttribute("pageName", "account");
		model.addAttribute("accountInfo", accountInfo);
		
		return "/administrator/account";
	}
	
	@RequestMapping(value = "/administrator/accountInsert", method = RequestMethod.POST)
	public String accountInsert(AdministratorVO administratorVO,
								HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.insertAccountInfo(administratorVO);
		
		return "redirect:/administrator/account";
	}
	
	@RequestMapping(value = "/administrator/accountDelete", method = RequestMethod.GET)
	public String accountDelete(HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.deleteAccountInfo();
		
		return "redirect:/administrator/account";
	}
	
	@RequestMapping(value = "/administrator/customerList", method = RequestMethod.GET)
	public String customerList(Model model,
							   HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		List<String> customerList = administratorService.getCustomerList();
		
		model.addAttribute("customerList", customerList);
		model.addAttribute("pageName", "customerList");
		
		return "/administrator/customerList";
	}
	
	@RequestMapping(value = "/administrator/reserve", method = RequestMethod.GET)
	public String reserve(Model model,
						  HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		model.addAttribute("pageName", "reserve");
		
		return "/administrator/reserve";
	}
	
	@RequestMapping(value = "/administrator/rooms", method = RequestMethod.GET)
	public String rooms(Model model,
						HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		model.addAttribute("pageName", "rooms");
		
		return "/administrator/rooms";
	}
	
	@RequestMapping(value = "/administrator/season", method = RequestMethod.GET)
	public String season(Model model,
						 HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		model.addAttribute("pageName", "season");
		
		return "/administrator/season";
	}
	
}
