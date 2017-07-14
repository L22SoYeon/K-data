<%@page import="kdata.manager.Student"%>
<%@page import="kdata.manager.StudentManager"%>
<%@page import="java.util.List"%>
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
		StudentManager sm = new StudentManager();

		List<Student> list = sm.selectAll();

		out.print("<table border='1'>");
		out.print("<tr><th>학번</th><th>이름</th><th>성별</th>");

		for (Student s : list) {
			out.print("<tr><td>" + s.getsId() + "</td><td>" 
			+ s.getsName() + "</td><td>" + s.getSex() + "</td></tr>");
		}
		out.print("</table>");
	%>
</body>
</html>