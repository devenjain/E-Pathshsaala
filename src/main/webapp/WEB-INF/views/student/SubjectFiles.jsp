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
	margin-top: 70px;
	margin-bottom: 15px;
	padding-left: 5rem;
    padding-right: 1.5rem;
}
.card-container {
	padding: 40px;
	justify-content: center;
	display: flex;
    align-items: center;
}
</style>

</head>
<body class="body-container">
	<%@include file="StudentHeader.jsp"%>
	<br>

	<h3>${sub_name } (${sub_id })</h3>
	<hr>
	<br>
	<%int count=0; %>
<div class="card-container">
	<teble> 
		<c:forEach items="${FileList }" var="file">
		<%count++;
		if(count == 5){%>
		<br><%} %>

		<c:choose>

			<c:when
				test="${ (fileType == 'image/jpeg') || (fileType == 'image/jpg') || (fileType == 'image/png')}">
				
				<div class="card"
					style="width: 12rem; float: right;padding:60px;">
					<a
						href="displayFile?fname=${file.file_name }&ftype=${file.file_type}&folder=${file.sub_name}"
						target="_blank" rel="noopener noreferrer"> <img
						class="card-img-top"
						src="resources/Subject/${file.sub_name }/${file.file_name}"
						alt="Not Found!!!" style="height: 12rem" />
					</a>
					<div>
						<p>File name : ${file.file_name}</p>
						<p>File Desc : ${file.file_desc}</p>
						<p>Subject : ${file.sub_name}</p>
						
					</div>
				</div>

			</c:when>

			<c:otherwise>
				
				<a
					href="displayFile?fname=${file.file_name }&ftype=${file.file_type}&folder=${file.sub_name}"
					target="_blank" rel="noopener noreferrer">
					<div class="card"
						style="width: 12rem; float: left; margin-right: 40px; margin-bottom: 40px">

						<embed class="card-img-top"
							src="resources/Subject/${file.sub_name }/${file.file_name}"
							alt="Card image cap" style="height: 12rem" />

						<div class="card-body">
							<p class="card-text">File name : ${file.file_name }</p>
							<p class="card-text">File Desc : ${file.file_desc}</p>
							<p class="card-text">Subject : ${file.sub_name}</p>
				</a>

				</div>
				</div>

			</c:otherwise>

		</c:choose>

	</c:forEach> </teble>
	<div/>
	<script>
		// Get the img object using its Id
		img = document.getElementById("img1");
		// Function to increase image size
		function enlargeImg() {
			// Set image size to 1.5 times original
			img.style.transform = "scale(1.5)";
			// Animation effect 
			img.style.transition = "transform 0.25s ease";
		}
		// Function to reset image size
		function resetImg() {
			// Set image size to original
			img.style.transform = "scale(1)";
			img.style.transition = "transform 0.25s ease";
		}
	</script>

</body>
</html>