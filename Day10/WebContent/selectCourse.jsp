<%@page import="kdata.manager.Course"%>
<%@page import="java.util.List"%>
<%@page import="kdata.manager.CourseManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border='1'>
		<tr>
			<th>학번</th>
			<th>이름</th>
			<th>과목</th>
			<th>성적</th>
			<th>수강신청일</th>
		</tr>

		<%
			CourseManager cm = new CourseManager();
			List<Course> list = cm.courseList();

			for (Course c : list) {
		%>

		<tr>
			<td><%=c.getsId()%></td>
			<td><a href="selectOne.jsp?name=<%=c.getsName()%>"><%=c.getsName()%></a></td>
			<td><%=c.getSjName()%></td>
			<td><%=c.getGrade()%></td>
			<td><%=c.getcDay()%></td>
		</tr>
		
		<%
			}
		%>
	</table>
</body>
</html>