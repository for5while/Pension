package com.pension.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public List<Object> getList(ReserveVO reserveVO, int year, int month) {
		Calendar cal = Calendar.getInstance();
		
		int nowYear = year;
		int nowMonth = month - 1;
		
		if(nowYear == 0) {
			nowYear = cal.get(Calendar.YEAR);
		}
		if(nowMonth == -1) {
			nowMonth = cal.get(Calendar.MONTH);
		}
		
		cal.set(Calendar.YEAR, nowYear);
		cal.set(Calendar.MONTH, nowMonth);
		cal.set(nowYear, nowMonth, 1); // 이번 달의 1일로 지정
		
		int endOfMonth = cal.getActualMaximum(Calendar.DATE); // 이번 달 마지막 날짜
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK); // 요일
		
		// 담아서 보낼 배열
		HashMap<Integer, Integer> season = new HashMap<>(); // 날짜(일), 비/준/성수기
		List<Integer> days = new ArrayList<>(); // 날짜(일)
		List<ReserveVO> rooms = new ArrayList<>(); // 등록된 방
		HashMap<Integer, TreeMap<String, Integer>> onRooms = new HashMap<>(); // 날짜(일), {방 이름, 예약 상태}
		TreeMap<String, Integer> statusOfRoom = null;
		
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

			statusOfRoom = new TreeMap<>(); // 방 이름, 예약 상태
			
			for(ReserveVO reserveVO2 : rooms) {
				
				// NULL 값이 아니라면 방 번호(idx) 값으로 리턴
				Integer roomsStatus = reserveDAO.getRoomStatus(date, reserveVO2.getIdx()); // 날짜와 방 번호 전달
				int onStatus = -1;
				String roomName = reserveDAO.getRoomName(reserveVO2.getIdx());
				
				if(roomsStatus == null) { // 예약되지 않은 상태 (예약 가능)
					onStatus = 0;
				} else {
					// 방 예약이 되어있는 상태에서 결제 완료 되었다면 예약 완료(1), 아니라면 예약 대기 상태(0)
					Integer roomIsPayment = reserveDAO.getRoomIsPayment(roomsStatus);
					
					onStatus = 3;
					
					if(roomIsPayment != null) {
						if(roomIsPayment == 0) {
							onStatus = 1;
						} else if(roomIsPayment == 1) {
							onStatus = 2;
						}
					}
				}
				
				/*
				 * onStatus 변수
				 * 0: 예약 가능
				 * 1: 예약 대기
				 * 2: 예약 완료
				 * 3: 예약 불가(대기 또는 완료 시의 마지막 날짜 이전에 표기되는 상태)
				 */
				
				statusOfRoom.put(roomName, onStatus);
			}
			
			onRooms.put(i, statusOfRoom); // 날짜, {방 이름, 상태}
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
		
		int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		calendar.add(reserveVO);
		calendar.add(days);
		calendar.add(onRooms);
		calendar.add(season);
		calendar.add(lastDay);
		
		return calendar;
	}

	@Override
	public List<Object> getRoomInfo(String room) {
		int night = reserveDAO.getNight(room);
		List<ReserveVO> peoples = reserveDAO.getPeoples(room);
		List<Object> roomInfos = new ArrayList<>();
		
		roomInfos.add(night);
		roomInfos.add(peoples);
		
		return roomInfos;
	}

	@Override
	public List<Object> getRoomOption(String room) {
		List<Object> options = reserveDAO.getOptions(room);
		
		return options;
	}

	@Override
	public String getOptionName(int optionNum) {
		return reserveDAO.getOptionName(optionNum);
	}

	@Override
	public int getRoomPrice(String room, int stayDate, int year, int month, int day) {
		
		/*
		 * 객실 금액 책정 기준
		 * (방 기본가 * 숙박일) + if:금요일 + if:토요일 + if:준성수기 + if:성수기 
		 */
		
		// 기본 방 금액
		int roomPrice = reserveDAO.getRoomDefaultPrice(room);
		
		// 방 금액을 x박 만큼 곱하기
		roomPrice *= stayDate;
		
		// 금요일 또는 토요일인 경우 주말 정가 추가
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		
		int week = cal.get(Calendar.DAY_OF_WEEK);
		
		if(week == 6) { // 금요일
			roomPrice += reserveDAO.getRoomFriPrice(room);
		} else if(week == 7) { // 토요일
			roomPrice += reserveDAO.getRoomSatPrice(room);
		}
		
		// 준성수기 또는 성수기인 경우 시즌 정가 추가
		String date = year + "-" + month + "-" + day;

		Integer midSeason = reserveDAO.getRoomMidSeasonPrice(date);
		Integer busiestSeason = reserveDAO.getRoomBusiestSeasonPrice(date);
		
		if(midSeason != null) { // 준성수기
			roomPrice += reserveDAO.getRoomMidSeasonPriceAdd(room);
		}
		if(busiestSeason != null) { // 성수기
			roomPrice += reserveDAO.getRoomBusiestSeasonPriceAdd(room);
		}
		
		return roomPrice;
	}

	@Override
	public Integer getOptionPrice(int optionNum) {
		return reserveDAO.getOptionPrice(optionNum);
	}

	@Override
	public void insertCustomer(String name, String phone) {
		reserveDAO.insertCustomer(name, phone);
	}

	@Override
	public void insertReserve(ReserveVO reserveVO) {
		// 배열을 한 문장으로 합치기
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<reserveVO.getOption().size(); i++) {
			sb.append(reserveVO.getOption().get(i));
			
			// 마지막 옵션의 경우 콤마를 넣어주지 않음
			if(i != (reserveVO.getOption().size() - 1)) {
				sb.append(",");
			}
		}
		
		reserveVO.setOptionToString(sb.toString());
		
		String year = reserveVO.getCheckInYear() + "";
		String month = String.format("%02d", reserveVO.getCheckInMonth());
		String day = String.format("%02d", reserveVO.getCheckInDay());
		
		int monthToInt = Integer.parseInt(month);
		int dayToInt = Integer.parseInt(day);
		
		reserveVO.setCheckInDate(year + "-" + month + "-" + day);
		
		// 체크아웃 날짜까지 반복 삽입
		for(int i=0; i<=reserveVO.getNight(); i++) {
			reserveDAO.insertReserve(reserveVO);
			
			dayToInt += 1;
			
			// 이 달의 마지막 날짜를 초과하는 경우
			if(dayToInt > reserveVO.getLastDay()) {
				monthToInt += 1;
				dayToInt = dayToInt - reserveVO.getLastDay();
			}
			
			reserveVO.setCheckInDate(year + "-" + monthToInt + "-" + dayToInt);
		}
		
		// 다음 예약 접수 상태 등록을 위해 갱신
		reserveVO.setCheckInYear(Integer.parseInt(year));
		reserveVO.setCheckInMonth(monthToInt);
		reserveVO.setCheckInDay(dayToInt);
	}

	@Override
	public void insertReserveStatus(ReserveVO reserveVO) {
		int year = reserveVO.getCheckInYear();
		int month = reserveVO.getCheckInMonth();
		int day = reserveVO.getCheckInDay() - 1;
		
		reserveVO.setCheckInDate(year + "-" + month + "-" + day);
		
		reserveDAO.insertReserveStatus(reserveVO);
	}

	@Override
	public Map<String, String> getAccountInfo() {
		return reserveDAO.getAccountInfo();
	}
}
