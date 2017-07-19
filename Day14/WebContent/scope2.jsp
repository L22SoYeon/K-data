<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope2.jsp</h1>
	<%
		String pageScope = request.getParameter("page");
		String requestScope = request.getParameter("request");
		String sessionScope = request.getParameter("session");
		String applicationScope = request.getParameter("application");

		out.print("pageScope : " + pageScope + "<br>");
		out.print("requestScope : " + requestScope + "<br>");
		out.print("sessionScope : " + sessionScope + "<br>");
		out.print("applicationScope : " + applicationScope + "<br>");

		// scope에 저장
		pageContext.setAttribute("PAGE", pageScope); 
		request.setAttribute("REQUEST", requestScope);
		session.setAttribute("SESSION", sessionScope);
		application.setAttribute("APPLICATION", applicationScope);

		// ------------------------ 페이지 이동 - 리다이렉트
		//response.sendRedirect("scope3.jsp");
		// 결과 : page, request는 null / 나머지는 유지
		// 요청 -> 응답 -> 재요청 -> 응답
		// 주소 : http://localhost:7777/Day14/scope3.jsp

		// ------------------------ 페이지 이동 - 포워드
		RequestDispatcher dispatcher = request.getRequestDispatcher("scope3.jsp");
		dispatcher.forward(request, response);
		// 결과 : page는 null / 나머지는 유지
		// 요청 -> 응답
		// 클라이언트로 내려오지 않고 서버상에서 페이지 이동
		// 주소 : http://localhost:7777/Day14/scope2.jsp?page=%ED%8E%98%EC%9D%B4%EC%A7%80%EC%98%81%EC%97%AD&request=%EB%A6%AC%ED%80%98%EC%8A%A4%ED%8A%B8%EC%98%81%EC%97%AD&session=%EC%84%B8%EC%85%98%EC%98%81%EC%97%AD&application=%EC%96%B4%ED%94%8C%EB%A6%AC%EC%BC%80%EC%9D%B4%EC%85%98%EC%98%81%EC%97%AD
		
		// 따라서 세션은 로그인에 자주 사용
	%>
</body>
</html>