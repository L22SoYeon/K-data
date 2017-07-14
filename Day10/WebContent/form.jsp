<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head> <font color="white">
<%
	String num = request.getParameter("num");
	String name = request.getParameter("name");
	String gender = request.getParameter("gender");
	String color = request.getParameter("color");
	String url = request.getParameter("url");

	if (gender == null) {
		out.print("성별을 선택하지 않았습니다<br>");
	} else if (gender.equals("M")) {
		gender = "남자";
	} else if (gender.equals("F")) {
		gender = "여자";
	}

	out.print(num + "<br>");
	out.print(name + "<br>");
	out.print(gender + "<br>");
	out.print("<a href='" + url + "'>" + url + "</a>");

	out.print("<table border='1'>" 
	+ "<tr><th>학번</th>"
	+ "<td>" + num + " </td>"
	+ "<tr><th>이름</th>"
	+ "<td>" + name + " </td>"
	+ "<tr><th>성별</th>"
	+ "<td>" + gender + "</td></table>");


%></font>
<%-- <body bgcolor="<%out.print(request.getParameter("color"));%>"> --%>
<body bgcolor="<%=color%>">
	<table border="1">
		<tr>
			<th>학번</th>
			<td>
				<%
					out.print(num);
				%>
			</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>
				<%
					out.print(name);
				%>
			</td>
		</tr>
		<tr>
		<tr>
			<th>성별</th>
			<td>
				<%
					out.print(gender);
				%>
			</td>
		</tr>
		<tr>
	</table>
</body>
</html>