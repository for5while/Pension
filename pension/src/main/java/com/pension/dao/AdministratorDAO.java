package com.pension.dao;

import java.util.List;

import com.pension.vo.AdministratorVO;

public interface AdministratorDAO {
	public AdministratorVO getAccountInfo();
	public void insertAccountInfo(AdministratorVO administratorVO);
	public void deleteAccountInfo();
	
	public List<String> getCustomerList();
	
	public List<Object> getReserveList();
	public void updateReserveStatus(int reserveNo);
}
