<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<footer>
	<div id="bottom">
		<div class="wrap">
			<div class="subject">INFORMATIONS</div>
			<div class="content">
				<p>주소 : 부산광역시 사상구 주례동 00-000</p>
				<p>연락처 : 010-0000-0000</p>
				<p>상호명 : 깊어지는 밤 펜션 / 대표 : 홍길동</p>
			</div>
			<div class="content">
				<p>계좌번호 : 국민 000000-00-000000 홍길동</p>
				<p>사업자등록번호 : 000-00-00000</p>
				<p>통신판매업신고번호 : 0000-부산해운대-0000호</p>
			</div>
			<div class="content">
				<p>깊어지는 밤 펜션은 포트폴리오 사이트 제출 목적으로 제작 되었으며,</p>
				<p>상업 운영 목적이 아님을 알려드립니다.</p>
				<p>
					<a href="https://github.com/for5while" target="_blank" style="color:#4cbb64">깃허브 바로가기</a> /
					<c:choose>
						<c:when test="${sessionScope.adminId eq null }"> 
							<a href="<c:url value='/administrator/login' />" style="color:#999">관리자 로그인</a>
						</c:when>
						<c:otherwise>
							<a href="<c:url value='/administrator/logout' />" style="color:#999">로그아웃</a>
						</c:otherwise>
					</c:choose>
				</p>
			</div>
		</div>
	</div>
</footer>
