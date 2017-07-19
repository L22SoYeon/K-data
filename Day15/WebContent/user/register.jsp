<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.2.1.js">
	
</script>
<script>
	$(function() {

		$("#idcheck").click(function() {

			//alert("Gggg");
			$.ajax({
				url : "../idcheck.kdata",
				data : {
					"id" : $("#id").val()
				},
				dataType : "text",
				success : function(data) {
					//console.log("success");
					//console.log(data);
					if (data == 0)
						$("#msg").html("중복").css("color", "red");
					else
						$("#msg").html("사용가능");
				},
				error : function() {
					console.log("error");
				}
			});
		});
	});
</script>
</head>
<body>
	<%@ include file="../common/menu.jsp"%>

	회원가입-register.jsp
	<form action="../register.kdata" method="post" enctype="multipart/form-data">

		<ul>
			<li>아이디 : <input type="text" name="id" id="id" value="test">
				<input type="button" value="중복확인" id="idcheck"> <span
				id="msg"></span>
			<li>비밀번호 : <input type="password" name="pw" value="1234">
			<li>이름 : <input type="text" name="name" value="홍길동">
			<li>프로필 사진 : <input type="file" name="file">
		</ul>

		<input type="submit" value="회원가입">
	</form>
</body>
</html>