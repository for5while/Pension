package com.pension.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

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
		cal.set(nowYear, nowMonth, 1); // 이번 달의 1일로 지정
		
		int endOfMonth = cal.getActualMaximum(Calendar.DATE); // 이번 달 마지막 날짜
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일
		
		// 담아서 보낼 배열
		HashMap<Integer, Integer> season = new HashMap<>(); // 날짜(일), 비/준/성수기
		List<Integer> days = new ArrayList<>(); // 날짜(일)
		List<ReserveVO> rooms = new ArrayList<>(); // DB에 등록된 방
		HashMap<Integer, TreeMap<String, Integer>> onRooms = new HashMap<>(); // 날짜(일), {방 이름, 예약 상태}
		TreeMap<String, Integer> roomAndStatus = new TreeMap<>(); // 방 이름, 예약 상태
		
		rooms = reserveDAO.getRoomList(); // 방 리스트
		
		// 첫 날의 요일 전 날까지 공백으로 채우기
		for(int i=0; i<=(dayOfWeek-1); i++) {
			days.add(111);
		}
		
		// 실제 날짜
		for(int i=1; i<=endOfMonth; i++) {
			days.add(i);
			
			// 시즌 구분 (0: 비성수기, 1: 준성수기, 2: 성수기)
			String date = nowYear + "-" + (nowMonth + 1) + "-" + i;
			String isMidSeason = reserveDAO.isMidSeason(date);
			String isBusiestSeason = reserveDAO.isBusiestSeason(date);
			
			if(isMidSeason != null) season.put(i, 1);
			else if(isBusiestSeason != null) season.put(i, 2);
			else season.put(i, 0);
			
			for(ReserveVO j : rooms) {
				// NULL 값이 아니라면 방 번호(idx) 값으로 리턴
				Integer roomsStatus = reserveDAO.getRoomStatus(i, j.getIdx()); // 날짜(i=일)와 방 번호 전달
				int onStatus = -1;
				String roomName = reserveDAO.getRoomName(j.getIdx());
				
				if(roomsStatus == null) { // 예약되지 않은 상태 (예약 가능)
					onStatus = 0;
				} else {
					// 방 예약이 되어있는 상태에서 결제 완료 되었다면 예약 완료(1), 아니라면 예약 대기 상태(0)
					Integer roomIsPayment = reserveDAO.getRoomIsPayment(roomsStatus);
					
					if(roomIsPayment != null) {
						if(roomIsPayment == 0) {
							onStatus = 1;
						} else {
							onStatus = 2;
						}
					}
				}
				
				/*
				 * onStatus 변수
				 * 0: 예약 가능
				 * 1: 예약 대기
				 * 2: 예약 완료
				 */
				
				roomAndStatus.put(roomName, onStatus);
				onRooms.put(i, roomAndStatus); // 날짜, {방 이름, 상태}
			}
		}
		
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DAY_OF_MONTH)); // 이번 달 마지막 날짜로 지정
		int maximumDayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 이번 달 마지막 날짜의 요일
		
		// 이번 달 마지막 날짜가 토요일이 아니라면 채워주기
		if(maximumDayOfWeek != 7) {
			int count = (7 - maximumDayOfWeek); // 최대 일곱 요일에서 남은 요일 빼주기
			
			for(int i=1; i<=count; i++) {
				days.add(999);
			}
		}
		
		List<Object> calendar = new ArrayList<>();
		
		reserveVO.setYear(nowYear);
		reserveVO.setMonth(nowMonth);
		
		calendar.add(reserveVO);
		calendar.add(days);
		calendar.add(onRooms);
		calendar.add(season);
		
		return calendar;
	}
}
