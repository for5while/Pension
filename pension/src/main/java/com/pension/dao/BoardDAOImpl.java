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
	public void insert(String board, BoardVO boardVO) {
		Map<String, Object> param = new HashMap<>();
		
		param.put("board", "community_" + board);
		param.put("boardVO", boardVO);
		
		sqlSession.insert(nameSpace + ".insert", param);
	}
	
	@Override
	public void update(String board, int num, BoardVO boardVO) {
		Map<String, Object> param = new HashMap<>();
		
		param.put("board", "community_" + board);
		param.put("num", num);
		param.put("boardVO", boardVO);
		
		sqlSession.insert(nameSpace + ".update", param);
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

	@Override
	public String getContentPassword(String board, int num) {
		Map<Object, Object> param = new HashMap<>();
		
		param.put("board", "community_" + board);
		param.put("num", num);
		
		return sqlSession.selectOne(nameSpace + ".getContentPassword", param);
	}

	@Override
	public BoardVO getContent(String board, int num) {
		Map<Object, Object> param = new HashMap<>();
		
		param.put("board", "community_" + board);
		param.put("num", num);
		
		return sqlSession.selectOne(nameSpace + ".getContent", param);
	}
	
}
