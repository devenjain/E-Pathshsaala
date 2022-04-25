<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.main {
	margin-top: 2%;
	margin-left: 22%;
	font-size: 28px;
	padding: 0 10px;
	width: 58%;
}

.main h2 {
	color: #333;
	font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
	font-size: 24px;
	margin-bottom: 10px;
}

.main .card {
	background-color: #fff;
	border-radius: 18px;
	box-shadow: 1px 1px 8px 0 grey;
	height: auto;
	margin-bottom: 20px;
	padding: 20px 0 20px 50px;
}

.main .card table {
	border: none;
	font-size: 16px;
	height: 270px;
	width: 80%;
}
</style>

</head>
<body>
	<%@include file="AdminHeader.jsp"%>
	<div class="main">
		<center><h3>${currentUser.afname } Profile</h3></center>
		<br>
		<div class="card">
			<div class="card-body">
				<i class="fa fa-pen fa-xs edit"></i>
				<table>
					<tbody>
						<tr>
							<td>Id</td>
							<td>:</td>
							<td>${currentUser.aid }</td>
						</tr>
						<tr>
							<td>First Name</td>
							<td>:</td>
							<td>
								${currentUser.afname }
							</td>
						</tr>
						<tr>
							<td>Last Name</td>
							<td>:</td>
							<td>${currentUser.alname }
							</td>
						</tr>
						<tr>
							<td>Email</td>
							<td>:</td>
							<td>
								${currentUser.aemail }
							</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>:</td>
							<td>
								${currentUser.apassword }
							</td>
						</tr>
						<tr>
							<td>Phone</td>
							<td>:</td>
							<td>
								${currentUser.aphone }
							</td>
						</tr>
						<tr>
							<td>Date Of Birth</td>
							<td>:</td>
							<td>
								${currentUser.adob }
							</td>
						</tr>
						<tr>
							<td>Gender</td>
							<td>:</td>
							<td>
								${currentUser.agender }
							</td>
						</tr>

					</tbody>
				</table>
			</div>
		</div>
	</div>
	<br><br><br><br>
	<%@include file="AdminFooter.jsp"%>
</body>
</html>