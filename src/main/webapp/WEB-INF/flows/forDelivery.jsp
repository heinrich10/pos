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
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
$(function() {
  $( ".date" ).datepicker({
	  dateFormat: "yy-mm-dd"  
  });
  
});
</script>
</head>
<body>
<sf:form method="post" modelAttribute="inventoryActiveList" >
			<table>
				<tr>
					<th>Item Number</th>
					<th>Name</th>
					<th>Quantity</th>
					<th>Unit</th>
					<th>Roast Date</th>
					<th>Exp Date</th>
					<th>Comment</th>
				</tr>
				<c:forEach items="${inventoryActiveList.inventoryList}" var="inventoryList" varStatus="status">
					<tr>
						<td><c:out value="${inventoryList.itemNumber}" /></td>
						<td><c:out value="${inventoryList.name}" /></td>
						<td><c:out value="${inventoryList.quantity}" /></td>
						<td><c:out value="${inventoryList.unit}" /></td>
						<td><sf:input path="inventoryList[${status.index}].roastDate" class="date"/></td>
						<td><sf:input path="inventoryList[${status.index}].expDate" class="date" /></td>
						<td><sf:input path="inventoryList[${status.index}].comment" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" name="_eventId_delivered" value="Accept" />
			<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
			<input type="submit" name="_eventId_cancel" value="Cancel"/>		
		</sf:form>
</body>
</html>