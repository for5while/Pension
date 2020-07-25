<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="administrator">
	<div class="account">
		<c:choose>
			<c:when test="${not empty accountInfo }">
				<table>
					<tr>
						<th>은행</th>
						<th>계좌번호</th>
						<th>예금주</th>
						<th>기능</th>
					</tr>
					<tr>
						<td>${accountInfo.bank }</td>
						<td>${accountInfo.accountNumber }</td>
						<td>${accountInfo.holder }</td>
						<td><a href="<c:url value='/administrator/accountDelete' />">삭제</a></td>
					</tr>
				</table>
			</c:when>
			<c:otherwise>
				<form action="<c:url value='/administrator/accountInsert' />" method="post">
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
					<table>
						<tr>
							<th>은행</th>
							<th>계좌번호</th>
							<th>예금주</th>
							<th>기능</th>
						</tr>
						<tr>
							<td><input type="text" name="bank" placeholder="은행명" required="required"></td>
							<td><input type="text" name="accountNumber" placeholder="계좌번호" required="required"></td>
							<td><input type="text" name="holder" placeholder="예금주" required="required"></td>
							<td><input type="submit" value="등록"></td>
						</tr>
					</table>
				</form>
			</c:otherwise>
		</c:choose>
		
		<div id="guide">
			<p class="word">반드시 읽어보세요.</p>
			<ul>
				<li>입금 계좌는 <span>총 1개만 등록</span>하실 수 있습니다.</li>
				<li>등록된 계좌 정보는 고객이 펜션 예약을 접수 완료하면 안내 페이지에서 출력됩니다.</li>
			</ul>
		</div>
	</div>
</div>
