package com.pension.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pension.dao.AdministratorDAO;
import com.pension.vo.AdministratorVO;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	@Inject
	private AdministratorDAO administratorDAO;

	@Override
	public AdministratorVO getAccountInfo() {
		return administratorDAO.getAccountInfo();
	}

	@Override
	public void insertAccountInfo(AdministratorVO administratorVO) {
		administratorDAO.insertAccountInfo(administratorVO);
	}

	@Override
	public void deleteAccountInfo() {
		administratorDAO.deleteAccountInfo();
	}
}
