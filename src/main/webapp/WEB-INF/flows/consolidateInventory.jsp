<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consolidate Inventory</title>
</head>
<body>
<sf:form method="post" modelAttribute="inventoryActiveList">
	<table>
		<tr>
			<th>Item Number</th>
			<th>Name</th>
			<th>Quantity</th>
			<th>Unit</th>
			<th>stockDate</th>
    		<th>roastDate</th>
    		<th>expDate</th>
    		<th>comment</th>
		</tr>
		<c:forEach items="${inventoryActiveList.inventoryList}" var="inventoryList" varStatus="status">
			<tr>
				<td><c:out value="${inventoryList.itemNumber}" /></td>
				<td><c:out value="${inventoryList.name}" /></td>
				<td><sf:input path="inventoryList[${status.index}].quantity"/></td>
				<td><c:out value="${inventoryList.unit}" /></td>
				<td><c:out value="${inventoryList.stockDate}" /></td>
				<td><c:out value="${inventoryList.roastDate}" /></td>
				<td><c:out value="${inventoryList.expDate}" /></td>
				<td><c:out value="${inventoryList.comment}" /></td>
				
			</tr>
		</c:forEach>
	</table>
	<input type="submit"  name="_eventId_consolidate" value="Consolidate" />
	<input type="submit"  name="_eventId_consolidateAndTran" value="Consolidate And View Transactions" />
	<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</sf:form>
</body>
</html>