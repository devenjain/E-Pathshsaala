<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%-- <%@page import="com.admin.bean.SubjectBean"%> --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject</title>

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

<script>
	$('.alert').alert()
</script>


<style>
.manageMainBody {
	margin: 15px 50px 15px 50px;
}

.delete {
	background-color: "GREY";
	color: black;
	/*padding: 2px;*/
	padding-left: 26px;
	padding-right: 26px;
	padding-top: 2px;
	padding-bottom: 2px;
	text-decoration: none;
	border: 1px solid black;
	height: 10px;
	width: 250px;
	font-size: 14px;
}

.delete:hover {
	background-color: black;
	color: white;
	transition-delay: .1s;
	transition-property: background-color;
	cursor: pointer;
}

.update {
	background-color: "GREY";
	color: black;
	/*padding: 2px;*/
	padding-left: 26px;
	padding-right: 26px;
	padding-top: 2px;
	padding-bottom: 2px;
	text-decoration: none;
	border: 1px solid black;
	height: 10px;
	width: 250px;
	font-size: 14px;
}

.update:hover {
	background-color: black;
	color: white;
	transition-delay: .1s;
	transition-property: background-color;
	cursor: pointer;
}
</style>

<SCRIPT>
	function ShowAndHide() {
		var x = document.getElementById('SectionName');
		if (x.style.display == 'none') {
			x.style.display = 'block';
		} else {
			x.style.display = 'none';
		}
	}
</SCRIPT>

</head>

<header>
	<%@include file="AdminHeader.jsp"%>
	<br>
</header>

<body>
<body>

	<div class="manageMainBody">
		<h4>Add Subject</h4>
		<br>
		 

		<div>

			<br>
			<form action="updateSub" method="post">
				<div style="color: red;">${err}</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputEmail4">Subject ID</label> 
							<input class="form-control" name="sub_id" type="text" value="${sub_bean.sub_id}" readonly>
					</div>
					<br>
					<div class="form-group col-md-6">
						<label for="inputPassword4">Subject Name</label> <input
							type="text" class="form-control" value="${sub_bean.sub_name}" name="sub_name"
							placeholder="Subject Name">
					</div>
				</div>
				<br>
				<button type="submit" class="btn btn-secondary">Submit</button>
			</form>

		</div>
		
		<br>
		<hr>
		
	</div>
</body>
</html>