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
		
		List<Object> calendar = reserveService.getList(reserveVO);
		
		model.addAttribute("calendar", calendar);
		
		return "/reserve/real";
	}
	
	@RequestMapping(value = "/reserve/confirm", method = RequestMethod.GET)
	public String confirm() {
		return "/reserve/confirm";
	}
	
}
