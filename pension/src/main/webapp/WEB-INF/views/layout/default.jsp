<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>깊어지는 밤 펜션</title><!-- http://remotepension.ga -->
		
		<link href="<c:url value='/resources/css/layout.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/resources/css/page.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/resources/css/board.css' />" rel="stylesheet" type="text/css" />
		<link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/moonspam/NanumBarunGothic@latest/nanumbarungothicsubset.css">
		<link href="//db.onlinewebfonts.com/c/35e5d1a7aa6da471de4cfb4a47ebaca8?family=Futura+Std+Book" rel="stylesheet" type="text/css"/>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@9/dist/sweetalert2.min.css">
		
		<script src="<c:url value='/resources/js/jquery-3.4.1.min.js' />"></script>
		<script src="<c:url value='/resources/js/jquery-ui-1.8.5.min.js' />"></script>
		<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
		<tiles:insertAttribute name="head" />
		
		<!-- 에러 세션 -->
		<c:if test="${sessionScope.error ne null}">
			<script type="text/javascript">
			$(document).ready(function(){
				var error = "${sessionScope.error }";
				
				if(error != '') {
					Swal.fire({
						position: 'top-end',
						type: 'error',
						icon: 'error',
						title: error,
						width: 700,
						showConfirmButton: false,
						timer: 1500,
						timerProgressBar: true
					})
				}
			});
			</script>
			<c:remove var="error" scope="session" />
		</c:if>
		
		<!-- 메시지 세션 -->
		<c:if test="${sessionScope.message ne null}">
			<script type="text/javascript">
			$(document).ready(function(){
				var message = "${sessionScope.message }";
				
				if(message != '') {
					Swal.fire({
						position: 'top-end',
						type: 'success',
						icon: 'success',
						title: message,
						width: 700,
						showConfirmButton: false,
						timer: 1500,
						timerProgressBar: true
					})
				}
			});
			</script>
			<c:remove var="message" scope="session" />
		</c:if>
	</head>
	<body style="padding-right:0 !important;overflow-x:hidden">
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="tail" />
	</body>
</html>
