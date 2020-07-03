<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="mini-background first">
	<div>오시는 길</div>
</div>

<section>
	<div class="wrap">
		<div class="navigation">
			<!-- 지도 -->			
			<div id="map" style="width:1280px;height:500px"></div>
			<p>
				<span class="subject">* 내비게이션 검색</span>
				<span class="content">도로명 : 부산광역시 사상구 주례동 송정로 27-1</span>
			</p>
			<p>
				<span class="subject">* 지하철 이용</span>
				<span class="content">주례역 1번 출구 50m 도보 이동</span>
			</p>
			<p>
				<span class="subject">* 택시 이용</span>
				<span class="content">부산역(경부선) > 약 30분 소요 > 깊어지는 밤 펜션(택시비 약 21,000원)</span>
			</p>
		</div>
	</div>
	
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bb2e1c007e8c999068fd240cded26830"></script>
	<script type="text/javascript">
	var container = document.getElementById('map'); //지도를 담을 영역의 DOM 레퍼런스
	var options = { //지도를 생성할 때 필요한 기본 옵션
		center: new kakao.maps.LatLng(35.155447, 128.995727), //지도의 중심좌표.
		level: 3 //지도의 레벨(확대, 축소 정도)
	};
	
	var map = new kakao.maps.Map(container, options); //지도 생성 및 객체 리턴
	</script>
</section>