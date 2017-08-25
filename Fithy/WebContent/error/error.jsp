<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<br><br>
<h1>ERROR!</h1>
<%-- <%= request.getAttribute("errorMessage")%>
${requestScope.errorMessage} --%><!-- spring 할때 이거 씀 -->
<br><br><br><br><br><br><br><br><br>
<h2>${errorMessage}</h2>
<a href="javascript:history.back()">뒤로가기</a></div>
</body>
</html>