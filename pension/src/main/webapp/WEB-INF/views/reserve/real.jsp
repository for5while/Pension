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
						<a onclick="">
							<span class="material-icons margin-right border">keyboard_arrow_left</span>
						</a>
					</span>
					<span class="month">2020-07</span>
					<span class="next">
						<a onclick="">
							<span class="material-icons margin-left border">keyboard_arrow_right</span>
						</a>
					</span>
				</span>
				<span class="confirm">
					<a href="#"><span class="material-icons left margin-right">alarm</span>예약확인</a>
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
				<div class="wrap">
					<div class="row">
						<span>1</span>
						<span>준성수기</span>
					</div>
					<ul>
						<li>201 파티룸</li>
						<li>202 디럭스풀</li>
						<li>301 디럭스풀</li>
						<li>302 디럭스풀</li>
						<li>303 디럭스풀</li>
						<li>401 스위트풀</li>
						<li>402 스위트풀</li>
						<li>501 스위트풀</li>
						<li>502 스위트풀</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</section>
