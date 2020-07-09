package com.pension.service;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.pension.dao.BoardDAO;
import com.pension.vo.BoardVO;
import com.pension.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Inject
	private BoardDAO boardDAO;

	@Override
	public void insert(String board, BoardVO boardVO) {
		boardVO.setName(boardVO.getName());
		boardVO.setPassword(boardVO.getPassword());
		boardVO.setIdx(0);
		boardVO.setDatetime(new Timestamp(System.currentTimeMillis()));
		
		switch(board) {
		case "notice":
			boardVO.setName("관리자");
			boardVO.setPassword(null);
			boardVO.setIs_secret(0);
			break;
		case "qna":
			boardVO.setIs_secret(1);
			break;
		default:
			boardVO.setIs_secret(0);
		}
		
		boardDAO.insert(board, boardVO);
	}

	@Override
	public List<BoardVO> getList(String board, PageVO pageVO) {
		int startRow = (pageVO.getPageNum() - 1) * pageVO.getPageSize();
		pageVO.setStartRow(startRow);
		
		return boardDAO.getList(board, pageVO);
	}

	@Override
	public Integer getWriteCount(String board) {
		return boardDAO.getWriteCount(board);
	}

	@Override
	public String getContentPassword(int num) {
		return boardDAO.getContentPassword(num);
	}
	
}
