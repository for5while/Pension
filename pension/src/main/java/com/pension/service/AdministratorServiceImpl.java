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
	public AdministratorVO userCheck(AdministratorVO administratorVO) {
		return administratorDAO.userCheck(administratorVO);
	}
	
}
