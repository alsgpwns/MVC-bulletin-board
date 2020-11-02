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
<title>Insert title here</title>
</head>
<body>
<form method="post" action="modifyOk.do">
	<table>
		<tr>
			<td>이름: </td>
			<td><input type="text" name="name" value="${dto.name }" readonly></td>
		</tr>
		<tr>
			<td>아이디: </td>
			<td><input type="text" name="id" value="${dto.id }" readonly></td>
		</tr>
		<tr>
			<td>NickName: </td>
			<td><input type="text" name="nickname" value="${dto.nickName }" required></td>
		</tr>
		<tr>
			<td>비밀번호: </td>
			<td><input type="password" name="password" required></td>
		</tr>
		<tr>
			<td>비밀번호 재확인: </td>
			<td><input type="password" name="repassword" required></td>
		</tr>
		<tr>
			<td>이메일 :</td>
			<td><input type="text" name="email" value="${dto.email }" required> </td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" value="${dto.address }" required></td>
		</tr>
		<tr>
			<td>생년월일 : </td>
			<td><input type="text" name="birthDay" value="${dto.birthDay}">
				<select name="birthDaynum">
					<option>1</option>
					<option>2</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>전화번호: </td>
			<td><input type="text" name="phone" value="${dto.phoneNumber }">
		</td>
		<tr>
			<td>성별: </td>
			<td><input type="radio" name="sex" value="1" />남
				<input type="radio" name="sex" value="2" />여
			</td>
		</tr>
	</table>
	<input type="submit" value="확인">
</form>
</body>
</html>