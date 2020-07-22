package com.pension.dao;

import java.util.List;
import java.util.Map;

import com.pension.vo.ReserveVO;

public interface ReserveDAO {
	public List<ReserveVO> getRoomList();
	public Integer getRoomStatus(String date, int roomNum);
	public Integer getRoomIsPayment(int roomNum);
	public int getRoomNumber(String roomName);
	public String getRoomName(int roomNum);
	public String isMidSeason(String date);
	public String isBusiestSeason(String date);
	
	public String getIsPass(String room, String checkOutDate);
	public Integer getNight(String room);
	public List<ReserveVO> getPeoples(String room);
	public List<Object> getOptions(String room);
	
	public String getOptionName(int optionNum);
	public Integer getOptionPrice(int optionNum);
	public int getRoomDefaultPrice(String room);
	public int getRoomFriPrice(String room);
	public int getRoomSatPrice(String room);
	public Integer getRoomMidSeasonPrice(String date);
	public Integer getRoomBusiestSeasonPrice(String date);
	public int getRoomMidSeasonPriceAdd(String room);
	public int getRoomBusiestSeasonPriceAdd(String room);
	
	public void insertCustomer(String name, String phone);
	public void insertReserve(ReserveVO reserveVO);
	public void insertReserveStatus(ReserveVO reserveVO);
	
	public Map<String, String> getAccountInfo();
}
