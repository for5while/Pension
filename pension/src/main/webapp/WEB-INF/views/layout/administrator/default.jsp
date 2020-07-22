<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
	    <title>깊어지는 밤 펜션 관리</title>
	
	    <meta charset="utf-8">
	    <meta content="width=device-width, initial-scale=1.0" name="viewport" />
	    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
	
	    <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">
	    <link href="<c:url value='/resources/css/material-dashboard.css?v=2.1.2' />" rel="stylesheet" />
	    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@9/dist/sweetalert2.min.css">
	    
	    <script src="<c:url value='/resources/js/jquery-3.4.1.min.js' />"></script>
	    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
	    
	    <!-- 에러 세션 -->
		<c:if test="${sessionScope.error ne null}">
			<script type="text/javascript">
			$(document).ready(function(){
				var error = "${sessionScope.error }";
				
				if(error != '') {
					Swal.fire({
						toast: true,
						position: 'top-end',
						type: 'error',
						icon: 'error',
						title: error,
						showConfirmButton: false,
						timer: 3500,
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
						toast: true,
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
	<body>
		<tiles:insertAttribute name="head" />
		<tiles:insertAttribute name="content" />
		<tiles:insertAttribute name="tail" />
		
		<script src="<c:url value='/resources/js/plugins/perfect-scrollbar.jquery.min.js' />"></script>
		<script src="<c:url value='/resources/js/material-dashboard.js?v=2.1.2' />" type="text/javascript"></script>
	</body>
</html>
