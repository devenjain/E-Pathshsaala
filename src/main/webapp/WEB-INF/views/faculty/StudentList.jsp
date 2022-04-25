<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>

<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
	crossorigin="anonymous"></script>



<style>
.body-container {
	padding-left: 5rem;
    padding-right: 1.5rem;
}
</style>



</head>
<body>
	<%@include file="FacultyHeader.jsp"%>
	<div class="body-container">
	<br>
	<h2>Students</h2>
	<hr>
	<br>
	<a href="addStudent" class="btn btn-primary">ADD Student</a>
	<!-- <a href="studentHeader" class="btn btn-secondary">ADD Student</a> -->
	<br>

	<br>
	<br>

	<table class="table table-hover" border="1px">

		<tr>
			<b>
				<th><center>#</center></th>
				<th><center>ID</center></th>
				<th><center>Name</center></th>
				<th><center>Email</center></th>
				<th><center>BirthDate</center></th>
				<th><center>Gender</center></th>
				<th><center>Phone</center></th>
				<th><center>DELETE</center></th>
				<th><center>UPDATE</center></th>
			</b>
		</tr>
		<%
			int count = 1;
		%>
		<c:forEach items="${studentList }" var="student">

			<tr>
				<td><center><%=count%></center></td>
				<td><center>${student.sid }</center></td>
				<td><center>${student.slname }&nbsp;${student.sfname }&nbsp;${student.smname }</center></td>
				<td><center>${student.semail }</center></td>
				<td><center>${student.sdob }</center></td>
				<td><center>${student.sgender }</center></td>
				<td><center>${student.sphone }</center></td>


				<td><center>
						<a href="deleteStudent?sid=${student.sid }"
							class="btn btn-danger a-btn-slide-text"> <i
							class="bi bi-trash"></i> <span class="glyphicon glyphicon-remove"
							aria-hidden="true"></span> <span><strong>Delete</strong></span>
						</a>
					</center></td>
				<td><center>
						<a href="editStudent?sid=${student.sid }"
							class="btn btn-primary a-btn-slide-text"> <span
							class="glyphicon glyphicon-edit" aria-hidden="true"></span> <span><strong>Edit</strong></span>
						</a>
					</center></td>
			</tr>
			<%
				count++;
			%>
		</c:forEach>


	</table>
</div>
</body>
</html>