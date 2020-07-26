<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div id="administrator">
	<div class="rooms">
		<form action="<c:url value='/administrator/roomInsert' />" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<table style="margin-bottom:15px">
				<tr>
					<th>호실명</th>
					<th>기본요금</th>
					<th>금요일 추가금</th>
					<th>토요일 추가금</th>
					<th>준성수기 추가금</th>
					<th>성수기 추가금</th>
					<th>성인 허용수</th>
					<th>아동 허용수</th>
					<th>유아 허용수</th>
					<th>최대 숙박 기간</th>
					<th>기능</th>
				</tr>
				<tr>
					<td><input type="text" name="roomName" required="required"></td>
					<td><input type="text" name="roomPrice" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomFriPrice" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomSatPrice" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomMidPrice" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomBusiestPrice" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomAdult" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomChild" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomInfant" placeholder="숫자 입력" required="required"></td>
					<td><input type="text" name="roomNight" placeholder="숫자 입력" required="required"></td>
					<td><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
				
		<c:choose>
			<c:when test="${not empty roomsList }">
				<table style="margin-bottom:50px">
					<tr>
						<th>호실명</th>
						<th>기본요금</th>
						<th>금요일 추가금</th>
						<th>토요일 추가금</th>
						<th>준성수기 추가금</th>
						<th>성수기 추가금</th>
						<th>성인 허용수</th>
						<th>아동 허용수</th>
						<th>유아 허용수</th>
						<th>최대 숙박 기간</th>
						<th>기능</th>
					</tr>
					<c:forEach var="rooms" items="${roomsList }">
						<fmt:formatNumber var="roomPrice" value="${rooms.roomPrice }" currencyCode="kor" currencySymbol="" />
						<fmt:formatNumber var="roomFriPrice" value="${rooms.roomFriPrice }" currencyCode="kor" currencySymbol="" />
						<fmt:formatNumber var="roomSatPrice" value="${rooms.roomSatPrice }" currencyCode="kor" currencySymbol="" />
						<fmt:formatNumber var="roomMidPrice" value="${rooms.roomMidPrice }" currencyCode="kor" currencySymbol="" />
						<fmt:formatNumber var="roomBusiestPrice" value="${rooms.roomBusiestPrice }" currencyCode="kor" currencySymbol="" />
					
						<tr>
							<td>${rooms.roomName }</td>
							<td>${roomPrice }원</td>
							<td>${roomFriPrice }원</td>
							<td>${roomSatPrice }원</td>
							<td>${roomMidPrice }원</td>
							<td>${roomBusiestPrice }원</td>
							<td>${rooms.roomAdult }명</td>
							<td>${rooms.roomChild }명</td>
							<td>${rooms.roomInfant }명</td>
							<td>${rooms.roomNight }박${rooms.roomNight + 1 }일</td>
							<td><a class="btn_confirm" href="<c:url value='/administrator/roomDelete?roomNo=${rooms.roomNo }' />">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>등록된 호실이 없습니다.</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
		
		<c:if test="${not empty roomsList }">
			<form action="<c:url value='/administrator/roomOptionInsert' />" method="post">
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				<table style="margin-bottom:15px">
					<tr>
						<th>호실명</th>
						<th>옵션명</th>
						<th>가격</th>
						<th>기능</th>
					</tr>
					<tr>
						<td>
							<select name="roomNo" style="width:100%" required="required">
								<option value="">선택</option>
								<c:forEach var="rooms" items="${roomsList }">
									<option value="${rooms.roomNo }">${rooms.roomName }</option>
								</c:forEach>
							</select>
						</td>
						<td><input type="text" name="roomOptionName" style="width:100%" required="required"></td>
						<td><input type="text" name="roomOptionPrice" style="width:100%" placeholder="숫자 입력" required="required"></td>
						<td><input type="submit" value="등록"></td>
					</tr>
				</table>
			</form>
			
			<c:choose>
				<c:when test="${not empty roomsOptionList }">
					<table>
						<tr>
							<th>번호</th>
							<th>호실명</th>
							<th>옵션명</th>
							<th>가격</th>
							<th>기능</th>
						</tr>
						<c:forEach var="roomsOption" items="${roomsOptionList }">
							<fmt:formatNumber var="roomOptionPrice" value="${roomsOption.roomOptionPrice }" currencyCode="kor" currencySymbol="" />
						
							<tr>
								<td>${roomsOption.roomOptionNo }</td>
								<td>${roomsOption.roomName }</td>
								<td>${roomsOption.roomOptionName }</td>
								<td>${roomOptionPrice }원</td>
								<td><a class="btn_confirm" href="<c:url value='/administrator/roomOptionDelete?roomOptionNo=${roomsOption.roomOptionNo }' />">삭제</a></td>
							</tr>
						</c:forEach>
					</table>
				</c:when>
				<c:otherwise>
					<table>
						<tr>
							<td>등록된 호실 옵션이 없습니다.</td>
						</tr>
					</table>
				</c:otherwise>
			</c:choose>
		</c:if>
		
		<div id="guide">
			<p class="word">반드시 읽어보세요.</p>
			<ul>
				<li>호실 요금은 기본 금액에 주말, 시즌 금액이 추가로 합산됩니다.</li>
				<li>방 옵션 등록 시 호실명을 정확히 확인해주세요.</li>
			</ul>
		</div>
	</div>
</div>
