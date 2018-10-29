<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Student List Page</title>
	</head>
	
	<body>
		
		<h2>CRM - Customer Relationship Manager(or Student :/)</h2>
		
		
		<table border = "5" align = "center">
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Comment</th>
				<th>Action</th>
			</tr>
			
			<c:forEach var = "student" items = "${myStudentList}">
			
				<c:url var = "updateLink" value = "/student/showFormForUpdate">
					<c:param name = "studentId" value = "${student.id}"/>
				</c:url>
				
				<c:url var = "deleteLink" value = "/student/deleteStudent">
					<c:param name = "studentId" value = "${student.id}"/>
				</c:url>
			
				<tr>
					<td>${student.firstName}</td>
					<td>${student.lastName}</td>
					<td>${student.email}</td>
					<td>${student.comment}</td>
					<td>
						<a href = "${updateLink}">Edit</a>
						<a href = "${deleteLink}"
						   onclick = "if(!(confirm('are you sure you want to delete student?'))) return false">Delete
						</a>
					</td>
				</tr>
			
			</c:forEach>
		</table>
		
		<!-- put new button: Add Customer -->
		<input type = "button" value = "Add Student"
			   onclick = "window.location.href='showForm'; return false;"
		/>
		
	</body>
</html>