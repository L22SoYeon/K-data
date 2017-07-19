<%@page import="kdata.project.dto.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>Insert title here</title>
</head>
<body>
	회원리스트-list.jsp
	<%
	List<User> list = (List<User>) request.getAttribute("list");
%>

	<table border="10" width=300 bordercolor="orange">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가입일</th>
		</tr>

		<%
			for (User user : list) {
				out.print("<tr><td>" + user.getId() + "</td><td>" + user.getName() + "</td><td>" + user.getRegDate()
						+ "</td></tr>");
			}
		%>

	</table>
	
	<table border="10" width=300 bordercolor="orange">
		<tr>
			<th>아이디</th>
			<th>이름</th>
			<th>가입일</th>
		</tr>
		<c:forEach items="${ list }" var="user">
			<tr>
				<td><a href="detail.kdata?id=${user.id}">${user.id}</a></td>
				<td>${user.name}</td>
				<td>${user.regDate}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>