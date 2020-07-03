package com.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReserveController {

	@RequestMapping(value = "/reserve/guide", method = RequestMethod.GET)
	public String guide() {
		return "/reserve/guide";
	}
	
	@RequestMapping(value = "/reserve/real", method = RequestMethod.GET)
	public String real() {
		return "/reserve/real";
	}
	
	@RequestMapping(value = "/reserve/confirm", method = RequestMethod.GET)
	public String confirm() {
		return "/reserve/confirm";
	}
	
}
