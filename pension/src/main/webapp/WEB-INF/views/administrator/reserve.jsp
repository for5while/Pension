<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="administrator">
	<div class="reserve">
		<c:choose>
			<c:when test="${not empty reserveList }">
				<table>
					<tr>
						<th>번호</th>
						<th>호실</th>
						<th>체크인</th>
						<th>체크아웃</th>
						<th>성인</th>
						<th>아동</th>
						<th>유아</th>
						<th>옵션</th>
						<th>전달사항</th>
						<th>입금자명</th>
						<th>결제금액</th>
						<th>예약일시</th>
						<th>기능</th>
					</tr>
					<c:forEach var="reserve" items="${reserveList }">
						<tr>
							<fmt:formatNumber var="priceFormat" value="${reserve.price }" currencyCode="kor" currencySymbol="" />
							<td>${reserve.reserveNo }</td>
							<td>${reserve.roomName }</td>
							<td>${reserve.checkInDate } ${reserve.checkInTime }:00</td>
							<td>${reserve.checkOutDate }</td>
							<td>${reserve.adult }</td>
							<td>${reserve.child }</td>
							<td>${reserve.infant }</td>
							<td>${reserve.option }</td>
							<td>${reserve.message }</td>
							<td>${reserve.customerName }</td>
							<td>${priceFormat }원</td>
							<td>${reserve.paymentDatetime }</td>
							<td>
								<c:choose>
									<c:when test="${reserve.isPayment eq 1 }">
										예약완료
									</c:when>
									<c:otherwise>
										<a class="btn_confirm" href="<c:url value='/administrator/reserveComplete?reserveNo=${reserve.reserveNo }' />">결제확인</a>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>예약건이 없습니다.</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		
		<div id="guide">
			<p class="word">반드시 읽어보세요.</p>
			<ul>
				<li>무통장 입금으로 입금된 고객의 성함과 금액을 확인하시고 기능의 <span>결제확인</span> 버튼을 누르시면 예약이 성사됩니다.</li>
				<li>옵션과 전달사항을 꼼꼼히 확인해주세요.</li>
				<li>옵션 번호의 이름은 좌측 메뉴 [호실 관리]에서 확인하실 수 있습니다.</li>
			</ul>
		</div>
	</div>
</div>
