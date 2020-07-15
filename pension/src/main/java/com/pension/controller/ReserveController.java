package com.pension.controller;

import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReserveController {

	@RequestMapping(value = "/reserve/guide", method = RequestMethod.GET)
	public String guide() {
		return "/reserve/guide";
	}
	
	@RequestMapping(value = "/reserve/real", method = RequestMethod.GET)
	public String real(Model model,
					   @RequestParam(defaultValue = "0") int year,
					   @RequestParam(defaultValue = "0") int month) {
		
		Calendar cal = Calendar.getInstance();
		
		int nowYear = cal.get(Calendar.YEAR);
		int nowMonth = cal.get(Calendar.MONTH);
		
		cal.set(Calendar.YEAR, nowYear);
		cal.set(Calendar.MONTH, nowMonth);
		cal.set(nowYear, nowMonth, 1); // 이번 달의 1일
		
		int endOfMonth = cal.getActualMaximum(Calendar.DATE); // 이번 달 마지막 날짜
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일
		
		ArrayList<Integer> days = new ArrayList<>();
		
		// 첫 날의 요일 전 날까지 공백으로 채우기
		for(int i=0; i<=(dayOfWeek-1); i++) {
			days.add(111);
		}
		
		// 날짜
		for(int i=1; i<=endOfMonth; i++) {
			days.add(i);
		}
		
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH)); // 이번 달 마지막 날짜로 지정
		int maximumDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 이번 달 마지막 날짜의 요일
		
		// 이번 달 마지막 날짜가 토요일이 아니라면 채워주기
		if(maximumDayOfWeek != 7) {
			int count = (7 - maximumDayOfWeek);
			
			for(int i=1; i<=count; i++) {
				days.add(999);
			}
		}
		
		model.addAttribute("nowYear", nowYear);
		model.addAttribute("nowMonth", nowMonth);
		model.addAttribute("days", days);
		
		return "/reserve/real";
	}
	
//	System.out.println(dayOfWeek);
//	if(i == 1) {
//		for(int j=1; j<dayOfWeek; j++) {
//			days.add(99);
//		}
//	}
	
//	if(dayOfWeek % 7 == 0) {
//		days.add(99);
//	}
	
//	dayOfWeek++;
	
	@RequestMapping(value = "/reserve/confirm", method = RequestMethod.GET)
	public String confirm() {
		return "/reserve/confirm";
	}
	
}
