package com.pension.dao;

import java.util.List;

import com.pension.vo.ReserveVO;

public interface ReserveDAO {
	public List<ReserveVO> getRoomList();
	public Integer getRoomStatus(int day, int roomNum);
	public Integer getRoomIsPayment(int roomNum);
	public String getRoomName(int roomNum);
}
