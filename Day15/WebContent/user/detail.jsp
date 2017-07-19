<%@page import="kdata.project.dto.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = (User)request.getAttribute("detail");
	%>
	<table border="10" width=300 bordercolor="orange">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가입일</th>
			<th>사진</th>
		</tr>
		<tr>
			<td><%=user.getId()%></td>
			<td><%=user.getName()%></td>
			<td><%=user.getRegDate()%></td>
			<td><img src="./profile/${requestScope.detail.profile}"></td>
		</tr>
	</table>
</body>
</html>