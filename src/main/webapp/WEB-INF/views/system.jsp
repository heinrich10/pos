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
<base href="http://localhost:8080/erp/system/"/>
</head>
<body>
<div id="icon">
	<img src="<c:url value = "/resources/magnum_opus_logo.jpg"/>" width="200" height="200"
    alt="Logo Here" />
</div>
<header>
	<h1> System </h1>
</header>
<%@ include file="/resources/navbar.jsp" %>
<nav id="nav2">
	<ul>
		<li><a href="parameters/"> Parameters </a></li>
		<li><a href="shutdown/"> Shutdown </a></li>
	</ul>
</nav>
<c:choose>
	<c:when test="${option == 'shutdown'}">
		<section>
			<article>
				<a href="transaction"> Refresh </a>
				<h2>Shutdown</h2>
				<form>
					<input type="submit" formaction="shutdown/" formmethod="post" value="Shut Down"/>
				</form>
			</article>
		</section>
		<aside>
			<h3>Options</h3>
			<ul>
				<li><a href="parameters/"> Parameters </a></li>
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
				<li><a href="parameters/"> Parameters </a></li>
				<li><a href="shutdown/"> Shutdown </a></li>
			</ul>
		</aside>
	</c:otherwise>


</c:choose>


<%@ include file="/resources/footer.html" %>
</body>
</html>