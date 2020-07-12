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
				<c:choose>
					<c:when test="${board eq 'notice' }">
						<sec:authorize access="isAuthenticated()">
							<div class="management">
								<a onclick="passwordConfirm('${board }', ${num }, ${page }, 'modify');" style="background:#2572ff;cursor:pointer">수정</a>
								<a href="<c:url value='/community/delete?board=${board }&num=${num }' />" style="background:#ff2525">삭제</a>
							</div>
						</sec:authorize>
					</c:when>
					<c:otherwise>
						<div class="management">
							<a onclick="passwordConfirm('${board }', ${num }, ${page }, 'modify');" style="background:#2572ff;cursor:pointer">수정</a>
							<a href="<c:url value='/community/delete?board=${board }&num=${num }' />" style="background:#ff2525">삭제</a>
						</div>
					</c:otherwise>
				</c:choose>
				<a class="btn_list" href="<c:url value='/community/list?board=${board }&page=${page }' />">목록</a>
			</div>
		</div>
	</div>
</section>

<script type="text/javascript">
function passwordConfirm(board, num, page, type) {
	Swal.fire({
		title: "글 비밀번호를 입력하세요.",
		input: "password",
		showCancelButton: true,
		cancelButtonText: "닫기",
		confirmButtonColor: "#DD6B55",
		confirmButtonText: "확인",
		preConfirm: (inputPassword) => {
			$.ajax({
				url: "../community/modifyConfirm?board=" + board + "&num=" + num + "&page=" + page + "&password=" + inputPassword,
				type: "GET",
				success: function(data) {
					if(data == "diff") {
						Swal.fire("앗!", "비밀번호가 일치하지 않습니다.", "error");
					} else {
						location.href = data;
					}
				},
				error: function() {
					Swal.fire(":(", "지금은 서버와 통신할 수 없습니다.<br>잠시 후 다시 시도해주십시오.", "error");
				}
			});
		}
	})
}
</script>
