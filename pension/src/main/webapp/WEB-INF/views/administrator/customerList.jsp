<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="administrator">
	<div class="customerList">
		<c:choose>
			<c:when test="${not empty customerList }">
				<table>
					<tr>
						<th>번호</th>
						<th>성명</th>
						<th>연락처</th>
					</tr>
					<c:forEach var="customer" items="${customerList }">
						<tr>
							<td>${customer.customerNo }</td>
							<td>${customer.customerName }</td>
							<td>${customer.customerPhone }</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<table>
					<tr>
						<td>고객이 없습니다.</td>
					</tr>
				</table>
			</c:otherwise>
		</c:choose>
	</div>
</div>
