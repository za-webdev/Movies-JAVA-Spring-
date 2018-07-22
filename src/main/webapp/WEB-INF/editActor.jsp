<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form method="POST" action="/edit/actor/${id}" modelAttribute="actor">
	    <form:label path="name">Name:
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label><br>
	    
	    <input type="submit" value="Submit"/>
	</form:form>

</body>
</html>