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
// 세션 개별 종료
//session.removeAttribute("id");
//session.removeAttribute("name");

// 세션 한번에 종료(초기화)
session.invalidate();
	
response.sendRedirect("main.jsp");
%>
</body>
</html>