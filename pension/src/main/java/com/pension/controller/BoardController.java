package com.pension.controller;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
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
	
	@RequestMapping(value = "/community/list", method = RequestMethod.GET)
	public String list(Model model, HttpSession session,  
						@RequestParam(defaultValue = "1") int page, 
						@RequestParam(defaultValue = "none") String board) {
		
		if(!board.equals("notice") && !board.equals("qna") && !board.equals("review")) {
			
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

		// 시큐리티 인증 객체 가져오기
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
	
	@RequestMapping(value = "/community/noticeWrite", method = RequestMethod.GET)
	public String noticeWrite() {
		return "/community/noticeWrite";
	}
	
	@RequestMapping(value = "/community/noticeWrite", method = RequestMethod.POST)
	public String noticeWritePost(BoardVO boardVO, HttpSession session) {
		AuthenticationTrustResolver trustResolver = new AuthenticationTrustResolverImpl();
		
		if(trustResolver.isAnonymous(
				SecurityContextHolder.getContext().getAuthentication())) { // 익명
			
			session.setAttribute("error", "관리자 로그인이 필요합니다.");
		} else { // 사용자
			boardService.insert(boardVO);
		}
		
		return "redirect:/community/notice";
	}
	
	@RequestMapping(value = "/community/noticeModify", method = RequestMethod.GET)
	public String noticeModify() {
		return "/community/noticeModify";
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
