<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mini-background eighth">
	<div>실시간 예약</div>
</div>

<fmt:formatNumber var="totalPrice" value="${totalPrice }" type="currency" currencySymbol="" />

<section>
	<div class="wrap">
		<div class="write2">
			<div>
				<div class="subject">
					<span>01</span>
					<span>금액 및 입금계좌 확인</span>
				</div>
				<div class="content">
					<div>
						<span class="title">입금 금액</span>
						<span class="info">${totalPrice }원</span>
					</div>
					<div>
						<span class="title">입금 계좌</span>
						<span class="info">${account.bank } ${account.number } ${account.holder }</span>
					</div>
					<div>
						<span class="title">입금 대기 시간</span>
						<span class="info">${year }년 ${month }월 ${day }일 <strong>${hour }시 ${minute }분</strong>까지 입금 <strong>(1시간)</strong></span>
					</div>
				</div>
				<div class="content">
					<div>
						<span class="title">예약자 성함</span>
						<span class="info">${name }</span>
					</div>
					<div>
						<span class="title">연락처</span>
						<span class="info">${phone }</span>
					</div>
				</div>
			</div>
			<div id="guide">
				<p class="word">정상적으로 예약 신청이 접수되었습니다.</p>
				<ul>
					<li>입금 시 반드시 <span>예약자 성함의 명의로 입금</span>해주시기 바랍니다.</li>
					<li>1시간 내로 입금이 없을 시 예약 신청이 자동으로 취소됩니다.</li>
					<li>예약 진행 상황은 [실시간 예약] 또는 [예약 확인] 페이지에서 확인 가능합니다.</li>
				</ul>
			</div>
		</div>
	</div>
</section>
