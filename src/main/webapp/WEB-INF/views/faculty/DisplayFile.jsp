<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View</title>

<style>
.manageMainBody {
	margin-left: 45px;
	margin-top: 50px;
	margin-right: 10px;
}
</style>

</head>
<body>

	<c:choose>

		<c:when
			test="${ (fileType == 'image/jpeg') || (fileType == 'image/jpg') || (fileType == 'image/png')}">
				
				<center><img src="resources/Subject/${folder }/${fname}"
						alt="Not Found!!!"/></center>
				
		</c:when>

		<c:otherwise>
				
				<center><embed src="resources/Subject/${folder }/${fname}"
						alt="Not Found!!!" width="968px" height="675px"/></center>
		</c:otherwise>

	</c:choose>

</body>
</html>