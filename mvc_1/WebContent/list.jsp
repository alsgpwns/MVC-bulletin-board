<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.hj.www.dao.BDAO"%>
<%@ page import ="com.hj.www.dto.BDTO" %>
<%@ page import ="com.hj.www.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import ="java.sql.*" %>
 
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
<input type="button" onclick="location.href='list.do'" value="List">
<input type="button" onclick="location.href='write.do'" value="Write">
<table border="1">
<tr>
	<td>No.</td>
	<td>Name</td>
	<td>Title</td>
	<td>Date</td>
	<td>Views</td>
</tr>
<%
	ArrayList<BDTO> list = (ArrayList<BDTO>)request.getAttribute("list");
	for(int i=0; list!=null && i<list.size(); i++){
	BDTO dto = list.get(i);
%>
<tr>
	<td>
	<%
		out.print(dto.getNo());
	%>
	</td>
	<td>
	<%
		out.print(dto.getName());
	%>
	</td>
	<td>
	<%
		out.print(dto.getTitle());
	%>
	</td>
	<td>
	<%
		out.print(dto.getWtime());
	%>
	</td>
	<td>
	<%
		out.print(dto.getRcnt());
	}
	%>
</tr>
</table>

</body>
</html>