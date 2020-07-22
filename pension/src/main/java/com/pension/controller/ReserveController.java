package com.pension.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pension.service.ReserveService;
import com.pension.vo.ReserveVO;

@Controller
public class ReserveController {

	@Inject
	private ReserveService reserveService;
	
	@RequestMapping(value = "/reserve/guide", method = RequestMethod.GET)
	public String guide() {
		return "/reserve/guide";
	}
	
	@RequestMapping(value = "/reserve/real", method = RequestMethod.GET)
	public String real(Model model,
					   ReserveVO reserveVO,
					   @RequestParam(defaultValue = "0") int year,
					   @RequestParam(defaultValue = "0") int month) {
		
		List<Object> calendar = reserveService.getList(reserveVO, year, month);
		
		model.addAttribute("calendar", calendar);
		
		return "/reserve/real";
	}
	
	@RequestMapping(value = "/reserve/write", method = RequestMethod.GET)
	public String write(Model model,
						@RequestParam(defaultValue = "none") String room,
						@RequestParam(defaultValue = "0") int year,
						@RequestParam(defaultValue = "0") int month,
						@RequestParam(defaultValue = "0") int day,
						@RequestParam(defaultValue = "0") int lastDay) {
		
		List<Object> roomInfos = reserveService.getRoomInfo(room);
		List<Object> roomOptions = reserveService.getRoomOption(room);
		
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("lastDay", lastDay);
		model.addAttribute("roomInfos", roomInfos);
		model.addAttribute("roomOptions", roomOptions);
		
		return "/reserve/write";
	}
	
	@RequestMapping(value = "/reserve/write2", method = RequestMethod.GET)
	public String write2(Model model,
						 HttpSession session,
						 @RequestParam(defaultValue = "none") String room,
						 @RequestParam(defaultValue = "0") int year,
						 @RequestParam(defaultValue = "0") int month,
						 @RequestParam(defaultValue = "0") int day,
						 @RequestParam(defaultValue = "0") String checkOutDate,
						 @RequestParam(defaultValue = "0") int adult,
						 @RequestParam(defaultValue = "0") int child,
						 @RequestParam(defaultValue = "0") int infant,
						 @RequestParam(defaultValue = "0") List<Integer> option,
						 @RequestParam(defaultValue = "0", value = "stay_date") int stayDate) {

		// 체크아웃 날짜가 이미 예약 대기/완료 상태라면 되돌아가기
		if(reserveService.getIsPass(room, checkOutDate) != null) {
			session.setAttribute("error", "이미 예약 대기 또는 완료된 날짜가 겹쳤습니다.<br>달력에서 날짜를 확인해주세요.");
			return "redirect:/reserve/real";
		}
		
		// 객실 금액
		int roomPrice = reserveService.getRoomPrice(room, stayDate, year, month, day);
		
		// 옵션명 나열 및 옵션 금액 추가
		List<String> optionNames = new ArrayList<>();
		int optionPrice = 0;
		
		for(int optionNum : option) {
			String optionName = reserveService.getOptionName(optionNum);
			optionNames.add(optionName);
			
			Integer getOptionPrice = reserveService.getOptionPrice(optionNum);
			if(getOptionPrice != null) optionPrice += getOptionPrice;
		}
		
		// 객실 + 옵션 금액 합계
		int totalPrice = roomPrice + optionPrice;
		
		model.addAttribute("room", room);
		model.addAttribute("year", year);
		model.addAttribute("month", month);
		model.addAttribute("day", day);
		model.addAttribute("checkOutDate", checkOutDate);
		model.addAttribute("stayDate", stayDate);
		model.addAttribute("adult", adult);
		model.addAttribute("child", child);
		model.addAttribute("infant", infant);
		model.addAttribute("optionNames", optionNames);
		model.addAttribute("roomPrice", roomPrice);
		model.addAttribute("optionPrice", optionPrice);
		model.addAttribute("totalPrice", totalPrice);
		
		return "/reserve/write2";
	}
	
	@RequestMapping(value = "/reserve/write2", method = RequestMethod.POST)
	public String write2Post(RedirectAttributes redirectAttr,
							 @RequestParam(defaultValue = "none") String room,
							 @RequestParam(defaultValue = "0") int year,
							 @RequestParam(defaultValue = "0") int month,
							 @RequestParam(defaultValue = "0") int day,
							 @RequestParam(defaultValue = "0") int lastDay,
							 @RequestParam(defaultValue = "0", value = "check_in_time") int checkInTime,
							 @RequestParam(defaultValue = "0") String checkOutDate,
							 @RequestParam(defaultValue = "0") int stayDate,
							 @RequestParam(defaultValue = "0") int adult,
							 @RequestParam(defaultValue = "0") int child,
							 @RequestParam(defaultValue = "0") int infant,
							 @RequestParam(defaultValue = "0") List<String> option,
							 @RequestParam(defaultValue = "") String message,
							 @RequestParam(defaultValue = "none") String name,
							 @RequestParam(defaultValue = "none") String phone,
							 @RequestParam(defaultValue = "0") int totalPrice) {
		
		ReserveVO reserveVO = new ReserveVO();
		String checkInDate = year + "-" + month + "-" + day;
		
		reserveVO.setCustomerName(name);
		reserveVO.setCustomerPhone(phone);
		reserveVO.setRoomName(room);
		reserveVO.setCheckInTime(checkInTime);
		reserveVO.setCheckInDate(checkInDate);
		reserveVO.setCheckInYear(year);
		reserveVO.setCheckInMonth(month);
		reserveVO.setCheckInDay(day);
		reserveVO.setCheckOutDate(checkOutDate);
		reserveVO.setPeopleAdult(adult);
		reserveVO.setPeopleChild(child);
		reserveVO.setPeopleInfant(infant);
		reserveVO.setOption(option);
		reserveVO.setMessage(message);
		reserveVO.setTotalPrice(totalPrice);
		reserveVO.setNight(stayDate);
		reserveVO.setLastDay(lastDay);
		reserveVO.setPaymentDatetime(new Date(System.currentTimeMillis()));
		
		// 고객 정보 등록 (이름, 연락처)
		reserveService.insertCustomer(name, phone);
		
		// 예약 접수 등록
		reserveService.insertReserve(reserveVO);
		
		// 예약 접수 상태 등록
		reserveService.insertReserveStatus(reserveVO);
		
		// 완료 페이지에 전달
		Calendar cal = Calendar.getInstance();
		
		redirectAttr.addFlashAttribute("totalPrice", totalPrice);
		redirectAttr.addFlashAttribute("name", name);
		redirectAttr.addFlashAttribute("phone", phone);
		redirectAttr.addFlashAttribute("year", cal.get(Calendar.YEAR));
		redirectAttr.addFlashAttribute("month", cal.get(Calendar.MONTH) + 1);
		redirectAttr.addFlashAttribute("day", cal.get(Calendar.DAY_OF_MONTH));
		redirectAttr.addFlashAttribute("hour", cal.get(Calendar.HOUR_OF_DAY) + 1);
		redirectAttr.addFlashAttribute("minute", cal.get(Calendar.MINUTE));
		
		return "redirect:/reserve/complete";
	}
	
	@RequestMapping(value = "/reserve/complete", method = RequestMethod.GET)
	public String complete(Model model) {
		Map<String, String> accountInfo = reserveService.getAccountInfo();
		
		model.addAttribute("account", accountInfo);
		
		return "/reserve/complete";
	}
	
	@RequestMapping(value = "/reserve/confirm", method = RequestMethod.GET)
	public String confirm() {
		return "/reserve/confirm";
	}
	
	@RequestMapping(value = "/reserve/confirm", method = RequestMethod.POST)
	public String confirmPost(RedirectAttributes redirectAtt,
							  HttpSession session,
							  ReserveVO reserveVO) {
		
		Map<String, String> reserveStatus = reserveService.getReserveStatus(reserveVO);
		
		if(reserveStatus == null) {
			session.setAttribute("error", "해당 예약 정보가 존재하지 않습니다.");
			return "redirect:/reserve/confirm";
		} else {
			redirectAtt.addFlashAttribute("reserveStatus", reserveStatus);
		}
		
		return "redirect:/reserve/status";
	}
	
	@RequestMapping(value = "/reserve/status", method = RequestMethod.GET)
	public String status() {
		return "/reserve/status";
	}
}
