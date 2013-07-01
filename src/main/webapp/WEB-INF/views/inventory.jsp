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
<title>Active Inventory</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js">
</script>
<script>
$(document).ready(function(){
	$("button").click(function(){
    	$.getJSON("pending",function(data){
    		var newRows = "";
    		$("#inventory tr:first").siblings().remove();
    		for (var i = 0; i < data.length; i++) {
    		   newRows += "<tr>" +
    		   			"<td>" + data[i].itemNumber + "</td>" +
    		   			"<td>" + data[i].name + "</td>"+
    		   			"<td>" + data[i].quantity + "</td>"+
    		   			"<td>" + data[i].unit + "</td>"+
    		   			"<td>" + data[i].date + "</td>"+
    		   			"<td>" + data[i].roastDate + "</td>"+
    		   			"<td>" + data[i].expDate + "</td>"+
    		   			"<td>" + data[i].comments + "</td>"+
    		   			"</tr>";
    		}
    		$("#inventory").append(newRows);
    		
      		
    	});
  	});
});
</script>
<base href="http://localhost:8080/erp/inventory/"/>
</head>
<body>
<div id="icon">
	<img src="<c:url value = "/resources/magnum_opus_logo.jpg"/>" width="200" height="200"
    alt="Logo Here" />
</div>
<header>
	<h1>Inventory</h1>
</header>

<%@ include file="/resources/navbar.jsp" %>
<nav id="nav2">
	<ul>
		<li><a href="active">Active</a></li>
		<li><a href="pending">Pending</a></li>
		<li><a href="hist">History</a></li>
	</ul>
</nav>
<c:choose>
	<c:when test = "${model.tabletype == 'active'}">
		<article>
			<a href="active">Refresh</a>
			<h2>Inventory</h2>
			<form id="select" action="test" method="post">
			<table>
				<tr>
					<th>Item Number</th>
					<th>Name</th>
					<th>Quantity</th>
					<th>Unit</th>
					<th>Stock Date</th>
					<th>Roast Date</th>
					<th>Exp Date</th>
					<th>Comments</th>
				</tr>
				<c:forEach items="${model.inventory}" var="prod">
					<tr>
						<td><c:out value="${prod.itemNumber}" /></td>
						<td><c:out value="${prod.name}" /></td>
						<td><c:out value="${prod.quantity}" /></td>
						<td><c:out value="${prod.unit}" /></td>
						<td><c:out value="${prod.stockDate}" /></td>
						<td><c:out value="${prod.roastDate}" /></td>
						<td><c:out value="${prod.expDate}" /></td>
						<td><c:out value="${prod.comment}" /></td>
					</tr>
				</c:forEach>
			</table>	
			</form>
		</article>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="pending"> View Orders </a></li>
			</ul>
		</aside>				
	</c:when>
		
	<c:when test = "${model.tabletype == 'pending'}">
		<article>
			<a href="pending">Refresh</a>
			<h2>Orders</h2>
			<form id="select" method="post">
				<table>
					<tr>
						<th> </th>
						<th>Item Number</th>
						<th>Name</th>
						<th>Quantity</th>
						<th>Unit</th>
						<th>Order Date</th>
					</tr>
					<c:forEach items="${model.inventory}" var="prod">
						<tr>
							<td>
								<input type = "checkbox" name = "itemNumber" value = "${prod.itemNumber}" />
							</td>
							<td><c:out value="${prod.itemNumber}" /></td>
							<td><c:out value="${prod.name}" /></td>
							<td><c:out value="${prod.quantity}" /></td>
							<td><c:out value="${prod.unit}" /></td>
							<td><c:out value="${prod.orderDate}" /></td>
						</tr>
					</c:forEach>
				</table>
				<input type="submit" formaction="pending/delete" value="Delete"/>
			</form>
		</article>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="pending/add">Add</a></li>
				<li><a href="/erp/delivery-flow">Delivered</a></li>
			</ul>
		</aside>
	</c:when>
	
	<c:when test="${tabletype == 'deliver'}">
		<sf:form method="post" modelAttribute="inventory" >
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
				<c:forEach items="${inventory.inventoryList}" var="inventoryList" varStatus="status">
					<tr>
						<td><c:out value="${inventoryList.itemNumber}" /></td>
						<td><c:out value="${inventoryList.name}" /></td>
						<td><c:out value="${inventoryList.quantity}" /></td>
						<td><c:out value="${inventoryList.unit}" /></td>
						<td><sf:input path="inventoryList[${status.index}].roastDate" /></td>
						<td><sf:input path="inventoryList[${status.index}].expDate" /></td>
						<td><sf:input path="inventoryList[${status.index}].comment" /></td>
					</tr>
				</c:forEach>
			</table>
			<input type="submit" value="Accept" />
		</sf:form>
	</c:when>
	
	<c:when test="${tabletype == 'history'}">
		<article>	
			<a href="hist">Refresh</a>
			<h2>Order History</h2>
			<sf:form method="get" modelAttribute="monthYear">
				Month
				<sf:select path="month">
					<sf:options items="${month}"  />
				</sf:select>
				Year
				<sf:select path="year">
					<sf:options items="${year}"/>
				</sf:select>
				<input type="submit" value="Accept" />
			</sf:form>
			
			<table>
				<tr>
					<th>Item Number</th>
					<th>Name</th>
					<th>Quantity</th>
					<th>Unit</th>
					<th>Order Date</th>
					<th>Delivery Date</th>
				</tr>
				<c:forEach items="${inventory}" var="prod">
					<tr>
						<td><c:out value="${prod.itemNumber}" /></td>
						<td><c:out value="${prod.name}" /></td>
						<td><c:out value="${prod.quantity}" /></td>
						<td><c:out value="${prod.unit}" /></td>
						<td><c:out value="${prod.orderDate}" /></td>
						<td><c:out value="${prod.deliveryDate}" /></td>
					</tr>
				</c:forEach>
			</table>
		</article>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="active">Active</a></li>
				<li><a href="pending">Pending</a></li>
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
				<li><a href="active">Active</a></li>
				<li><a href="pending">Pending</a></li>
				<li><a href="hist">History</a></li>
			</ul>
		</aside>
	</c:otherwise>
</c:choose>
			
<%@ include file="/resources/footer.html" %>
</body>
</html>