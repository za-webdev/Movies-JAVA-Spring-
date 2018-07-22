<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Edit page</title>
</head>
<body>
	
	<form:form method="POST" action="/edit/${id}" modelAttribute="movie">
	    <form:label path="title">Title:
		    <form:errors path="title"/>
		    <form:input path="title"/>
	    </form:label><br>
	    
	    <form:label path="year">Year:
		    <form:errors path="year"/>     
		    <form:input path="year"/>
	    </form:label><br>
	    
	    <input type="submit" value="Submit"/>
	</form:form>
		
</body>
</html>