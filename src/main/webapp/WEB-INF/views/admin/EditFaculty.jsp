<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
	// Data Picker Initialization
	$('.datepicker').datepicker({
		inline : true
	});
</script>
<style>
.body-container12 {
	font-family: Calibri, Helvetica, sans-serif;
	background-color: E0FFFF;
	padding-left: 60px;
	padding-right: 60px;
	padding-top: 10px;
	padding-bottom: 10px;
}

.container12 {
	padding-left: 100px;
	padding-right: 100px;
	padding-top: 40px;
	padding-bottom: 10px;
	background-color: #cde2cd;
}

input[type=text], input[type=password], textarea {
	width: 100%;
	padding: 15px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #fdfeff;
}

input[type=text]:focus, input[type=password]:focus {
	background-color: #c8f9ff;
	outline: none;
}

div {
	padding: 10px 0;
}

hr {
	border: 1px solid #f1f1f1;
	margin-bottom: 25px;
}

.registerbtn {
	background-color: #4CAF50;
	color: white;
	padding: 16px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.registerbtn:hover {
	opacity: 1;
}

p {
	color: red;
}
</style>
</head>

<header>
	<%@include file="AdminHeader.jsp"%>
</header>

<body>
	<div class="body-container12">
		<form action="updateFac" method="post">
			<div class="container12">

				<center>
					<h1>Faculty Registeration Form</h1>
				</center>
				<center>${errormsg1}</center>
				<hr>

				<b>Faculty ID</b> &nbsp;&nbsp; <font color="RED"></font>

				<div class="iphone">
					<input type="number" class="form-control" name="fid" value = "${bean.fid }"
						placeholder="ID" required readonly>
				</div>

				<label> Firstname :</label> <font color="RED"> ${fnameError } </font>
				<input type="text" class="form-control" name="ffname" placeholder="Firstname" size="15" value="${bean.ffname}"
					required />

				<label> Lastname : </label> <font color="RED"> ${lnameError } </font> 
				<input type="text" name="flname" class="form-control" placeholder="Lastname" size="15" value="${bean.flname}"
					required />


				<div class="course">
					<label> Subject : </label> <select class="form-select"
						aria-label="Default select example" name="sub_id">
						<option selected disabled>Open this select menu</option>
												
						<c:forEach items="${subjectList }" var="subject">
							<option value="${subject.sub_id }">${subject.sub_name }</option>
						</c:forEach>
						
					</select>
				</div>


				<div>
					Gender : &nbsp;&nbsp;&nbsp;
					<div class="form-check form-check-inline mb-0 me-4">
						<input class="form-check-input" type="radio"
							name="fgender" id="femaleGender" value="option1" /> <label
							class="form-check-label" for="femaleGender">Female</label>
					</div>

					<div class="form-check form-check-inline mb-0 me-4">
						<input class="form-check-input" type="radio"
							name="fgender" id="maleGender" value="option2" /> <label
							class="form-check-label" for="maleGender">Male</label>
					</div>

					<div class="form-check form-check-inline mb-0">
						<input class="form-check-input" type="radio"
							name="fgender" id="otherGender" value="option3" /> <label
							class="form-check-label" for="otherGender">Other</label>
					</div>
				</div>
				<label>

					<div>
						BirthDate : &nbsp;&nbsp;&nbsp;
						<div>
							<input class="form-control" type="date" value="2001-01-01"
								name="fdob" placeholder="DOB" id="example-date-input"
								min="1997-01-01" max="2003-12-31">
						</div>
					</div>

				</label> <br> <b>Phone </b> &nbsp;&nbsp; <font color="RED">${phoneerror}</font>

				<div class="iphone">
					<input type="text" class="form-control" name="fphone" placeholder="phone no." size="10"
						value="${bean.fphone }" required>
				</div>


				<!-- Current Address :  
<textarea cols="80" rows="5" placeholder="Current Address" value="address" required>   -->

				<label for="email"><b>Email</b></label> &nbsp;&nbsp; <font
					color="RED">${emailError }</font> 
					<input type="text" class="form-control"	placeholder="Enter Email" name="femail" value="${bean.femail}" required>
				
				<br><br>
				<center>
				<input type="reset" class="btn btn-secondary btn-lg btn-block" style="width:45%">&nbsp;&nbsp;&nbsp;&nbsp;
				<button type="submit" class="btn btn-primary btn-lg btn-block" style="width:45%">Register</button>
				</center>

				<%--     <%@include file="footer.jsp" %> --%>
		</form>
	</div>
</body>
</html>
