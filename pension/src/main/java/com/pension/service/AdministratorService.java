package com.pension.service;

import com.pension.vo.AdministratorVO;

public interface AdministratorService {
	public AdministratorVO getAccountInfo();
	public void insertAccountInfo(AdministratorVO administratorVO);
	public void deleteAccountInfo();
}
