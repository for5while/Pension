<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<div class="mini-background eighth">
	<div>실시간 예약</div>
</div>

<fmt:formatNumber var="month" value="${month }" pattern="00" />
<fmt:formatNumber var="day" value="${day }" pattern="00" />
<fmt:formatNumber var="roomPrice" value="${roomPrice }" type="currency" currencySymbol="" />
<fmt:formatNumber var="optionPrice" value="${optionPrice }" type="currency" currencySymbol="" />
<fmt:formatNumber var="totalPrice" value="${totalPrice }" type="currency" currencySymbol="" />

<section>
	<div class="wrap">
		<div class="write2">
			<form action="<c:url value='../reserve/write2' />" method="post">
				<div>
					<div class="subject">
						<span>01</span>
						<span>선택사항 확인</span>
					</div>
					<div class="content">
						<div>
							<span class="title">객실</span>
							<span class="info">${room }</span>
						</div>
						<div>
							<span class="title">날짜</span>
							<span class="info">${year }-${month }-${day } ~ ${checkOutDate }</span>
						</div>
						<div>
							<span class="title">숙박인원</span>
							<span class="info">성인 = ${adult }명, 아동 = ${child }명, 유아 = ${infant }명</span>
						</div>
						<div>
							<span class="title">옵션</span>
							<span class="info option">
								<c:forEach var="option" varStatus="index" items="${optionNames }">
									<span>${option }</span>
									<c:if test="${not index.last }">,</c:if>
								</c:forEach>
							</span>
						</div>
						<div>
							<span class="title">가격</span>
							<span class="info">객실금액 = ${roomPrice }원 + 옵션추가금액 = ${optionPrice }원 <strong>::</strong> 합계 = <strong>${totalPrice }원</strong></span>
						</div>
					</div>
				</div>
				<div>
					<div class="subject">
						<span>02</span>
						<span>개인정보 입력</span>
					</div>
					<div class="content">
						<div>
							<span class="title">이름</span>
							<span class="info"><input type="text" name="name" required="required"></span>
						</div>
						<div>
							<span class="title">연락처</span>
							<span class="info"><input type="text" name="phone" required="required"></span>
						</div>
						<div>
							<span class="title">요청사항</span>
							<span class="info"><input type="text" name="message"></span>
						</div>
					</div>
				</div>
				<div>
					<div class="subject">
						<span>03</span>
						<span>기타 선택사항</span>
					</div>
					<div class="content">
						<div>
							<span class="title">체크인 시간</span>
							<span class="info">
								<select name="check_in_time" required="required">
									<option value="">선택</option>
									<option value="15">15시</option>
									<option value="16">16시</option>
									<option value="17">17시</option>
									<option value="18">18시</option>
									<option value="19">19시</option>
									<option value="20">20시 이후</option>
								</select>
							</span>
						</div>
					</div>
				</div>
				
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
				<input type="hidden" name="room" value="${room }">
				<input type="hidden" name="year" value="${year }">
				<input type="hidden" name="month" value="${month }">
				<input type="hidden" name="day" value="${day }">
				<input type="hidden" name="lastDay" value="${param.lastDay }">
				<input type="hidden" name="checkOutDate" value="${checkOutDate }">
				<input type="hidden" name="stayDate" value="${stayDate }">
				<input type="hidden" name="adult" value="${adult }">
				<input type="hidden" name="child" value="${child }">
				<input type="hidden" name="infant" value="${infant }">
				
				<c:if test="${not empty paramValues.option }">
					<c:forEach var="i" begin="0" end="${fn:length(paramValues.option) - 1 }">
						<input type="hidden" name="option" value="${paramValues.option[i] }">
					</c:forEach>
				</c:if>
				
				<input type="submit" class="btn_next" value="완료">
			</form>
		</div>
	</div>
</section>
