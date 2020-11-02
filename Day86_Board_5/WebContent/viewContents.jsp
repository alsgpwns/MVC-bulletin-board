<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hj.www.dto.DTO"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="description" content="HTML Study">
<meta name="keywords" content="HTML,CSS,XML,JavaScript">
<meta name="author" content="Hyemoeng">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>혜멍이네 게시판</title>
</head>
<body>

<script>
	function mySubmit(index) {
		if(index ==1){
			document.myForm.action='ModifyContents.do';
		}
		else if(index ==2)
		{
			document.myForm.action='delete.do'
		}
	}
</script>

	<form method="post" name="myForm">
		<table border="1">
			<tr>
				<td>No.</td>
				<td><input type="text" name="no" value="${dto.no }" readonly></td>
			</tr>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${dto.id }" readonly></td>
			</tr>
			<tr>
				<td>Title</td>
				<td><input type="text" name="title" value="${dto.title }"></td>
			</tr>
			<tr>
				<td>Contents</td>
				<td><textarea rows="10" cols="50" name="contents" required>${dto.contents }</textarea>
			</td>
		</table>


		<c:set var="dtoId" value="${dto.id}" />
		<c:if test="${dto.id == id}">
			<input type="submit" value="수정" onclick="mySubmit(1)">
			<input type="submit" value="삭제" onclick="mySubmit(2)">
		</c:if>
		<input type="button" value="List"  onclick="location.href='list.do'">
	</form>


</body>
</html>