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
		session.setAttribute("message", "계좌 등록 성공!");
		
		return "redirect:/administrator/account";
	}
	
	@RequestMapping(value = "/administrator/accountDelete", method = RequestMethod.GET)
	public String accountDelete(HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.deleteAccountInfo();
		session.setAttribute("message", "계좌 삭제 완료!");
		
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
		
		List<Object> reserveList = administratorService.getReserveList();

		model.addAttribute("reserveList", reserveList);
		model.addAttribute("pageName", "reserve");
		
		return "/administrator/reserve";
	}
	
	@RequestMapping(value = "/administrator/reserveComplete", method = RequestMethod.GET)
	public String reserveComplete(@RequestParam int reserveNo,
								  HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.updateReserveStatus(reserveNo);
		session.setAttribute("message", reserveNo + "번 예약 확정 완료!");

		return "redirect:/administrator/reserve";
	}
	
	@RequestMapping(value = "/administrator/rooms", method = RequestMethod.GET)
	public String rooms(Model model,
						HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		List<Object> roomsList = administratorService.getRoomsList();
		List<Object> roomsOptionList = administratorService.getRoomsOptionList();
		
		model.addAttribute("roomsList", roomsList);
		model.addAttribute("roomsOptionList", roomsOptionList);
		model.addAttribute("pageName", "rooms");
		
		return "/administrator/rooms";
	}
	
	@RequestMapping(value = "/administrator/roomInsert", method = RequestMethod.POST)
	public String roomInsert(AdministratorVO administratorVO,
							 HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.insertRoom(administratorVO);
		session.setAttribute("message", "호실 등록 성공!");

		return "redirect:/administrator/rooms";
	}
	
	@RequestMapping(value = "/administrator/roomDelete", method = RequestMethod.GET)
	public String roomDelete(@RequestParam int roomNo,
							 HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.deleteRoom(roomNo);
		session.setAttribute("message", "호실 삭제 완료!");
		
		return "redirect:/administrator/rooms";
	}
	
	@RequestMapping(value = "/administrator/roomOptionInsert", method = RequestMethod.POST)
	public String roomOptionInsert(AdministratorVO administratorVO,
								   HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.insertRoomOption(administratorVO);
		session.setAttribute("message", "호실 옵션 등록 성공!");

		return "redirect:/administrator/rooms";
	}
	
	@RequestMapping(value = "/administrator/roomOptionDelete", method = RequestMethod.GET)
	public String roomOptionDelete(@RequestParam int roomOptionNo,
							 	   HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.deleteRoomOption(roomOptionNo);
		session.setAttribute("message", "호실 옵션 삭제 완료!");
		
		return "redirect:/administrator/rooms";
	}
	
	@RequestMapping(value = "/administrator/season", method = RequestMethod.GET)
	public String season(Model model,
						 HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		List<Object> seasons = administratorService.getSeasonList();
		
		model.addAttribute("seasonList", seasons);
		model.addAttribute("pageName", "season");
		
		return "/administrator/season";
	}
	
	@RequestMapping(value = "/administrator/seasonInsert", method = RequestMethod.POST)
	public String seasonInsert(AdministratorVO administratorVO,
							   HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.insertSeason(administratorVO);
		session.setAttribute("message", "시즌 등록 성공!");

		return "redirect:/administrator/season";
	}
	
	@RequestMapping(value = "/administrator/seasonDelete", method = RequestMethod.GET)
	public String seasonDelete(@RequestParam int seasonNo,
							   HttpSession session) {
		
		if(isAdmin(session) != null) return isAdmin(session);
		
		administratorService.deleteSeason(seasonNo);
		session.setAttribute("message", "시즌 삭제 완료!");

		return "redirect:/administrator/season";
	}
	
}
