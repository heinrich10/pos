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
<title>Home</title>
<base href="http://localhost:8080/inv/"/>
</head>
<body>
<div id="icon">
	<img src="<c:url value = "/resources/magnum_opus_logo.jpg"/>" width="200" height="200"
    alt="Logo Here" />
</div>
<header>
	<h1>Home Page</h1>
</header>

<%@ include file="/resources/navbar.jsp" %>
<nav id="nav2">
	<ul>
		
	</ul>
</nav>
	<article>
		<h2>Home</h2>
	</article>
	<aside>
		<h3>Options</h3>
		<ul>
		</ul>
	</aside>				
<%@ include file="/resources/footer.html" %>
</body>
</html>