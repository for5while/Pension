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
	</div>
</div>
