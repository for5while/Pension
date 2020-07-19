<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="mini-background eighth">
	<div>실시간 예약</div>
</div>

<section>
	<div class="wrap">
		<div class="write">
			<form action="<c:url value='../reserve/write' />" method="post">
				<div>
					<div class="subject">기간 선택</div>
					<div class="content">
						<div class="check">
							<span>CHECK IN</span>
							<span>2020.07.19</span>
						</div>
						<div class="wave">~</div>
						<div class="check">
							<span>CHECK OUT</span>
							<span>2020.07.25</span>
						</div>
						<select class="stay_date" name="stay_date">
							<option value="0">머무실 기간을 선택하세요.</option>
							<option value="1">1박</option>
							<option value="2">2박</option>
							<option value="3">3박</option>
						</select>
					</div>
				</div>
				<div>
					<div class="subject">인원</div>
					<div class="content">
						<div class="people">
							<span class="label">성인</span>
							<select name="adult">
								<option value="0">선택</option>
								<option value="1">1명</option>
								<option value="2">2명</option>
							</select>
						</div>
						<div class="people">
							<span class="label">아동</span>
							<select name="child">
								<option value="0">선택</option>
								<option value="1">1명</option>
								<option value="2">2명</option>
							</select>
						</div>
						<div class="people">
							<span class="label">유아</span>
							<select name="infant">
								<option value="0">선택</option>
								<option value="1">1명</option>
								<option value="2">2명</option>
							</select>
						</div>
					</div>
				</div>
				<div>
					<div class="subject">옵션 선택</div>
					<div class="content">
						<ul>
							<li>
								<input type="checkbox" id="opt1" name="option" value="1">
								<label for="opt1">옵션 일</label>
								<select name="opt1_amount">
									<option value="0">선택</option>
									<option value="1">1 SET</option>
									<option value="2">2 SET</option>
								</select>
							</li>
							<li>
								<input type="checkbox" id="opt2" name="option" value="2">
								<label for="opt2">옵션 이</label>
								<select name="opt2_amount">
									<option value="0">선택</option>
									<option value="1">1 SET</option>
									<option value="2">2 SET</option>
								</select>
							</li>
						</ul>
					</div>
				</div>
				<input type="hidden" name="${ _csrf.parameterName }" value="${ _csrf.token }">
				<input type="submit" class="btn_next" value="다음">
			</form>
		</div>
	</div>
</section>
