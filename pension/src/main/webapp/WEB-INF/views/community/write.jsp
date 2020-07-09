<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${board eq 'notice' }"><c:set var="boardName" value="공지사항" /></c:if>
<c:if test="${board eq 'qna' }"><c:set var="boardName" value="문의하기" /></c:if>
<c:if test="${board eq 'review' }"><c:set var="boardName" value="숙박후기" /></c:if>

<div class="mini-background ninth">
	<div><c:out value="${boardName }" /></div>
</div>

<section>
	<div class="wrap">
		<div id="write">
			<form action="<c:url value='/community/write?board=${board }' />" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				
				<c:if test="${board ne 'notice' }">
					<input type="text" name="name" maxlength="5" placeholder="이름" required="required">
					<input type="password" name="password" maxlength="20" placeholder="비밀번호" required="required">
				</c:if>
				
				<input type="text" name="subject" placeholder="제목" required="required">
				<textarea rows="20" name="content" placeholder="글 내용을 입력하세요." required="required"></textarea>
				<input type="submit" value="글쓰기">
			</form>
		</div>
	</div>
</section>
