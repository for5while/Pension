<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mini-background eighth">
	<div>예약 확인</div>
</div>

<section>
	<div class="wrap">
		<div class="confirm">
			<form action="<c:url value='/reserve/confirm' />" method="post">
				<div>
					<input type="text" name="depositor" placeholder="입금자명" required="required">
				</div>
				<div>
					<select name="date">
						<option value="0">입금한 날짜를 선택하세요.</option>
						<option value="1">1일</option>
						<option value="2">2일</option>
						<option value="3">3일</option>
						<option value="4">4일</option>
						<option value="5">5일</option>
						<option value="6">6일</option>
						<option value="7">7일</option>
						<option value="8">8일</option>
						<option value="9">9일</option>
						<option value="10">10일</option>
						<option value="11">11일</option>
						<option value="12">12일</option>
						<option value="13">13일</option>
						<option value="14">14일</option>
						<option value="15">15일</option>
						<option value="16">16일</option>
						<option value="17">17일</option>
						<option value="18">18일</option>
						<option value="19">19일</option>
						<option value="20">20일</option>
						<option value="21">21일</option>
						<option value="22">22일</option>
						<option value="23">23일</option>
						<option value="24">24일</option>
						<option value="25">25일</option>
						<option value="26">26일</option>
						<option value="27">27일</option>
						<option value="28">28일</option>
						<option value="29">29일</option>
						<option value="30">30일</option>
						<option value="31">31일</option>
					</select>
				</div>
				<div>
					<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
					<input type="submit" class="btn_next" value="확인">
				</div>
			</form>
		</div>
	</div>
</section>
