package com.pension.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pension.dao.ReserveDAO;
import com.pension.vo.ReserveVO;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Inject
	private ReserveDAO reserveDAO;

	@Override
	public List<Object> getList(ReserveVO reserveVO) {
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
		
		List<Object> calendar = new ArrayList<>();
		
		reserveVO.setYear(nowYear);
		reserveVO.setMonth(nowMonth);
		
		calendar.add(reserveVO);
		calendar.add(days);
		
		return calendar;
	}
}
