<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mini-background eighth">
	<div>실시간 예약</div>
</div>

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
							<span class="info">401 스위트풀</span>
						</div>
						<div>
							<span class="title">날짜</span>
							<span class="info">2020.07.19 ~ 2020.07.25</span>
						</div>
						<div>
							<span class="title">숙박인원</span>
							<span class="info">성인 = 2명, 아동 = 없음, 유아 = 없음</span>
						</div>
						<div>
							<span class="title">옵션</span>
							<span class="info option">
								<span>아웃도어 바베큐 가스그릴 (4인기준) [1set], 이런저런 옵션 [3set]</span>
							</span>
						</div>
						<div>
							<span class="title">가격</span>
							<span class="info">객실금액 = 350,000원 + 옵션추가금액 = 0원 :: 합계 = 350,000원</span>
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
							<span class="info"><input type="text" name="name"></span>
						</div>
						<div>
							<span class="title">연락처</span>
							<span class="info"><input type="text" name="phone"></span>
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
								<select name="checkin">
									<option value="0">선택</option>
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
				<input type="submit" class="btn_next" value="완료">
			</form>
		</div>
	</div>
</section>
