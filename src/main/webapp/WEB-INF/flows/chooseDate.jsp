<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Choose Date</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js"></script>
<script>
	$(function() {
		$( '.datepicker' ).datepicker({
			dateFormat: "yy-mm-dd"
		});
  	});
  </script>
</head>
<body>
<h2>Choose Date</h2>
	<form method="post">
		<table>
			<tr>
				<td>Start Date</td>
				<td><input type="text" class="datepicker" name="startDate" /></td>
			</tr>
			<tr>
				<td>End Date</td>
				<td><input type="text" class="datepicker" name="endDate" /></td>
			</tr>
		</table>
		<c:forEach items="${flowRequestContext.messageContext.allMessages}" var="message">
			<c:if test="${message.severity.toString() == 'ERROR'}">
				<div >
					${message.text }
				</div>
			</c:if>
		</c:forEach>
		
		<input type="submit"  name="_eventId_submitDate" value="Accept" />
		<c:if test="${subflow == true}">
			<input type="submit" name="_eventId_skip" value="Skip"/>
		</c:if>
		<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}"/>
		<input type="submit" name="_eventId_cancel" value="Cancel"/>
	</form>
</body>
</html>