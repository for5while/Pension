<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="mini-background ninth">
	<div>관리자 로그인</div>
</div>

<section>
	<div class="wrap">
		<div id="login">
			<form action="<c:url value='/administrator/userLogin' />" method="post">
				<input type="text" name="id" placeholder="아이디" required="required">
				<input type="password" name="password" placeholder="비밀번호" required="required">
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
				<input type="submit" class="btn_login" value="로그인">
			</form>
		</div>
	</div>
</section>
