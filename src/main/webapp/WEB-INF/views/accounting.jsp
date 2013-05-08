<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="<c:url value = "/resources/design.css"/>"/>
<title>Insert title here</title>
<base href="http://localhost:8080/inv/accounting/"/>
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
		<li><a href="transaction"> Transactions </a></li>
		<li><a href="edo"> End of Day </a></li>
	</ul>
</nav>
<c:choose>
	<c:when test="${tabletype == 'transaction'}">
		<section>
			<article>
				<a href="transaction"> Refresh </a>
				<h2>View Transaction</h2>
				<form>
					<table>
						<tr>
							<th>Transaction Number</th>
							<th>Dine in</th>
							<th>Amount</th>
							<th>Change</th>
							<th>Items</th>
							<th>Time</th>
						</tr>
						<c:forEach items="${tran}" var="tran">
							<tr>
								<td><c:out value="${tran.codeTransaction}" /></td>
								<td><c:out value="${tran.indDineIn}" /></td>
								<td><c:out value="${tran.recievedAmount}" /></td>
								<td><c:out value="${tran.Change}" /></td>
								<c:forEach items="${tran.orderList}" var="orderList">
									<tr><c:out value="${orderList.menuItemName}"/></tr>
								</c:forEach>
							</tr>
						</c:forEach>
					</table>
					<button type="submit" formaction="ingredient/add">Add</button>
					<input type="submit" formaction="ingredient/delete" formmethod="post" value="Delete"/>
				</form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="ingredient/type"> Ingredient Type </a></li>
			</ul>
		</aside>
	
	</c:when>


</c:choose>


<%@ include file="/resources/footer.html" %>
</body>
</html>