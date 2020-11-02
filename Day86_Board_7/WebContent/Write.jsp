<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<form method="post" action="write.do">
		<table border="1">
		<tr>
			<td>ID</td>
			<td><input type="text" name="id" value="${id}" readonly></td>
		</tr>
		<tr>
			<td>Title</td>
			<td><input type="text" name="title" required></td>
		</tr>
		<tr>
			<td>Contents</td>
			<td><textarea rows="10" cols="50" name="contents" required></textarea></td>
		</tr>
		</table>
		<input type="submit" value="Write">
		<input type="button" value="list" onclick="location.href='list.do'">
	</form>
</body>
</html>