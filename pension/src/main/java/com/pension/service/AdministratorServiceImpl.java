package com.pension.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pension.dao.AdministratorDAO;

@Service
public class AdministratorServiceImpl implements AdministratorService {
	
	@Inject
	private AdministratorDAO administratorDAO;
	
}
