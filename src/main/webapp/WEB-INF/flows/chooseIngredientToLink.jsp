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
<h2>Choose Ingredients</h2>
	<form method="post">
		<table>
			<tr>
				<th><input type="checkbox"></th>
				<th>Ingredient Code</th>
				<th>Brand</th>
				<th>Name</th>
				<th>Type</th>
			</tr>
			<c:forEach items="${ingredientCodeList.ingredientCodeList}" var="ingredientCodeList" varStatus="status">
				<tr>
					<td>
						<input type="radio" name="code" value="${ingredientCodeList.code}" />
					</td>
					<td><c:out value="${ingredientCodeList.code}" /></td>
					<td><c:out value="${ingredientCodeList.brand}" /></td>
					<td><c:out value="${ingredientCodeList.name}" /></td>
					<td><c:out value="${ingredientCodeList.type}" /></td>
				</tr>
			</c:forEach>
			
		</table>
		<input type="submit"  name="_eventId_linkIngredient" value="Accept" />
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="submit" name="_eventId_cancel" value="Cancel"/>
	</form>
	
</body>
</html>