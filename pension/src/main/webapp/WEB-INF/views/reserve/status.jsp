<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mini-background eighth">
	<div>실시간 예약</div>
</div>

<section>
	<div class="wrap">
		<div class="write2">
			<div>
				<div class="subject">
					<span>01</span>
					<span>예약 상태 확인</span>
				</div>
				<div class="content">
					<div>
						<span class="title">
							<span>접수/결제 시간</span>
						</span>
						<span class="info">${reserveStatus.payment_datetime }</span>
					</div>
					<div>
						<span class="title">예약 상태</span>
						<span class="info">
							<c:choose>
								<c:when test="${reserveStatus.is_payment eq 0 }">
									<span>미완료</span>
								</c:when>
								<c:otherwise>
									<span>완료</span>
								</c:otherwise>
							</c:choose>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
