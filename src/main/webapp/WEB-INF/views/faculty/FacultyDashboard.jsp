<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.breadcrumb-area {
	border-bottom-width: 0;
	padding-top: 100px;
	padding-bottom: 100px;
	background-size: cover;
	background: #eff2f6 url(resources/css_images/title-bar-01-bg.jpg)
		no-repeat center center;
}

h2.breadcrumb-title {
	font-family: none;
}

.card-container {
	padding: 40px;
	justify-content: center;
	display: flex;
    align-items: center;
}
</style>
</head>
<body>
	<%@include file="FacultyHeader.jsp"%>

	<div class="breadcrumb-area university-management-system">
	<br>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="breadcrumb_box text-center">
						<h2 class="breadcrumb-title">
							${facultyData.sub_name } - ${facultyData.ffname }
						</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="card-container">
	<br>
		<div class="card" style="width: 15rem; float: left; margin: 20px">
			<div class="card-body">
				<h5 class="card-title">
					<center>Total Faculty</center>
				</h5>
				<p class="card-text">
				<center>${facultycount }</center>
				</p>

			</div>
		</div>
		<div class="card" style="width: 15rem; float: left; margin: 20px">
			<div class="card-body">
				<h5 class="card-title">
					<center>Total Students</center>
				</h5>
				<p class="card-text">
				<center>${studentcount }</center>
				</p>

			</div>
		</div>
		
		<div class="card" style="width: 15rem; float: left; margin: 20px">
			<div class="card-body">
				<h5 class="card-title">
					<center>Total Files</center>
				</h5>
				<p class="card-text">
				<center>${filecount }</center>
				</p>

			</div>
		</div>
	<br>		
	<br>
	</div>
	<footer class="bg-light text-center text-lg-start">
  <!-- Copyright -->
  <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
    © 2020 Copyright:
    <a class="text-dark" href="https://mdbootstrap.com/">MDBootstrap.com</a>
  </div>
  <!-- Copyright -->
</footer>
</body>
</html>