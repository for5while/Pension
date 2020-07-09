package com.pension.vo;

public class PageVO {
	private int count; // 전체 게시글 개수
	private int pageSize; // 한 페이지에 보여줄 글 개수
	private int pageNum; // 현재 페이지 번호 (파라미터)
	private int startRow; // 시작 행 번호
	private int endRow; // 끝 행 번호
	private int pageCount; // 전체 페이지 수
	private int pageBlock; // 한 화면에 보여줄 페이지 개수
	private int startPage; // 시작 페이지 번호
	private int endPage; // 끝 페이지 번호
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
		init();
	}
	public void init() {
		pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1); // 전체 페이지 수
		pageBlock = 10; // 한 페이지에 보여줄 페이지 개수
		startPage = (pageNum - 1) / pageBlock * pageBlock + 1; // 시작 페이지 번호
		endPage = startPage + pageBlock - 1; // 끝 페이지 번호
		
		if(endPage > pageCount) endPage = pageCount;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getStartRow() {
		return startRow;
	}
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getPageBlock() {
		return pageBlock;
	}
	public void setPageBlock(int pageBlock) {
		this.pageBlock = pageBlock;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
}
