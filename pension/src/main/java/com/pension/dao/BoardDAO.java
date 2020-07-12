package com.pension.dao;

import java.util.List;

import com.pension.vo.BoardVO;
import com.pension.vo.PageVO;

public interface BoardDAO {
	public void insert(String board, BoardVO boardVO);
	public List<BoardVO> getList(String board, PageVO pageVO);
	public Integer getWriteCount(String board);
	public String getContentPassword(int num);
	public BoardVO getContent(String board, int num);
}
