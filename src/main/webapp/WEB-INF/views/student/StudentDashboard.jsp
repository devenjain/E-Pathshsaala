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
	<%@include file="StudentHeader.jsp"%>

	<div class="breadcrumb-area university-management-system">
		<br>
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="breadcrumb_box text-center">
						<h2 class="breadcrumb-title">${studentData.sfname }
							${studentData.slname }</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
<br><br>

	<div class="card-container">

		<c:forEach items="${subjects }" var="subject">

			<a
				href="subFiles?sub_id=${subject.sub_id }&sub_name=${subject.sub_name}">
				<div class="card" style="width: 15rem; float: left; margin: 20px">
					<div class="card-body">
						<h5 class="card-title">
							<center>${subject.sub_name }</center>
						</h5>
						<p class="card-text">
						<center>${subject.sub_id }</center>
						</p>

					</div>
				</div>
		</c:forEach>



	</div><br><br><br><br>

	<footer class="bg-light text-center text-lg-start">
		<!-- Copyright -->
		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			© 2022 Copyright: <a class="text-dark" href="">E-Pathshaala</a>
		</div>
		<!-- Copyright -->
	</footer>
</body>
</html>