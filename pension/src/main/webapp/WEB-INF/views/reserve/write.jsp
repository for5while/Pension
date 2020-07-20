<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mini-background eighth">
	<div>실시간 예약</div>
</div>

<section>
	<div class="wrap">
		<div class="write">
			<form action="<c:url value='../reserve/write2' />" method="get" name="wf" onsubmit="return write_submit();">
				<!-- 기간 선택 -->
				<div>
					<div class="subject">기간 선택</div>
					<div class="content">
						<div class="check">
							<span>CHECK IN</span>
							<span id="check_in">${year }.${month }.${day }</span>
						</div>
						<div class="wave">~</div>
						<div class="check">
							<span>CHECK OUT</span>
							<span id="check_out"></span>
						</div>
						
						<select class="stay_date" id="stay_date" name="stay_date" onchange="selectDate()">
							<option value="0">머무실 기간을 선택하세요.</option>
							<c:forEach var="night" begin="1" end="${roomInfos[0] }">
								<option value="${night }">${night }박</option>
							</c:forEach>
						</select>
					</div>
				</div>
				
				<!-- 인원 -->
				<div>
					<div class="subject">인원</div>
					<div class="content">
						<div class="people">
							<span class="label">성인</span>
							<select name="adult">
								<option value="-1">선택</option>
								<c:forEach var="people" begin="1" end="${roomInfos[1][0].peopleAdult }">
									<option value="${people }">${people }명</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="people">
							<span class="label">아동</span>
							<select name="child">
								<option value="-1">선택</option>
								<option value="0">없음</option>
								<c:forEach var="people" begin="1" end="${roomInfos[1][0].peopleChild }">
									<option value="${people }">${people }명</option>
								</c:forEach>
							</select>
						</div>
						
						<div class="people">
							<span class="label">유아</span>
							<select name="infant">
								<option value="-1">선택</option>
								<option value="0">없음</option>
								<c:forEach var="people" begin="1" end="${roomInfos[1][0].peopleInfant }">
									<option value="${people }">${people }명</option>
								</c:forEach>
							</select>
						</div>
					</div>
				</div>
				
				<!-- 옵션 선택 -->
				<div>
					<div class="subject">옵션 선택</div>
					<div class="content">
						<ul>
							<!-- 선택된 방에 존재하는 옵션 나열 -->
							<c:forEach var="option" items="${roomOptions }">
								<li>
									<input type="checkbox" id="option${option.optionIndex }" name="option" value="${option.optionIndex }">
									<label for="option${option.optionIndex }">${option.optionName }</label>
								</li>
							</c:forEach>
							<c:if test="${empty roomOptions }">
								<li>이 방에는 옵션이 존재하지 않습니다.</li>
							</c:if>
						</ul>
					</div>
				</div>
				
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
				<input type="hidden" name="room" value="${param.room }">
				<input type="hidden" name="year" value="${param.year }">
				<input type="hidden" name="month" value="${param.month }">
				<input type="hidden" name="day" value="${param.day }">
				<input type="hidden" name="lastDay" value="${param.lastDay }">
				<input type="hidden" id="checkOutDate" value="">
				
				<input type="submit" class="btn_next" value="다음">
			</form>
		</div>
	</div>
</section>

<script type="text/javascript">
function write_submit() {
	if(wf.stay_date.value == 0) {
		alert("머무실 기간을 선택해주세요.");
		return false;
	}
	else if(wf.adult.value == -1) {
		alert("성인 인원 수를 선택해주세요.");
		return false;
	}
	else if(wf.child.value == -1) {
		alert("아동 인원 수를 선택해주세요.");
		return false;
	}
	else if(wf.infant.value == -1) {
		alert("유아 인원 수를 선택해주세요.");
		return false;
	}
}

function selectDate() {
	var date = document.getElementById("stay_date");
	var dateValue = parseInt(date.options[date.selectedIndex].value); // x박
	
	var checkInDate = parseInt(${day });
	var checkOutDate = document.getElementById("check_out");
	
	var year = ${year };
	var month = ${month };
	var day = checkInDate + dateValue;
	var lastDay = ${lastDay };
	
	// 이 달의 마지막 날짜를 초과하는 경우
	if(day > lastDay) {
		month += 1;
		day = (checkInDate - lastDay) + dateValue; // 예약중인 날짜에서 마지막 날짜를 빼준 값에 x박을 더하기
	}
	
	checkOutDate.innerHTML = year + "." + month + "." + day;
	document.getElementById("checkOutDate").value = year + "-" + pad(month, 2) + "-" + pad(day, 2);
}

// 자릿수 맞추기
function pad(n, width) {
	n = n + '';
	return n.length >= width ? n : new Array(width - n.length + 1).join('0') + n;
}
</script>
