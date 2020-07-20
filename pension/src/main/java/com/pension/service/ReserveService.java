package com.pension.service;

import java.util.List;

import com.pension.vo.ReserveVO;

public interface ReserveService {
	public List<Object> getList(ReserveVO reserveVO, int year, int month);
	public List<Object> getRoomInfo(String room);
	public List<Object> getRoomOption(String room);
}
