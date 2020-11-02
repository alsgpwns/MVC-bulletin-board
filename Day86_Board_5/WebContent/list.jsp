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
<%
	String id = (String)session.getAttribute("id");
%>
<%=id %>님, 안녕하세요! <br/>

	
	<form method="post" action="Write.jsp">
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
				<td><a href="viewContents.do?no=${dto.no}">${dto.title }</a></td>
			</tr>
			</c:forEach>
		</table>
	<input type="submit" value="Write" >
	<input type="button" value="log out" onclick="location.href='logout.do'">
	</form>
</body>
</html>