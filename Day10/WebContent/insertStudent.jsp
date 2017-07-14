<%@page import="kdata.manager.Student"%>
<%@page import="kdata.manager.StudentManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		String num = request.getParameter("num");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		
		StudentManager sm = new StudentManager();
		Student s = new Student(num, name, gender);

		int result=sm.insert(s);
		
		if (result == 0)
			System.out.println("실패");
		else
			System.out.println("성공");
	%>
</body>
</html>