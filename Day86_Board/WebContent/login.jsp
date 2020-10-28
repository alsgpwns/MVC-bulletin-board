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
<form method="post" action="login.do">
	<table>
		<tr>
			<td>아이디: </td>
			<td><input type="text" name="id"></td>
		</tr>
		<tr>
			<td>비밀번호: </td>
			<td><input type="password" name="pw"></td>
		</tr>
	</table>
	<input type="submit" value="로그인">
</form>
</body>
</html>