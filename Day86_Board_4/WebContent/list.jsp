<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>
<%@ page import ="com.hj.www.dto.ListDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Hyemoeng">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="">
		<table border="1">
			<tr>
				<td>No. </td>
				<td>ID </td>
				<td>Title </td>
			</tr>
			<c:forEach var="dto" items="${list}" >
			<tr>
				<td>${dto.no }</td>
				<td>${dto.id }</td>
				<td>${dto.title }</td>
			</tr>
			</c:forEach>
		</table>
	</form>
</body>
</html>