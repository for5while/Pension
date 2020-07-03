<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<nav id="gnb">
		<ul>
			<li class="logo"><a href="${pageContext.request.contextPath}"><img src="<c:url value='/resources/img/logo.png' />"></a></li>
			<li class="menu"><a href="${pageContext.request.contextPath}/welcome/navigation"><span>WELCOME</span></a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/welcome/navigation">오시는 길</a></li>
					<li><a href="${pageContext.request.contextPath}/welcome/surroundings">주변 여행지</a></li>
				</ul>
			</li>
			<li class="menu"><a href="${pageContext.request.contextPath}/room/sweet401"><span>ROOM</span></a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/room/sweet401">스위트풀 401</a></li>
					<li><a href="${pageContext.request.contextPath}/room/sweet402">스위트풀 402</a></li>
					<li><a href="${pageContext.request.contextPath}/room/deluxe301">디럭스풀 301</a></li>
					<li><a href="${pageContext.request.contextPath}/room/deluxe302">디럭스풀 302</a></li>
					<li><a href="${pageContext.request.contextPath}/room/party201">파티룸 201</a></li>
				</ul>
			</li>
			<li class="menu"><a href="${pageContext.request.contextPath}/special/panorama"><span>SPECIAL</span></a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/special/panorama">펜션 전경</a></li>
					<li><a href="${pageContext.request.contextPath}/special/pool">수영장</a></li>
					<li><a href="${pageContext.request.contextPath}/special/bbq">바비큐장</a></li>
					<li><a href="${pageContext.request.contextPath}/special/spa">스파</a></li>
				</ul>
			</li>
			<li class="menu"><a href="${pageContext.request.contextPath}/reserve/guide"><span>RESERVATION</span></a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/reserve/guide">예약 안내</a></li>
					<li><a href="${pageContext.request.contextPath}/reserve/real">실시간 예약</a></li>
					<li><a href="${pageContext.request.contextPath}/reserve/confirm">예약 확인</a></li>
				</ul>
			</li>
			<li class="menu"><a href="${pageContext.request.contextPath}/community/notice"><span>COMMUNITY</span></a>
				<ul>
					<li><a href="${pageContext.request.contextPath}/community/notice">공지사항</a></li>
					<li><a href="${pageContext.request.contextPath}/community/qna">문의하기</a></li>
					<li><a href="${pageContext.request.contextPath}/community/review">숙박후기</a></li>
				</ul>
			</li>
		</ul>
	</nav>
	
	<script type="text/javascript">
	$(document).ready(function(){
		gnb();
	});
	
	function gnb() {
		var depth1, depth2, aniTime=200;
	
		$('#gnb').on('mouseover', function() {
			$(this).addClass('active').stop().animate({
				height: 280 + 'px'
			}, aniTime, 'easeOutCubic');
		}).on('mouseleave', function() {
			$(this).removeClass('active').stop().animate({
				height: 90 + 'px'
			}, aniTime, 'easeOutCubic');
		});
	
		$('#gnb>ul li').on('mouseover', function() {
			$('#gnb ul li').removeClass('active');
			$(this).addClass('active');
		}).on('mouseleave', function() {
			$('#gnb ul li').removeClass('active');
			gnbReset();
		});
		
		function gnbNumCheck() {
			$('#gnb > ul > li').each(function() {
				if ($(this).hasClass('active')) {
					depth1 = $(this).index();
					
					$(this).find('li').each(function() {
						if($(this).hasClass('active')) {
							depth2 = $(this).index();
						}
					});
				}
			});
		}
		
		function gnbReset() {
			$('#gnb > ul > li').eq(depth1).addClass('active');
			$('#gnb > ul > li li').eq(depth2).addClass('active');
		}
		
		gnbNumCheck();
	}
	</script>
</header>
