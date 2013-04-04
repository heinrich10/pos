<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style type="text/css">
<%@
include file = "/WEB-INF/views/design.css" 
%>
</style>
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
</head>
<body>
	<div id="container">
		<div id="header">
			<h1>Inventory</h1>
		</div>
		<div id="navigation">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Inventory</a></li>
				<li><a href="#">Maintenance</a></li>
				<li><a href="#">Accounting</a></li>
			</ul>
		</div>
		<div id="content-container">
			<div id="left">
				<h3>Options</h3>
				<a href="pending"> View Orders </a>
				<button> test </button>
			</div>

			<div id="content">
				<a href="url">Refresh</a>
				<h2>Inventory</h2>
				<table id="inventory" border="1">
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
							<td><c:out value="${prod.date}" /></td>
							<td><c:out value="${prod.roastDate}" /></td>
							<td><c:out value="${prod.expDate}" /></td>
							<td><c:out value="${prod.comment}" /></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<div id="footer">
			Copyright © Site name, 20XX
		</div>
	</div>
</body>
</html>