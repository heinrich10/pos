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
<c:choose>
	<c:when test="${editType == 'inventory'}">
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
	</c:when>
	
	
	
	<c:when test="${editType == 'unit'}">
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
	</c:when>
	
	<c:when test="${editType == 'menuItem'}">
		<sf:form method="post" commandName="menuItem" >
			<table>
				<tr>
			        <td>Recipe Code:</td>
			        <td>${menuItem.code}</td>
			    </tr>
			    <tr>
			        <td>Type:</td>
			        <td>
			        	<sf:select path="typeCode" >
			        		<sf:options items="${menuItemType}" itemLabel="name" itemValue="code"/>
			        	</sf:select>
			        </td>
			    </tr>
			    <tr>
			        <td>Name:</td>
			        <td><sf:input path="name" /></td>
			    </tr>
			    <tr>
			        <td>Description:</td>
			        <td><sf:input path="description" /></td>
			    </tr>
			    <tr>
			        <td>Price:</td>
			        <td><sf:input path="price" /></td>
			    </tr>
			    <tr>
			        <td colspan="3">
			            <input type="submit" value="Accept" />
			        </td>
			    </tr>
			</table>
		</sf:form>
	</c:when>
	
	<c:when test="${editType == 'miType'}">
		<sf:form method="post" commandName="menuItemType" >
			<table>
				<c:choose>
					<c:when test="${menuItemType.code == null}">
						<tr>
			        		<td>Code:</td>
			        		<td><sf:input path="code" /></td>
			    		</tr>
					</c:when>
					<c:otherwise>
						<tr>
			        		<td>Code:</td>
			        		<td>${menuItemType.code}</td>
			    		</tr>
					</c:otherwise>
				</c:choose>
			    <tr>
			        <td>Name:</td>
			        <td><sf:input path="name" /></td>
			    </tr>
			    <tr>
			        <td colspan="3">
			            <input type="submit" value="Accept" />
			        </td>
			    </tr>
			</table>
		</sf:form>
	</c:when>
	
	<c:when test="${editType == 'ingredient'}">
		<sf:form method="post" commandName="ingredientCode">
			<table>
				<tr>
			        <td>Ingredient Code:</td>
			        <td><sf:input path="code" /></td>
			    </tr>
			    <tr>
			        <td>Brand:</td>
			        <td><sf:input path="brand" /></td>
			    </tr>
			    <tr>
			        <td>Name:</td>
			        <td><sf:input path="name" /></td>
			    </tr>
			    <tr>
			        <td>Type:</td>
			        <td>
			        	<sf:select path="typeCode" >
			        		<sf:options items="${ingredientType}" itemLabel="name" itemValue="code"/>
			        	</sf:select>
			        </td>
			    <tr>
			        <td colspan="3">
			            <input type="submit" value="Accept" />
			        </td>
			    </tr>
			    </tr>
			</table>
		</sf:form>
	</c:when>
	
	<c:when test="${editType == 'ingredientType'}">
		<sf:form method="post" commandName="ingredientType" >
			<table>
				<tr>
			        <td>Code:</td>
			        <td><sf:input path="code" /></td>
			    </tr>
				<tr>
			        <td>Name:</td>
			        <td><sf:input path="name" /></td>
			    </tr>
			    <tr>
			        <td colspan="3">
			            <input type="submit" value="Accept" />
			        </td>
			    </tr>
			</table>
		</sf:form>
	</c:when>
	
</c:choose>
	
</body>
</html>