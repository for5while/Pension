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
		
		ArrayList<Integer> days = new ArrayList<>();
		List<ReserveVO> rooms = new ArrayList<>();
		HashMap<Integer, TreeMap<String, Integer>> onRooms = new HashMap<>();
		TreeMap<String, Integer> roomAndStatus = new TreeMap<>();
		
		rooms = reserveDAO.getRoomList(); // 방 리스트
		
		// 첫 날의 요일 전 날까지 공백으로 채우기
		for(int i=0; i<=(dayOfWeek-1); i++) {
			days.add(111);
		}
		
		// 실제 날짜
		for(int i=1; i<=endOfMonth; i++) {
			days.add(i);
			
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
				
				roomAndStatus.put(roomName, onStatus);
				onRooms.put(i, roomAndStatus); // 날짜, {방 이름, 상태}
			}
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
		calendar.add(onRooms);
		
		return calendar;
	}
}
