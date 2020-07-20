package com.pension.controller;

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
						 ReserveVO reserveVO,
						 @RequestParam(defaultValue = "none") String room,
						 @RequestParam(defaultValue = "0") int year,
						 @RequestParam(defaultValue = "0") int month) {
		
		
		
		return "/reserve/write2";
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
