<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<div class="account">
		<form action="<c:url value='/administrator/seasonInsert' />" method="post">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<table>
				<tr>
					<th>준성수기</th>
					<th>성수기</th>
					<th>기능</th>
				</tr>
				<tr>
					<td>
						<input type="text" name="midYear" placeholder="년도">
						<input type="text" name="midMonth" placeholder="월">
						<input type="text" name="midDay" placeholder="일">
					</td>
					<td>
						<input type="text" name="busiestYear" placeholder="년도">
						<input type="text" name="busiestMonth" placeholder="월">
						<input type="text" name="busiestDay" placeholder="일">
					</td>
					<td><input type="submit" value="등록"></td>
				</tr>
			</table>
		</form>
		
		<c:if test="${not empty seasonList }">
			<table>
				<tr>
					<th>준성수기</th>
					<th>성수기</th>
					<th>기능</th>
				</tr>
				<c:forEach var="season" items="${seasonList }">
					<tr>
						<td>${season.midDate }</td>
						<td>${season.busiestDate }</td>
						<td><a href="<c:url value='/administrator/seasonDelete?seasonNo=${season.seasonNo }' />">삭제</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
		
		<div id="guide">
			<p class="word">반드시 읽어보세요.</p>
			<ul>
				<li>준성수기 시즌과 성수기 시즌의 기간을 함께 입력하여 등록하는 것 보다 따로 등록하시는 것이 관리에 용이합니다.</li>
			</ul>
		</div>
	</div>
