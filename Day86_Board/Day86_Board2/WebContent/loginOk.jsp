<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
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
	String name = (String)session.getAttribute("name");
%>
<%=name %>님, 안녕하세요.

<form method="post" action="logout.do">
	<input type="submit" value="log out">
	<input type="button" value="회원정보 수정">	
</form>



</body>
</html>