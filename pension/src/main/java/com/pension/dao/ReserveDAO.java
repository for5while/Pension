package com.pension.dao;

import java.util.List;

import com.pension.vo.ReserveVO;

public interface ReserveDAO {
	public List<ReserveVO> getRoomList();
	public Integer getRoomStatus(String date, int roomNum);
	public Integer getRoomIsPayment(int roomNum);
	public String getRoomName(int roomNum);
	public String isMidSeason(String date);
	public String isBusiestSeason(String date);
}
