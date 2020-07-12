<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:if test="${board eq 'notice' }"><c:set var="boardName" value="공지사항" /></c:if>
<c:if test="${board eq 'qna' }"><c:set var="boardName" value="문의하기" /></c:if>
<c:if test="${board eq 'review' }"><c:set var="boardName" value="숙박후기" /></c:if>

<div class="mini-background ninth">
	<div><c:out value="${boardName }" /></div>
</div>

<section>
	<div class="wrap">
		<div id="view">
			<div class="subject">${boardVO.subject }</div>
			<div class="info">
				<fmt:formatDate var="writeDatetime" value="${boardVO.datetime }" pattern="MM-dd HH:mm" />
				
				<span>글쓴이</span>
				<span>${boardVO.name }</span>
				<span>작성일</span>
				<span>${writeDatetime }</span>
			</div>
			<div class="content">${boardVO.content }</div>
			
			<div class="footer">
				<div class="management">
					<a href="<c:url value='/community/modify?board=${board }&num=${num }&page=${page }' />" style="background:#2572ff">수정</a>
					<a href="<c:url value='/community/delete?board=${board }&num=${num }' />" style="background:#ff2525">삭제</a>
				</div>
				<a class="btn_list" href="<c:url value='/community/list?board=${board }&page=${page }' />">목록</a>
			</div>
		</div>
	</div>
</section>
