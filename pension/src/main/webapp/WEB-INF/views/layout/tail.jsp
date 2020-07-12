<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<footer>
	<div id="bottom">
		<div class="wrap">
			<div class="subject">INFORMATIONS</div>
			<div class="content">
				<p>주소 : 부산광역시 사상구 괘법동 00-000</p>
				<p>대표 : 홍길동</p>
			</div>
			<div class="content">
				<p>사업자등록번호 : 000-00-00000</p>
				<p>통신판매업신고번호 : 0000-사상-0000호</p>
			</div>
			<div class="content">
				<p>이 사이트는 포트폴리오 제출 목적으로 제작 되었으며,</p>
				<p>상업 운영 목적이 아님을 알려드립니다.</p>
				<a href="https://github.com/for5while" target="_blank" style="color:#f3ff91">깃허브 바로가기</a>
			</div>
			<div class="content">
				<p>
					<!-- 로그인 -->
					<sec:authorize access="isAnonymous()">
			            <a href="<c:url value="/administrator/login" />" style="color:#f3ff91;float:right">관리자 로그인</a>
			        </sec:authorize>
			        
			        <!-- 로그아웃 -->
			        <sec:authorize access="isAuthenticated()">
			            <form action="<c:url value="/administrator/logout" />" method="post">
			                <input type="hidden" name="${_csrf.parameterName }" value="${_csrf.token }" />
			                <button type="submit" style="color:#f3ff91;float:right;border:none;background:none">로그아웃</button>
			            </form>
			        </sec:authorize>
				</p>
			</div>
		</div>
	</div>
</footer>
