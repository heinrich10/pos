<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page session="false"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Operation Successful
	<sf:form>
		<input type="submit" name="_eventId_end" value="Start Over" id="input"/>
		<input type="submit" name="_eventId_cancel" value="Ok" id="input"/>
	</sf:form>
</body>
</html>