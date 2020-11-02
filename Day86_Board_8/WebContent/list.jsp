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

${id }님, 안녕하세요! <br/>
<form method="post" action="search.do">
	<select name="searchType">
		<option>작성자</option>
		<option>내용</option>
		<option>제목</option>
	</select>
	<input type="text" name="searchText">
	<input type="submit" value="검색">
</form>
<br/>

	<form method="post" action="Write.jsp">
	<input type="submit" value="Write" >
	<input type="button" value="log out" onclick="location.href='logout.do'">
	<br/>
		<table border="1">
			<tr>
				<td>No. </td>
				<td>ID </td>
				<td>Title </td>
				<td>Views </td>
			</tr>
			<c:forEach var="dto" items="${list}" >
			<tr>
				<td>${dto.no }</td>
				<td>${dto.id }</td>
				<td><a href="viewContents.do?no=${dto.no}&id=${dto.id}">${dto.title }</a></td>
				<td>${dto.views }</td>
			</tr>
			</c:forEach>
		</table>
		<br/>
	</form>
	<br/>
	
	<a href="list.do?number=0">1</a>
	<a href="list.do?number=5">2</a> 
	<a href="list.do?number=10">3</a>
	<a href="list.do?number=15">4</a>
	<a href="list.do?number=20">5</a>  
	<a href="list.do?number=100">end</a> 
	
	
	
</body>
</html>