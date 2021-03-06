package com.pension.service;

import java.util.List;

import com.pension.vo.BoardVO;
import com.pension.vo.PageVO;

public interface BoardService {
	public void insert(String board, BoardVO boardVO);
	public void update(String board, int num, BoardVO boardVO);
	public void delete(String board, int num);
	public List<BoardVO> getList(String board, PageVO pageVO);
	public Integer getWriteCount(String board);
	public String getContentPassword(String board, int num);
	public BoardVO getContent(String board, int num);
}
