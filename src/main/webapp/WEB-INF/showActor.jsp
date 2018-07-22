<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<p><c:out value="${actor.name}"/></p>
	<c:forEach items="${actor.movies}" var="movie" varStatus="loop">
	<p>Movie:
	<c:out value="${movie.title}"/></p>
	</c:forEach>
			 
	
</body>
</html>