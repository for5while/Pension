package com.pension.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pension.vo.AdministratorVO;

@Repository
public class AdministratorDAOImpl implements AdministratorDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String nameSpace = "com.pension.sqlmap.mappers.administratorMapper";

	@Override
	public AdministratorVO getAccountInfo() {
		return sqlSession.selectOne(nameSpace + ".getAccountInfo");
	}

	@Override
	public void insertAccountInfo(AdministratorVO administratorVO) {
		sqlSession.insert(nameSpace + ".insertAccountInfo", administratorVO);
	}

	@Override
	public void deleteAccountInfo() {
		sqlSession.delete(nameSpace + ".deleteAccountInfo");
	}

	@Override
	public List<String> getCustomerList() {
		return sqlSession.selectList(nameSpace + ".getCustomerList");
	}

	@Override
	public List<Object> getReserveList() {
		return sqlSession.selectList(nameSpace + ".getReserveList");
	}

	@Override
	public void updateReserveStatus(int reserveNo) {
		sqlSession.update(nameSpace + ".updateReserveStatus", reserveNo);
	}

	@Override
	public List<Object> getRoomsList() {
		return sqlSession.selectList(nameSpace + ".getRoomsList");
	}

	@Override
	public void insertRoom(AdministratorVO administratorVO) {
		sqlSession.insert(nameSpace + ".insertRoom", administratorVO);
	}

	@Override
	public List<Object> getRoomsOptionList() {
		return sqlSession.selectList(nameSpace + ".getRoomsOptionList");
	}

	@Override
	public void insertRoomOption(AdministratorVO administratorVO) {
		sqlSession.insert(nameSpace + ".insertRoomOption", administratorVO);
	}

	@Override
	public void deleteRoom(int roomNo) {
		sqlSession.delete(nameSpace + ".deleteRoom", roomNo);
	}

	@Override
	public void deleteRoomOption(int roomOptionNo) {
		sqlSession.delete(nameSpace + ".deleteRoomOption", roomOptionNo);
	}
}
