package com.pension.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String write2Post(Model model,
							 @RequestParam(defaultValue = "none") String room,
							 @RequestParam(defaultValue = "0") int year,
							 @RequestParam(defaultValue = "0") int month,
							 @RequestParam(defaultValue = "0") int day,
							 @RequestParam(defaultValue = "0") String checkOutDate,
							 @RequestParam(defaultValue = "0") int adult,
							 @RequestParam(defaultValue = "0") int child,
							 @RequestParam(defaultValue = "0") int infant,
							 @RequestParam(defaultValue = "0") List<String> option,
							 @RequestParam(defaultValue = "0") int stayDate,
							 
							 @RequestParam(defaultValue = "none") String name,
							 @RequestParam(defaultValue = "none") String phone,
							 @RequestParam(defaultValue = "0", value = "check_in_time") int checkInTime,
							 @RequestParam(defaultValue = "") String message,
							 @RequestParam(defaultValue = "0") int totalPrice,
							 @RequestParam(defaultValue = "0") int lastDay) {
		
		ReserveVO reserveVO = new ReserveVO();
		
		// 고객 정보 등록 (이름, 연락처)
		reserveVO.setCustomerName(name);
		reserveVO.setCustomerPhone(phone);
		
		reserveService.insertCustomer(name, phone);
		
		// 예약 접수 등록
		String checkInDate = year + "-" + month + "-" + day;
		
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
		
		reserveService.insertReserve(reserveVO);
		
		// 예약 접수 상태 등록
		reserveVO.setPaymentDatetime(new Date(System.currentTimeMillis()));
		
		reserveService.insertReserveStatus(reserveVO);
		
		return "/reserve/complete";
	}
	
	@RequestMapping(value = "/reserve/complete", method = RequestMethod.GET)
	public String complete(Model model,
						   ReserveVO reserveVO,
						   @RequestParam(defaultValue = "none") String room,
						   @RequestParam(defaultValue = "0") int year,
						   @RequestParam(defaultValue = "0") int month) {
		
		
		
		return "/reserve/complete";
	}
	
	@RequestMapping(value = "/reserve/confirm", method = RequestMethod.GET)
	public String confirm() {
		return "/reserve/confirm";
	}
	
	@RequestMapping(value = "/reserve/status", method = RequestMethod.GET)
	public String status(Model model,
						 ReserveVO reserveVO,
						 @RequestParam(defaultValue = "none") String room,
						 @RequestParam(defaultValue = "0") int year,
						 @RequestParam(defaultValue = "0") int month) {
		
		
		
		return "/reserve/status";
	}
}
