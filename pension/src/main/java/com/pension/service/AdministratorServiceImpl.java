package com.pension.service;

import java.util.List;

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

	@Override
	public List<String> getCustomerList() {
		return administratorDAO.getCustomerList();
	}

	@Override
	public List<Object> getReserveList() {
		return administratorDAO.getReserveList();
	}

	@Override
	public void updateReserveStatus(int reserveNo) {
		administratorDAO.updateReserveStatus(reserveNo);
	}

	@Override
	public List<Object> getRoomsList() {
		return administratorDAO.getRoomsList();
	}

	@Override
	public void insertRoom(AdministratorVO administratorVO) {
		administratorDAO.insertRoom(administratorVO);
	}

	@Override
	public List<Object> getRoomsOptionList() {
		return administratorDAO.getRoomsOptionList();
	}

	@Override
	public void insertRoomOption(AdministratorVO administratorVO) {
		administratorDAO.insertRoomOption(administratorVO);
	}

	@Override
	public void deleteRoom(int roomNo) {
		administratorDAO.deleteRoom(roomNo);
	}

	@Override
	public void deleteRoomOption(int roomOptionNo) {
		administratorDAO.deleteRoomOption(roomOptionNo);
	}

	@Override
	public List<Object> getSeasonList() {
		return administratorDAO.getSeasonList();
	}

	@Override
	public void insertSeason(AdministratorVO administratorVO) {
		String midYear = administratorVO.getMidYear();
		String midMonth = administratorVO.getMidMonth();
		String midDay = administratorVO.getMidDay();
		
		String busiestYear = administratorVO.getBusiestYear();
		String busiestMonth = administratorVO.getBusiestMonth();
		String busiestDay = administratorVO.getBusiestDay();
		
		if(midYear == "" || midMonth == "" || midDay == "") {
			administratorVO.setMidDate(null);
		} else {
			administratorVO.setMidDate(midYear + "-" + midMonth + "-" + midDay);
		}
		
		if(busiestYear == "" || busiestMonth == "" || busiestDay == "") {
			administratorVO.setBusiestDate(null);
		} else {
			administratorVO.setBusiestDate(busiestYear + "-" + busiestMonth + "-" + busiestDay);
		}
		
		administratorDAO.insertSeason(administratorVO);
	}

	@Override
	public void deleteSeason(int seasonNo) {
		administratorDAO.deleteSeason(seasonNo);
	}
}
