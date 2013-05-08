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
	<sf:form method="post" modelAttribute="ingredientCodeRecipeList">
		<table>
			<tr>
				<th><input type="checkbox"></th>
				<th>Ingredient Code</th>
				<th>Brand</th>
				<th>Name</th>
				<th>Type</th>
			</tr>
			<c:forEach items="${ingredientCodeRecipeList.ingredientCodeRecipeList}" var="ingredientCodeRecipeList" varStatus="status">
				<tr>
					<td>
						<sf:checkbox path="ingredientCodeRecipeList[${status.index}].selected" />
					</td>
					<td><c:out value="${ingredientCodeRecipeList.code}" /></td>
					<td><c:out value="${ingredientCodeRecipeList.brand}" /></td>
					<td><c:out value="${ingredientCodeRecipeList.name}" /></td>
					<td><c:out value="${ingredientCodeRecipeList.type}" /></td>
				</tr>
			</c:forEach>
			
		</table>
		<input type="submit"  name="_eventId_submitIngredients" value="Accept" />
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="submit" name="_eventId_cancel" value="Cancel"/>
	</sf:form>
	
</body>
</html>