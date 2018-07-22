
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>Insert title here</title>
</head>
<body>
	<h1> Movies</h1>
	
	<table border=1>
			<tr>
				<th>Title</th>
				<th>Year</th>
				<th>Cast</th>
				<th>Action</th>
			</tr>
		<c:forEach items="${movies}" var="movie" varStatus="loop">
			<tr>    
			    <td><c:out value="${movie.title}"/></td>
			    
			    <td><c:out value="${movie.year}"/></td>
			    <td>
			    	<c:forEach items="${movie.actors}" var="actor" varStatus="loop">
			    
			    	<c:out value="${actor.name}"/>
			    	</c:forEach>
			    </td>
			    <td>
			    <a href="/delete/${movie.id}"><button>Delete</button></a>
		    	<a href="/edit/${movie.id}"><button>Edit</button></a>
		    	<a href="/display/${movie.id}"><button>Show</button></a>
		    	
		    	</td>
			</tr>
		</c:forEach>
	</table>
	
	
	
	<form:form method="POST" action="add" modelAttribute="movie">
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
	
	<a href="/addActor">Want to add an actor</a>
	
	<fieldset>
		<legend>Add an actor or actoress to a movie</legend>
			<form action="/cast" method="POST">
				<p>Actors and Actresses:
					<select name="actor_id">
						<c:forEach items="${actors}" var="actor">
							<option value="${actor.id}">${actor.name }</option>
						</c:forEach>
					</select>
				</p>
				
				<p>Movies:
					<select name="movie_id">
						<c:forEach items="${movies}" var="movie">
							<option value="${movie.id}">${movie.title}</option>
						</c:forEach>
					</select>
				</p>
				<input type="submit">
			</form>
	
	</fieldset>
	
	
	

</body>
</html>