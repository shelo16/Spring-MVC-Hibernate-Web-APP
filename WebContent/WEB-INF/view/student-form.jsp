<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<html>
	<head>
		<title>Student Form Page</title>
	</head>
	
	<body>
		
		<form:form action = "showPostForm" modelAttribute = "myStudent" method = "POST">
		
			<!-- associate id with this form -->
			<form:hidden path="id"/>
			
			<table>
				<tbody>
					<tr>
						<td><label>First Name : </label>
						<td><form:input path = "firstName"/>
					</tr>
					<tr>
						<td><label>Last Name : </label>
						<td><form:input path = "lastName"/>
					</tr>
					<tr>
						<td><label>Email : </label>
						<td><form:input path = "email"/>
					</tr>
					<tr>
						<td><label>Comment : </label></td>
						<td><form:textarea path="comment" rows="5" cols="30" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type = "submit" value = "Save"/>
					</tr>
						
				</tbody>
			</table>
			
		</form:form>
			<p>
				<a href = "${pageContext.request.contextPath}/student/list">Back To The List</a>
			</p>
		
	</body>
</html>