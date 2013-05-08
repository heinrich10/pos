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
<h2>Menu Item Maintenance</h2>
				
<table>
	<tr>
		<th>Recipe Code</th>
		<th>Type</th>
		<th>Name</th>
		<th>Description</th>
		<th>Price</th>
		<th>Action</th>
	</tr>
	<c:forEach items="${menuItemList.menuItemList}" var="menuItemList" varStatus="status">
		<tr>
			<td>${menuItemList.code}</td>
			<td>${menuItemList.type}</td>
			<td>${menuItemList.name}</td>
			<td>${menuItemList.description}</td>
			<td>${menuItemList.price}</td>
			<td>
				<sf:form id="input">
					<input type="submit"  name="_eventId_submitMenuItem" value="Edit" />
					<input type="hidden" name="code" value="${menuItemList.code}"/>
					<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
					
				</sf:form>
			</td>
		</tr>
	</c:forEach>
</table>
<sf:form>
	<input type="submit" name="_eventId_cancel" value="Cancel"/>
</sf:form>
				
</body>
</html>