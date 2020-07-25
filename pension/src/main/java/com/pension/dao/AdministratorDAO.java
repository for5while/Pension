package com.pension.dao;

import com.pension.vo.AdministratorVO;

public interface AdministratorDAO {
	public AdministratorVO getAccountInfo();
	public void insertAccountInfo(AdministratorVO administratorVO);
	public void deleteAccountInfo();
}
