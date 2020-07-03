<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mini-background ninth">
	<div>공지사항</div>
</div>

<section>
	<div class="wrap">
		<div id="view">
			<div class="subject">제목</div>
			<div class="info">
				<span>글쓴이</span>
				<span>관리자</span>
				<span>작성일</span>
				<span>07-03</span>
			</div>
			<div class="content">내용</div>
			
			<div class="footer">
				<div class="management">
					<a href="<c:url value='/community/noticeModify?no=1' />" style="background:#2572ff">수정</a>
					<a href="<c:url value='/community/noticeDelete?no=1' />" style="background:#ff2525">삭제</a>
				</div>
				<a class="btn_list" href="<c:url value='/community/notice' />">목록</a>
			</div>
		</div>
	</div>
</section>
