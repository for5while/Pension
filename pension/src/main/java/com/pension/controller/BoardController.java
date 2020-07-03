package com.pension.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.pension.service.BoardService;
import com.pension.vo.BoardVO;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;
	
	@RequestMapping(value = "/community/notice", method = RequestMethod.GET)
	public String notice() {
		return "/community/notice";
	}
	
	@RequestMapping(value = "/community/noticeView", method = RequestMethod.GET)
	public String noticeView() {
		return "/community/noticeView";
	}
	
	@RequestMapping(value = "/community/noticeWrite", method = RequestMethod.GET)
	public String noticeWrite() {
		return "/community/noticeWrite";
	}
	
	@RequestMapping(value = "/community/noticeWrite", method = RequestMethod.POST)
	public String noticeWritePost(BoardVO boardVO, HttpSession session) {
		String isAdmin = (String)session.getAttribute("adminId");
		
		if(isAdmin == null) {
			session.setAttribute("error", "관리자 로그인이 필요합니다.");
		} else {
			boardService.insert(boardVO);
		}
		
		return "redirect:/community/notice";
	}
	
	@RequestMapping(value = "/community/noticeModify", method = RequestMethod.GET)
	public String noticeModify() {
		return "/community/noticeModify";
	}
	
	@RequestMapping(value = "/community/qna", method = RequestMethod.GET)
	public String qna() {
		return "/community/qna";
	}
	
	@RequestMapping(value = "/community/qnaWrite", method = RequestMethod.GET)
	public String qnaWrite() {
		return "/community/qnaWrite";
	}
	
	@RequestMapping(value = "/community/qnaModify", method = RequestMethod.GET)
	public String qnaModify() {
		return "/community/qnaModify";
	}
	
	@RequestMapping(value = "/community/qnaView", method = RequestMethod.GET)
	public String qnaView() {
		return "/community/qnaView";
	}
	
	@RequestMapping(value = "/community/qnaConfirm", method = RequestMethod.GET)
	public String qnaConfirm() {
		return "/community/empty/qnaConfirm";
	}
	
	@RequestMapping(value = "/community/review", method = RequestMethod.GET)
	public String review() {
		return "/community/review";
	}
	
	@RequestMapping(value = "/community/reviewWrite", method = RequestMethod.GET)
	public String reviewWrite() {
		return "/community/reviewWrite";
	}
	
	@RequestMapping(value = "/community/reviewModify", method = RequestMethod.GET)
	public String reviewModify() {
		return "/community/reviewModify";
	}
	
	@RequestMapping(value = "/community/reviewView", method = RequestMethod.GET)
	public String reviewView() {
		return "/community/reviewView";
	}
	
}
