<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

<div class="mini-background eighth">
	<div>실시간 예약</div>
</div>

<section>
	<div class="wrap">
		<div class="reserve">
			<div class="header">
				<span class="legend">
					<span>예약가능</span>
					<span>예약대기</span>
					<span>예약완료</span>
				</span>
				<span class="date">
					<span class="prev">
						<a href="<c:url value='../reserve/real?year=${reserveVO.year }&month=${reserveVO.month }' />">
							<span class="material-icons margin-right border">keyboard_arrow_left</span>
						</a>
					</span>
					<span class="month">${reserveVO.year }-${reserveVO.month + 1 } </span>
					<span class="next">
						<a href="<c:url value='../reserve/real?year=${reserveVO.year }&month=${reserveVO.month + 2 }' />">
							<span class="material-icons margin-left border">keyboard_arrow_right</span>
						</a>
					</span>
				</span>
				<span class="confirm">
					<a href="<c:url value='../reserve/confirm' />"><span class="material-icons left margin-right">alarm</span>예약확인</a>
				</span>
			</div>
			
			<div class="week">
				<ul>
					<li class="sun">SUN</li>
					<li>MON</li>
					<li>TUE</li>
					<li>WED</li>
					<li>THU</li>
					<li>FRI</li>
					<li class="sat">SAT</li>
				</ul>
			</div>

			<div class="days">
				<c:forEach var="i" begin="1" items="${calendar[1] }">
					<div class="wrap">
						<c:choose>
							<c:when test="${i eq 111 }">
								<div class="row">
									<span>-</span>
									<span></span>
								</div>
								<ul></ul>
							</c:when>
							<c:otherwise>
								<c:if test="${i ne 999 }">
									<div class="row">
										<span>${i }일</span>
										<span>준성수기</span>
									</div>
									<ul>
										<c:forEach var="j" items="${calendar[2] }">
											<c:if test="${j.key eq i }">
												<c:forEach var="k" items="${j.value }">
													<li>${k.key }</li>
												</c:forEach>
											</c:if>
										</c:forEach>
									</ul>
								</c:if>
							</c:otherwise>
						</c:choose>
						<c:if test="${i eq 999 }">
							<div class="row">
								<span>-</span>
								<span></span>
							</div>
							<ul></ul>
						</c:if>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</section>
