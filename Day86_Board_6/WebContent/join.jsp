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
<title>혜멍이네 게시판</title>
</head>
<body>
<form method="post" action="join.do">
	<table>
		<tr>
			<td>이름: </td>
			<td><input type="text" name="name" required></td>
		</tr>
		<tr>
			<td>아이디: </td>
			<td><input type="text" name="id" required></td>
		</tr>
		<tr>
			<td>NickName: </td>
			<td><input type="text" name="nickname" required></td>
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
			<td><input type="text" name="email" required> </td>
		</tr>
		<tr>
			<td>주소</td>
			<td><input type="text" name="address" required></td>
		</tr>
		<tr>
			<td>생년월일 : </td>
			<td><input type="text" name="birth">
				<select>
					<option>1</option>
					<option>2</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>전화번호: </td>
			<td><input type="text" name="phone">
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