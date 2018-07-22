
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<title>Insert title here</title>
</head>
<body>
	
	<form:form method="POST" action="create" modelAttribute="actor">
	    <form:label path="name">Name:
	    <form:errors path="name"/>
	    <form:input path="name"/></form:label><br>
	    
	    <input type="submit" value="Submit"/>
	   
	</form:form>
	
	<c:forEach items="${actors}" var="actor" varStatus="loop">
			<p><c:out value="${actor.name}"/></p>
			
			 <a href="/edit/actor/${actor.id}"><button>Edit</button></a>
			  <a href="/show/actor/${actor.id}"><button>Show Details</button></a>
			 
		</c:forEach>
	

</body>
</html>