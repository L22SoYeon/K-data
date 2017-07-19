<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope3.jsp</h1>
	<%
		String pageS = (String) pageContext.getAttribute("PAGE");
		String requestS = (String) request.getAttribute("REQUEST");
		String sessionS = (String) session.getAttribute("SESSION");
		String applicationS = (String) application.getAttribute("APPLICATION");
		
		out.print("pageScope : " + pageS + "<br>"); // 유지 안됨
		out.print("requestScope : " + requestS + "<br>"); // 유지 안됨
		out.print("sessionScope : " + sessionS + "<br>"); // 브라우저 실행되는 동안만 유지
		out.print("applicationScope : " + applicationS + "<br>"); // 서버가 실행되는 동안만 유지
		
		
	%>
</body>
</html>