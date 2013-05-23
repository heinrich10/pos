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
	<h1> Accounting </h1>
</header>
<%@ include file="/resources/navbar.jsp" %>
<nav id="nav2">
	<ul>
		<li><a href="transaction"> Transactions </a></li>
		<li><a href="eod"> End of Day </a></li>
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
							<th>Tran #</th>
							<th>Dine in</th>
							<th>Amount</th>
							<th>Time Stamp</th>
							<th>Items Ordered</th>
							<th>Price</th>
						</tr>
						<c:forEach items="${tran}" var="tran">
							<tr>
								<td><c:out value="${tran.codeTransaction}" /></td>
								<td><c:out value="${tran.indDineIn}" /></td>
								<td><c:out value="${tran.totalAmount}" /></td>
								<td><c:out value="${tran.timeStamp }"/></td>
								<c:forEach items="${tran.orderList.tranOrderList}" var="orderList" varStatus="status">
									<c:choose>
										<c:when test="${status.index > 0}">
											<tr>
												<td></td>
												<td></td>
												<td></td>
												<td></td>
												<td><c:out value="${orderList.menuItemName}"/></td>
												<td><c:out value="${orderList.menuItemPrice}"/></td>
												<td></td>
											</tr>
										</c:when>
										<c:otherwise>
											<td><c:out value="${orderList.menuItemName}"/></td>
											<td><c:out value="${orderList.menuItemPrice}"/></td>
										</c:otherwise>
									</c:choose>
									
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
	
	<c:otherwise>
		<article>
			<h2>Please choose action</h2>
		</article>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="transaction">Transactions</a></li>
				<li><a href="eod">End of Day</a></li>
			</ul>
		</aside>
	</c:otherwise>


</c:choose>


<%@ include file="/resources/footer.html" %>
</body>
</html>