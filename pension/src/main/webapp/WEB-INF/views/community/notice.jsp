<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mini-background ninth">
	<div>공지사항</div>
</div>

<section>
	<div class="wrap">
		<div id="list">
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
						<th>날짜 </th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>11</td>
						<td>제목제목</td>
						<td>글쓴이글쓴이</td>
						<td>07-02</td>
						<!--
						<td colspan="5" class="empty_table">게시물이 없습니다.</td>
						-->
					</tr>
				</tbody>
			</table>
			
			<c:if test="${sessionScope.adminId ne null }">
				<a href="<c:url value='/community/noticeWrite' />">글쓰기</a>
			</c:if>
		</div>
	</div>
</section>
