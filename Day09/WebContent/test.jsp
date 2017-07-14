<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=UTF-8>
<title>Insert title here</title>
<style>
/* CSS 영역 */
body {
	background-color: #1654F0;
	color: white
}
</style>
<script>
	/* JavaScript 영역 */
	function test() {
		window.alert("JavaScript 테스트");
	}
</script>
</head>
<body onload="test()">
	<%
		Class.forName("java.lang.Object");
		out.print("<h2>JSP 영역 #1</h2>");

		for (int i = 1; i <= 10; i++)
			out.print("Hello!<br>");
	%>
	<h1>HTML 영역</h1>
	<%
		out.print("JSP 영역 #2");
	%>

	http://localhost:7777/Day09/test.html
</body>
</html>