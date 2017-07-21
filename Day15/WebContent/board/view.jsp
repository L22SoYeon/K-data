<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.2.1.js"></script>
<script>
	/* $(document).ready(function(){}); */
	$(function() {
		// 댓글쓰기-------------------------
		$("#write").click(function() {
			
			$.ajax({
				url : "../writecomments.kdata",
				data : {
					"id":$("#id").val(), "comments":$("#comments").val(), "num":2						
				},
				dataType : "json",
				success : function(data) {
					console.log("ss");
					var str = "<table>";
					$.each(data,function(index, item){
						//console.log(index);
						console.log(item.id);
						
						str=str+"<tr>";
						str=str+"<td>" + item.commentNum + "</td>";
						str=str+"<td>" + item.id + "</td>";
						str=str+"<td>" + item.content + "</td>";
						str=str+"<td><input type='button' value = 'x' id='delete'></td>";
						str=str+"</tr>";
					});
					str = str + "</table>"
					
					$("#list").html(str);
					},
				error : function(data) {
				}
			}); 

		});
		
		// 댓글삭제----------------------------------------------------
		 $("#list").on("click", "#delete", function(){
			//console.log($(this).parent());
			var tr = $(this);
			
			$.ajax({
				url : "deletecomments.kdata",
				data : {				
					"commentsNum" : $(this).parent().parent().find("td:first-child").text()
				},
				success : function() {
					console.log("su");
					$(tr).parent().parent().remove();
				},
				error : function() {
					console.log("fail");
				}
			}); 

		}); 

	});
</script>
</head>
<body>
	<fieldset>
		<legend>게시판 내용 보기</legend>
		<table>
			<tr>
				<th>제목</th>
				<td>안녕하세요.</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>안녕하세요.</td>
			</tr>
		</table>
	</fieldset>

	<fieldset>
		<legend>댓글 쓰기</legend>
		<ul>
			<li>아이디 : <input type="text" name="id" id="id">
			<li>내용 : <textarea name="comments" id="comments"></textarea>
		</ul>
		<input type="button" value="댓글쓰기" id="write">
	</fieldset>

	<fieldset>
		<legend>댓글 내용</legend>
		<div id = "list"></div>

	</fieldset>
</body>
</html>