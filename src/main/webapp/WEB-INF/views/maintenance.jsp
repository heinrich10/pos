<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/design.css"/>"/>
<title>Insert title here</title>
</head>
<body>
<div id="icon">
	<img src="<c:url value = "/resources/magnum_opus_logo.jpg"/>" width="200" height="200"
    alt="Logo Here" />
</div>
<header>
	<h1> Maintenance </h1>
</header>
<%@ include file="/resources/navbar.jsp" %>
<nav id="nav2">
	<ul>
		<li><a href="ingredient"> Ingredient </a></li>
		<li><a href="mi"> Menu Item </a></li>
		<li><a href="unit"> Unit </a></li>
	</ul>
</nav>
<c:choose>
	<c:when test="${model.tabletype == 'ingredient'}">
		<section>
			<article>
				<a href="mi"> Refresh </a>
				<h2>Ingredient Maintenance</h2>
				<table>
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
							<td>
								<form id="deleteIngredient" action="ingredient/delete" method="post">
									<input id="code" name="code" type="hidden" value="${prod.code}"/>
									<input type="submit" value="Delete" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="ingredient/add"> Add </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${model.tabletype == 'menuItem'}">
		<section>
			<article>
				<a href="mi"> Refresh </a>
				<h2>Menu Item Maintenance</h2>
				<table>
					<tr>
						<th>Recipe Code</th>
						<th>Type</th>
						<th>Name</th>
						<th>Description</th>
						<th>Price</th>
					</tr>
					<c:forEach items="${model.object}" var="prod">
						<tr>
							<td><c:out value="${prod.code}" /></td>
							<td><c:out value="${prod.type}" /></td>
							<td><c:out value="${prod.name}" /></td>
							<td><c:out value="${prod.description}" /></td>
							<td><c:out value="${prod.price}" /></td>
							<td>
								<form id="editMI" action="mi/edit?menuItem=codet" method="get">
									<input id="code" name="code" type="hidden" value="${prod.code}"/>
									<input type="submit" value="Edit" />
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="mi/mitype"> Menu Item Type </a></li>
				<li><a href="recipe"> Recipe </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${model.tabletype == 'unit'}">
		<section>
			<article>
				<a href="unit"> Refresh </a>
				<h2>Unit Maintenance</h2>
				<table>
					<tr>
						<th>Unit Code</th>
						<th>Name</th>
						<th>Post Unit</th>
						<th>Conversion Factor</th>
					</tr>
					<c:forEach items="${model.object}" var="prod">
						<tr>
							<td><c:out value="${prod.codeUnit}" /></td>
							<td><c:out value="${prod.name}" /></td>
							<td><c:out value="${prod.namePostUnit}" /></td>
							<td><c:out value="${prod.conversionFactor}" /></td>
							<td>
								<form id="editUnit" action="unit/edit?codeUnit=codeUnit" method="get">
									<input id="codeUnit" name="codeUnit" type="hidden" value="${prod.codeUnit}"/>
									<input type="submit" value="Edit" />
								</form>
							</td>
							<td>
								<form id="deleteUnit" action="unit/delete" method="post">
									<input id="codeUnit" name="codeUnit" type="hidden" value="${prod.codeUnit}"/>
									<input type="submit" value="Delete" onClick="return confirm('Do you want to delete item number ${prod.name}?')"/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="unit/add"> Add </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${model.tabletype == 'mitype'}">
		<section>
			<article>
				<a href="unit"> Refresh </a>
				<h2>Menu Item Maintenance</h2>
				<table>
					<tr>
						<th>Code</th>
						<th>Name</th>
					</tr>
					<c:forEach items="${model.object}" var="prod">
						<tr>
							<td><c:out value="${prod.code}" /></td>
							<td><c:out value="${prod.name}" /></td>
							<td>
								<form id="editMenuItem" action="mitype/edit?code=code" method="get">
									<input id="code" name="code" type="hidden" value="${prod.code}"/>
									<input type="submit" value="Edit" />
								</form>
							</td>
							<td>
								<form id="deleteMenuItem" action="mitype/delete" method="post">
									<input id="code" name="code" type="hidden" value="${prod.code}"/>
									<input type="submit" value="Delete" onClick="return confirm('Do you want to delete item number ${prod.name}?')"/>
								</form>
							</td>
						</tr>
					</c:forEach>
				</table>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="mitype/add"> Add </a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:otherwise>
		<section>
			<article>
				<h2>Please choose action</h2>
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
	</c:otherwise>
</c:choose>

<%@ include file="/resources/footer.html" %>
</body>
</html>