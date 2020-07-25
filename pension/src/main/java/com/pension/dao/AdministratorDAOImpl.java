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
}
