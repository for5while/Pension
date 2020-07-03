<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<title>글 비밀번호 확인</title>
		<link href="<c:url value='/resources/css/board.css' />" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="password_confirm">
			<form action="/community/qnaConfirm" method="post">
				<input type="password" name="password" placeholder="글 비밀번호를 입력하세요." required="required" style="display:block">
				<input type="submit" class="btn_confirm" value="확인">
			</form>
		</div>
	</body>
</html>
