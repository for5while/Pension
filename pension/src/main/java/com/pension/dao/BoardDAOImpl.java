package com.pension.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.pension.vo.BoardVO;
import com.pension.vo.PageVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	private static String nameSpace = "com.pension.sqlmap.mappers.boardMapper";

	@Override
	public void insert(BoardVO boardVO) {
		sqlSession.insert(nameSpace + ".insert", boardVO);
	}

	@Override
	public List<BoardVO> getList(String board, PageVO pageVO) {
		Map<String, Object> param = new HashMap<>();
		
		param.put("board", "community_" + board);
		param.put("pageVO", pageVO);
		
		return sqlSession.selectList(nameSpace + ".getList", param);
	}

	@Override
	public Integer getWriteCount(String board) {
		Map<String, Object> param = new HashMap<>();
		
		param.put("board", "community_" + board);
		
		return sqlSession.selectOne(nameSpace + ".getWriteCount", param);
	}
	
}
