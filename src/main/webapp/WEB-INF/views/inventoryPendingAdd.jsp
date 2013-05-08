<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Order</title>
</head>
<body>
<sf:form method="post" commandName="inventory" >
<table>
	<tr>
        <td>Name:</td>
        <td>
        	<sf:select path="codeIngredient" >
        		<sf:options items="${ingredientCode}" itemLabel="fullName" itemValue="code"/>
        	</sf:select>
        </td>
    </tr>
    <tr>
        <td>Quantity:</td>
        <td><sf:input path="quantity" /></td>
    </tr>
    <tr>
        <td>Unit:</td>
        <td>
        	<sf:select path="unitCode" >
        		<sf:options items="${unit}" itemLabel="name" itemValue="codeUnit"/>
        	</sf:select>
        </td>
    </tr>
    <tr>
        <td>Unit Price:</td>
        <td><sf:input path="unitPrice" /></td>
    </tr>
    <tr>
        <td colspan="3">
            <input type="submit" value="Accept" />
        </td>
    </tr>
</table>
</sf:form>
</body>
</html>