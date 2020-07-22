package com.pension.service;

import java.util.List;
import java.util.Map;

import com.pension.vo.ReserveVO;

public interface ReserveService {
	public List<Object> getList(ReserveVO reserveVO, int year, int month);
	public List<Object> getRoomInfo(String room);
	public List<Object> getRoomOption(String room);
	
	public String getOptionName(int optionNum);
	public Integer getOptionPrice(int optionNum);
	public int getRoomPrice(String room, int stayDate, int year, int month, int day);
	
	public void insertCustomer(String name, String phone);
	public void insertReserve(ReserveVO reserveVO);
	public void insertReserveStatus(ReserveVO reserveVO);
	
	public Map<String, String> getAccountInfo();
}
