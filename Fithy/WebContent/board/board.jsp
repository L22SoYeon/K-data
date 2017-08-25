<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/board.css">
<script src="../js/jquery-3.2.1.js"></script>
<script>
$("#write").click(function(){
	$.ajax({
		url : "../writecomments.kdata",
		data : {"id":$("#id").val(),"comments":$("#comments").val(),"num":1},
		dataType : "json",
		success : function(data){
			var str = "<table>";
			$.each(data,function(index,item){
				console.log(item.id);
				str=str+"<tr>";
				str=str+"<td>"+item.commentNum+"</td>";
				str=str+"<td>"+item.id+"</td>";
				str=str+"<td>"+item.contents+"</td>";
				str=str+"<td><input type ='button' value='x' id='delete' com='"+item.commentNum+"'></td>";
				str=str+"</tr>";
			});
			str = str + "</table>";
			$("#list").html(str);
		});
	});
})
</script>

</head>
<body>
	<!-- --------------------------------------글 쓰기 -->
	<div>
		<fieldset>
			<legend>글 쓰기</legend>
			<ul>
				<li>아이디 : <input type="text" name="id" id="id"> <li>내용 : <textarea name="comments" id="comments"></textarea>
			
			</ul>
		</fieldset>
	</div>
	
	
	<div class="container-fluid">
		<div class="panel panel-success">
			<div class="panel-heading">
				<div class="row">
					<div class="col-xs-12 col-sm-12 col-md-3">
						<h2 class="text-center pull-left" style="padding-left: 30px;">
							<span class="glyphicon glyphicon-list-alt"> </span> Community
						</h2>
					</div>
					<div class="col-xs-9 col-sm-9 col-md-9">
						<div class="col-xs-12 col-sm-12 col-md-12">
							<div class="col-xs-12 col-md-4">
								<label> Search </label>
								<div class="form-group">
									<div class="input-group">
										<input type="text" class="form-control input-md" name="search">
										<div class="input-group-btn">
											<button type="button" class="btn btn-md btn-warning">
												<span class=" glyphicon glyphicon-search"></span>
											</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="panel-body table-responsive">
				<table class="table table-hover">
					<thead>
						<tr>
							<th class="text-center">No.</th>
							<th class="text-center">Title</th>
							<th class="text-center">Name</th>
							<th class="text-center">Date</th>

						</tr>
					</thead>

					<tbody>
						<tr class="edit" id="detail">
							<td id="no" class="text-center">1</td>
							<td id="name" class="text-center">ABC</td>
							<td id="mobile" class="text-center">5412547854</td>
							<td id="mail" class="text-center">abc@gmail.com</td>

						</tr>

						<tr>
							<td class="text-center">2</td>
							<td class="text-center">DFG</td>
							<td class="text-center">4025478965</td>
							<td class="text-center">dfg@gmail.com</td>

						</tr>

						<tr>
							<td class="text-center">3</td>
							<td class="text-center">XYZ</td>
							<td class="text-center">4102369745</td>
							<td class="text-center">xyz@gmail.com</td>

						</tr>

						<tr>
							<td class="text-center">4</td>
							<td class="text-center">JKL</td>
							<td class="text-center">2536541028</td>
							<td class="text-center">jkl@gmail.com</td>
							<td class="text-center">California</td>
						</tr>

						<tr>
							<td class="text-center">5</td>
							<td class="text-center">DFG</td>
							<td class="text-center">4025478965</td>
							<td class="text-center">dfg@gmail.com</td>

						</tr>
					</tbody>
				</table>
			</div>

			<div class="panel-footer">
				<div class="row">
					<div class="col-lg-12">
						<div class="col-md-8"></div>
						<div class="col-md-4">
							<p class="muted pull-right">
								<strong> © 2017 All rights reserved </strong>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
</script> <script
						src="../js/board.js"></script>

				</body>
</html>