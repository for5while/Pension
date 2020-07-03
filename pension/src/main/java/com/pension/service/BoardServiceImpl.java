package com.pension.service;

import java.sql.Timestamp;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pension.dao.BoardDAO;
import com.pension.vo.BoardVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public void insert(BoardVO boardVO) {
		boardVO.setIdx(1);
		boardVO.setName("관리자");
		boardVO.setPassword(null);
		boardVO.setDatetime(new Timestamp(System.currentTimeMillis()));
		boardVO.setIs_secret(0);
		
		boardDAO.insert(boardVO);
	}
	
}
