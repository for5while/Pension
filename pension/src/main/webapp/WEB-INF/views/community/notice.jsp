<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:if test="${board eq 'notice' }"><c:set var="boardName" value="공지사항" /></c:if>
<c:if test="${board eq 'qna' }"><c:set var="boardName" value="문의하기" /></c:if>
<c:if test="${board eq 'review' }"><c:set var="boardName" value="숙박후기" /></c:if>

<div class="mini-background ninth">
	<div><c:out value="${boardName }" /></div>
</div>

<section>
	<div class="wrap">
		<div id="list">
			<div class="count">
				<span>총 <strong>${pageVO.count }</strong>개의 글이 있습니다.</span>
			</div>
			<table>
				<colgroup>
					<col width="100px" />
					<col width="*" />
					<col width="200px" />
					<col width="100px" />
				</colgroup>
				<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>날짜</th>
					</tr>
				</thead>
				<tbody>
					<!-- 오늘 날짜를 저장하고 비교하여 오늘이면 시간, 다른 날이면 날짜로 출력해주기 위함 -->
					<jsp:useBean id="today" class="java.util.Date"/>
					<fmt:formatDate value="${today }" pattern="MM-dd" var="today" />
					
					<c:forEach var="i" items="${list }">
						<fmt:formatDate var="writeDate" value="${i.datetime }" pattern="MM-dd" />
						<fmt:formatDate var="writeTime" value="${i.datetime }" pattern="HH:mm" />

						<tr>
							<td>${i.idx }</td>
							<td><a href="<c:url value='/community/view?board=${board }&num=${i.idx }&page=${pageVO.pageNum }' />">${i.subject }</a></td>
							<td>${i.name }</td>
							<td>
								<c:choose>
									<c:when test="${today eq writeDate }">
										${writeDate }
									</c:when>
									<c:otherwise>
										${writeTime }
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
					<c:if test="${empty list }">
						<td colspan="4" class="empty">게시물이 없습니다.</td>
					</c:if>
				</tbody>
			</table>
			
			<c:choose>
				<c:when test="${board eq 'notice' }">
					<sec:authorize access="isAuthenticated()">
						<a class="btn_write" href="<c:url value='/community/noticeWrite' />">글쓰기</a>
					</sec:authorize>
				</c:when>
				<c:otherwise>
					<a class="btn_write" href="<c:url value='/community/noticeWrite' />">글쓰기</a>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
</section>
