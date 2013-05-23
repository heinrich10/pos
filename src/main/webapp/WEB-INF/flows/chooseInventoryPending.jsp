<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post">
	<table>
		<tr>
			<th><input type="checkbox"/></th>
			<th>Item Number</th>
			<th>Name</th>
			<th>Quantity</th>
			<th>Unit</th>
			<th>Order Date</th>
		</tr>
		<c:forEach items="${inventoryPendingList.inventoryPendingList}" var="inventoryList" varStatus="status">
			<tr>
				<td><input type="checkbox" value="${inventoryList.itemNumber}" name="itemNumber"/>
				<td><c:out value="${inventoryList.itemNumber}" /></td>
				<td><c:out value="${inventoryList.name}" /></td>
				<td><c:out value="${inventoryList.quantity}" /></td>
				<td><c:out value="${inventoryList.unit}" /></td>
				<td><c:out value="${inventoryList.orderDate}" /></td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit"  name="_eventId_forDelivery" value="Accept" />
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</form>
</body>
</html>