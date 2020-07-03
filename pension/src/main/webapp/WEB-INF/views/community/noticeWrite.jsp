<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mini-background ninth">
	<div>공지사항</div>
</div>

<section>
	<div class="wrap">
		<div id="write">
			<form action="<c:url value='/community/noticeWrite' />" method="post">
				<input type="text" name="subject" placeholder="제목" required="required">
				<textarea rows="20" name="content" placeholder="글 내용을 입력하세요." required="required"></textarea>
				<input type="submit" value="글쓰기">
			</form>
		</div>
	</div>
</section>
