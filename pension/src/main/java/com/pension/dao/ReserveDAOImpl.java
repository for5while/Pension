package com.pension.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ReserveDAOImpl implements ReserveDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String nameSpace = "com.pension.sqlmap.mappers.reserveMapper";
	
	
	
}
