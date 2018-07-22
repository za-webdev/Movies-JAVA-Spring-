
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<title>Selected Movie</title>
</head>
<body>
	<h1>Movie Info</h1>
	
	<p>Movie Title:
	<c:out value="${movie.title}"/></p>
	<p>Movie year:
	<c:out value="${movie.year}"/></p>
	<c:forEach items="${movie.actors}" var="actor" varStatus="loop">
	<p>Cast:
	<c:out value="${actor.name}"/></p>
	</c:forEach>
	
</body>
</html>