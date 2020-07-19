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
					<span class="month">${reserveVO.year }-${reserveVO.month+1 } </span>
					<span class="next">
						<a href="<c:url value='../reserve/real?year=${reserveVO.year }&month=${reserveVO.month+2 }' />">
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
				<!-- 이 달의 날짜 { -->
				<c:forEach var="day" begin="1" items="${calendar[1] }">
					<div class="wrap">
						<c:choose>
							
							<c:when test="${day eq 111 }">
								<!-- 1일 앞에 빈 공간 채우기 -->
								<div class="row">
									<span>-</span>
									<span></span>
								</div>
								<ul></ul>
							</c:when>
							
							<c:otherwise>
								<!-- 이 달의 일치하는 날짜 -->
								<c:if test="${day ne 999 }">
									<div class="row">
										<span>${day }일</span>
										<span>
											<!-- 준/성수기 구분 -->
											<c:forEach var="season" items="${calendar[3] }">
												<c:choose>
													<c:when test="${season.key eq day and season.value eq 1 }">준성수기</c:when>
													<c:when test="${season.key eq day and season.value eq 2 }">성수기</c:when>
												</c:choose>
											</c:forEach>
										</span>
									</div>
									<ul>
										<!-- 등록된 방 리스트 출력 { -->
										<c:forEach var="room" items="${calendar[2] }">
											<c:if test="${room.key eq day }">
												<c:forEach var="num" items="${room.value }">
												
													<!-- 예약 상태 구분 -->
													<c:choose>
														<c:when test="${num.value eq 1 }">
															<c:set var="roomStatus" value="stand_by" />
														</c:when>
														<c:when test="${num.value eq 2 }">
															<c:set var="roomStatus" value="complete" />
														</c:when>
														<c:otherwise>
															<c:set var="roomStatus" value="possible" />
														</c:otherwise>
													</c:choose>
													
													<li class="${roomStatus }">
														<c:url var="write" value="../reserve/write">
															<c:param name="room" value="${num.key }" />
															<c:param name="year" value="${reserveVO.year }" />
															<c:param name="month" value="${reserveVO.month+1 }" />
															<c:param name="day" value="${day }" />
														</c:url>
														
														<c:choose>
															<c:when test="${num.value eq 0 }">
																<a href="${write }">${num.key }</a>
															</c:when>
															<c:otherwise>
																${num.key }
															</c:otherwise>
														</c:choose>
													</li>
												</c:forEach>
											</c:if>
										</c:forEach>
										<!-- } 등록된 방 리스트 출력 -->
									</ul>
								</c:if>
							</c:otherwise>
						</c:choose>
						
						<!-- 이 달의 마지막 날짜 이후로 빈 공간 채우기 -->
						<c:if test="${day eq 999 }">
							<div class="row">
								<span>-</span>
								<span></span>
							</div>
							<ul></ul>
						</c:if>
					</div>
				</c:forEach>
				<!-- } 이 달의 날짜 -->
			</div>
		</div>
	</div>
</section>
