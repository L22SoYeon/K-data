<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");

	if (id.equals("test") && pwd.equals("1234")) {
		System.out.println("로그인 성공");
		out.print("로그인 성공");
		//response.sendRedirect("main.jsp");
	} else {
		System.out.println("로그인실패");
		out.print("로그인 실패");
		response.sendRedirect("login.html");
	}
%>


<body>

</body>
</html>