<%@page import="kdata.manager.StudentManager"%>
<%@page import="kdata.manager.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
		StudentManager sm = new StudentManager();

		Student s = sm.selectByName(name);
	%>
	<table border="1">

		<tr>
			<td><%=s.getsId()%></td>
			<td><%=s.getsName()%></td>
			<td><%=s.getSex()%></td>
		</tr>

	</table>
</body>
</html>