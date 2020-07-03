package com.pension.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pension.vo.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String nameSpace = "com.pension.sqlmap.mappers.boardMapper";

	@Override
	public void insert(BoardVO boardVO) {
		sqlSession.insert(nameSpace + ".insert", boardVO);
	}
	
}
