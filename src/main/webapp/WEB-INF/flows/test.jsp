<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>TTest</h2>
	<sf:form method="post" modelAttribute="recipe">
		<table>
			<tr>
				<th>Ingredient Code</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Unit</th>
			</tr>
			<c:forEach items="${recipe.ingredientList}" var="ingredientList" varStatus="status">
				<tr>
					<td>
						<sf:input path="ingredientList[${status.index}].codeIngredient" />
					</td>
					<td>
						<sf:input path="ingredientList[${status.index}].name" />
					</td>
					<td>
						<sf:input path="ingredientList[${status.index}].quantity" />
					</td>
					<td>
						<sf:input path="ingredientList[${status.index}].unit" />
					</td>
		
				</tr>
			</c:forEach>
			
		</table>
		
		<input type="submit"  name="_eventId_submitIngredients" value="Accept" />
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
	</sf:form>
	
</body>
</html>