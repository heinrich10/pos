<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
<%@
include file = "/WEB-INF/resources/design.css" 
%>
</style>
<title>Insert title here</title>
</head>
<body>
<header>
	<h1> Maintenance </h1>
</header>
<%@ include file="/WEB-INF/resources/navbar.jsp" %>
<section>
	<article>
		<table id="inventory" border="1">
			<c:choose>
				<c:when test="${model.tabletype == 'ingredient'}">
					<h2>Ingredient Maintenance</h2>
					<tr>
						<th>Ingredient Code</th>
						<th>Brand</th>
						<th>Name</th>
						<th>Type</th>
					</tr>
					<c:forEach items="${model.ingredient}" var="prod">
						<tr>
							<td><c:out value="${prod.code}" /></td>
							<td><c:out value="${prod.brand}" /></td>
							<td><c:out value="${prod.name}" /></td>
							<td><c:out value="${prod.type}" /></td>
						</tr>
					</c:forEach>
				</c:when>
				
				<c:when test="${model.tabletype == 'menuItem'}">
					<h2>Menu Item Maintenance</h2>
					<tr>
						<th>Recipe Code</th>
						<th>Type</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
					</tr>
				</c:when>
				
				<c:when test="${model.tabletype == 'unit'}">
					<h2>Unit Maintenance</h2>
					<tr>
						<th>Unit Code</th>
						<th>Name</th>
						<th>Post Unit</th>
						<th>Conversion Factor</th>
					</tr>
					
				</c:when>
				
				<c:otherwise>
					<h2>Please choose action</h2>
				</c:otherwise>
			</c:choose>
		
	</table>
	</article>
</section>

<aside>
	<h3>Options</h3>
	<ul>
		<li><a href="ingredient"> Ingredient </a></li>
		<li><a href="mi"> Menu Item </a></li>
		<li><a href="unit"> Unit </a></li>
	</ul>
	
</aside>	
<%@ include file="/WEB-INF/resources/footer.html" %>
</body>
</html>