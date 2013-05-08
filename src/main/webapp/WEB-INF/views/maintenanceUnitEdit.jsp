<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Unit</title>
</head>
<body>
<sf:form method="post" commandName="unitAndPostUnit" >
<c:choose>
	<c:when test="${unitAndPostUnit.codeUnit != null}">
		<table>
			<tr>
		        <td>Unit Code:</td>
		        <td>${unitAndPostUnit.codeUnit}</td>
		    </tr>
		    <tr>
		        <td>Name:</td>
		        <td><sf:input path="name" /></td>
		    </tr>
		    <tr>
		        <td>Post Unit:</td>
		        <td>
		        	<sf:select path="codePostUnit" >
		        		<sf:options items="${unit}" itemLabel="name" itemValue="codeUnit"/>
		        	</sf:select>
		        </td>
		    </tr>
		    <tr>
		        <td>Conversion Factor:</td>
		        <td><sf:input path="conversionFactor" /></td>
		    </tr>
		    <tr>
		        <td colspan="3">
		            <input type="submit" value="Accept" />
		        </td>
		    </tr>
		</table>
	</c:when>
	
	<c:otherwise>
		<table>
			<tr>
		        <td>Unit Code:</td>
		        <td><sf:input path="codeUnit" /></td>
		    </tr>
		    <tr>
		        <td>Name:</td>
		        <td><sf:input path="name" /></td>
		    </tr>
		    <tr>
		        <td>Post Unit:</td>
		        <td>
		        	<sf:select path="codePostUnit" >
		        		<sf:options items="${unit}" itemLabel="name" itemValue="codeUnit"/>
		        	</sf:select>
		        </td>
		    </tr>
		    <tr>
		        <td>Conversion Factor:</td>
		        <td><sf:input path="conversionFactor" /></td>
		    </tr>
		    <tr>
		        <td colspan="3">
		            <input type="submit" value="Accept" />
		        </td>
		    </tr>
		</table>
	</c:otherwise>
</c:choose>
</sf:form>
</body>
</html>