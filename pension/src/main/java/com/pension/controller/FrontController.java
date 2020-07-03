package com.pension.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FrontController {

	// 오시는 길
	@RequestMapping(value = "/welcome/navigation", method = RequestMethod.GET)
	public String navigation() {
		return "/welcome/navigation";
	}
	
	// 주변 여행지
	@RequestMapping(value = "/welcome/surroundings", method = RequestMethod.GET)
	public String surroundings() {
		return "/welcome/surroundings";
	}
	
	// 룸 - 스위트풀 401
	@RequestMapping(value = "/room/sweet401", method = RequestMethod.GET)
	public String sweet401() {
		return "/room/sweet401";
	}
	
	// 룸 - 스위트풀 402
	@RequestMapping(value = "/room/sweet402", method = RequestMethod.GET)
	public String sweet402() {
		return "/room/sweet402";
	}
	
	// 룸 - 디럭스풀 301
	@RequestMapping(value = "/room/deluxe301", method = RequestMethod.GET)
	public String deluxe301() {
		return "/room/deluxe301";
	}
	
	// 룸 - 디럭스풀 302
	@RequestMapping(value = "/room/deluxe302", method = RequestMethod.GET)
	public String deluxe302() {
		return "/room/deluxe302";
	}
	
	// 룸 - 파티룸 201
	@RequestMapping(value = "/room/party201", method = RequestMethod.GET)
	public String party201() {
		return "/room/party201";
	}
	
	// 펜션 전경
	@RequestMapping(value = "/special/panorama", method = RequestMethod.GET)
	public String panorama() {
		return "/special/panorama";
	}
	
	// 수영장
	@RequestMapping(value = "/special/pool", method = RequestMethod.GET)
	public String pool() {
		return "/special/pool";
	}
	
	// 바비큐장
	@RequestMapping(value = "/special/bbq", method = RequestMethod.GET)
	public String bbq() {
		return "/special/bbq";
	}
	
	// 스파
	@RequestMapping(value = "/special/spa", method = RequestMethod.GET)
	public String spa() {
		return "/special/spa";
	}
	
}
