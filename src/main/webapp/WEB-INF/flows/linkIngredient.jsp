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
<sf:form method="post" commandName="ingredientLink">
<div id="left">
	<h2>Choose Inventory One</h2>
	
		<table>
			<tr>
				<th><input type="checkbox"></th>
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
				<c:if test="${status.index == 0}">
					<tr>
						<td>
							<sf:radiobutton path="link1" value="0"/>
						</td>
						<td><c:out value="-- none --" /></td>
					</tr>
				</c:if>
				<tr>
					<td>
						<sf:radiobutton path="link1" value="${inventoryList.itemNumber}"/>
					</td>
					<td><c:out value="${inventoryList.itemNumber}" /></td>
					<td><c:out value="${inventoryList.name}" /></td>
					<td><c:out value="${inventoryList.quantity}" /></td>
					<td><c:out value="${inventoryList.unit}" /></td>
					<td><c:out value="${inventoryList.stockDate}" /></td>
					<td><c:out value="${inventoryList.roastDate}" /></td>
					<td><c:out value="${inventoryList.expDate}" /></td>
					<td><c:out value="${inventoryList.comment}" /></td>
				</tr>
			</c:forEach>
		</table>
</div>

<div id="right">
	<h2>Choose Inventory Two</h2>
	
		<table>
			<tr>
				<th><input type="checkbox"></th>
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
				<c:if test="${status.index == 0}">
					<tr>
						<td>
							<sf:radiobutton path="link2" value="0"/>
						</td>
						<td><c:out value="-- none --" /></td>
					</tr>
				</c:if>
				<tr>
					<td>
						<sf:radiobutton path="link2" value="${inventoryList.itemNumber}" />
					</td>
					<td><c:out value="${inventoryList.itemNumber}" /></td>
					<td><c:out value="${inventoryList.name}" /></td>
					<td><c:out value="${inventoryList.quantity}" /></td>
					<td><c:out value="${inventoryList.unit}" /></td>
					<td><c:out value="${inventoryList.stockDate}" /></td>
					<td><c:out value="${inventoryList.roastDate}" /></td>
					<td><c:out value="${inventoryList.expDate}" /></td>
					<td><c:out value="${inventoryList.comment}" /></td>
				</tr>
			</c:forEach>
		</table>
</div>

		<input type="submit"  name="_eventId_save" value="Accept" />
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="submit" name="_eventId_cancel" value="Cancel"/>
</sf:form>
	
</body>
</html>