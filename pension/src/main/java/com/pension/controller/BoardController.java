package com.pension.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pension.service.BoardService;
import com.pension.vo.BoardVO;
import com.pension.vo.PageVO;

@Controller
public class BoardController {

	@Inject
	private BoardService boardService;
	
	// 게시판 존재 여부 판별
	public boolean invalidBoard(String board) {
		if(!board.equals("notice") && !board.equals("qna") && !board.equals("review")) {
			return true;
		}
		
		return false;
	}
	
	@RequestMapping(value = "/community/write", method = RequestMethod.GET)
	public String write(Model model,
						@RequestParam(defaultValue = "none") String board) {
		
		model.addAttribute("board", board);
		
		return "/community/write";
	}
	
	@RequestMapping(value = "/community/write", method = RequestMethod.POST)
	public String writePost(BoardVO boardVO,
							HttpSession session,
							@RequestParam(defaultValue = "none") String board) {
		
		// 공지사항 게시판일 때
		if(board.equals("notice")) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Object principal = auth.getPrincipal(); // 익명일 경우 'anonymousUser', 아닐 경우 로그인된 객체 리턴
			
			// 시큐리티로 인증 받지 못한 사용자인지
			if(principal.equals("anonymousUser")) {
				session.setAttribute("error", "글쓰기 권한이 없습니다.");
				return "/layout/index";
			}
		}
		
		boardService.insert(board, boardVO);
		session.setAttribute("message", "글쓰기 완료!");
		
		return "redirect:/community/list?board=" + board;
	}
	
	@RequestMapping(value = "/community/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session,  
						@RequestParam(defaultValue = "1") int page, 
						@RequestParam(defaultValue = "none") String board) {
		
		if(invalidBoard(board)) {
			session.setAttribute("error", "존재하지 않는 게시판입니다.");
			return "/layout/index";
		}
		
		PageVO pageVO = new PageVO();
		
		pageVO.setPageNum(page); // 페이지 파라미터 없으면 1 페이지 유지
		pageVO.setPageSize(10); // 한 페이지에 보여줄 글 갯수
		pageVO.setCount(boardService.getWriteCount(board)); // 전체 게시글 갯수 (pageCount, pageBlock, startPage, endPage 값 설정)
		
		List<BoardVO> list = boardService.getList(board, pageVO);
		
		model.addAttribute("board", board);
		model.addAttribute("list", list);
		model.addAttribute("pageVO", pageVO);
		
		return "/community/list";
	}
	
	@ResponseBody
	@RequestMapping(value = "/community/viewConfirm", method = RequestMethod.GET)
	public String viewConfirm(@RequestParam String board,
							  @RequestParam int num, 
							  @RequestParam int page,
							  @RequestParam Map<String, String> inputPassword) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object principal = auth.getPrincipal(); // 익명일 경우 'anonymousUser', 아닐 경우 로그인된 객체 리턴
		
		// 시큐리티로 로그인 된 멤버는 패스워드 일치 여부 미확인
		if(!principal.equals("anonymousUser")) {
			return "../community/view?board=" + board + "&num=" + num + "&page=" + page;
		}
		
		String contentPassword = boardService.getContentPassword(num);
		
		// 입력받은 패스워드와 저장된 글 데이터의 패스워드가 일치한지
		if(inputPassword.containsValue(contentPassword)) {
			return "../community/view?board=" + board + "&num=" + num + "&page=" + page;
		} else {
			return "diff";
		}
	}
	
	@RequestMapping(value = "/community/noticeView", method = RequestMethod.GET)
	public String noticeView() {
		return "/community/noticeView";
	}
	
	@RequestMapping(value = "/community/noticeModify", method = RequestMethod.GET)
	public String noticeModify() {
		return "/community/noticeModify";
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
	
	@RequestMapping(value = "/community/reviewModify", method = RequestMethod.GET)
	public String reviewModify() {
		return "/community/reviewModify";
	}
	
	@RequestMapping(value = "/community/reviewView", method = RequestMethod.GET)
	public String reviewView() {
		return "/community/reviewView";
	}
	
}
