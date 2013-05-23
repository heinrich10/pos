<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Transactions</title>
</head>
<body>
<h2>View Transaction</h2>
	<p>Transaction from ${startDate} to ${endDate}</p>
	<table>
		<tr>
			<th>Time Stamp</th>
			<th>Tran #</th>
			<th>Dine in</th>
			<th>Amount</th>
			<th>Items Ordered</th>
			<th>Price</th>
		</tr>
		<c:forEach items="${tranList.tranList}" var="tran">
			<tr>
				<td><c:out value="${tran.timeStamp }"/></td>
				<td><c:out value="${tran.codeTransaction}" /></td>
				<td><c:out value="${tran.indDineIn}" /></td>
				<td><c:out value="${tran.totalAmount}" /></td>
				<c:forEach items="${tran.orderList.tranOrderList}" var="orderList" varStatus="status">
				<c:choose>
					<c:when test="${status.index > 0}">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
							<td><c:out value="${orderList.menuItemName}"/></td>
							<td><c:out value="${orderList.menuItemPrice}"/></td>
							<td></td>
						</tr>
					</c:when>
					<c:otherwise>
						<td><c:out value="${orderList.menuItemName}"/></td>
						<td><c:out value="${orderList.menuItemPrice}"/></td>
					</c:otherwise>
				</c:choose>
						
			</c:forEach>
						
		</tr>
	</c:forEach>
</table>
<form method="post">
	<input type="submit"  name="_eventId_printList" value="Print" />
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</form>
</body>
</html>

