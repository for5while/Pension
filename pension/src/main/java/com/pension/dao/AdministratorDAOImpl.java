package com.pension.dao;

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
	public AdministratorVO userCheck(AdministratorVO administratorVO) {
		return sqlSession.selectOne(nameSpace + ".userCheck", administratorVO);
	}
	
}
