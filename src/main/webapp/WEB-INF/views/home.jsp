<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>SimpleBoard</title>
	<link href="/resources/layout.css" rel="stylesheet" type="text/css">
	<style type="text/css">
	*{margin:0;padding:0;}
		.container{
		width:70%;
		margin:0 auto;
		margin-top:5%;
	}
	.col{
		float:left;
		text-align: center;
	}
	.col1{
		width:8.33333%;
	}
	.col2{
		width:16.66666%;
	}
	.col3{width:25%;}
	.col4{width:33.33333%;}
	.col12{width:100%;}
	.row{
		width:100%;
		float:left;
		clear:both;
	}
	h1{
		text-align: center;
	}
	.board_container{
		margin-top:15px;
	}
	.board_row{
		height:40px;
		line-height: 40px;
	}
	.board_row_content:hover{
		background-color: gray;
	}
	#login{
		border:1px solid black;
		height:50px;
		float:right;
		line-height:50px;
		font-size:25px;
	}
	</style>
</head>
<body>

<div class='container'>
	<h1>
		간단한 게시판 프로그래밍
	</h1>
	<div id="login" class="col col2">로그인</div>
	<div class="board_container">
		<div class='row head_row'>
			<div class='col col1'>No</div>
			<div class='col col4'>TITLE</div>
			<div class='col col3'>WRITER</div>
			<div class='col col2'>DATE</div>
			<div class='col col2'>READCOUNT</div>
		</div>
		<c:forEach items="${boards}" var="board">
			<div class='row board_row board_row_content'>
				<input class='b_id' type='hidden' value="${board.b_id }">
				<div class='col col1'>${board.b_id }</div>
				<div class='col col4'>${board.b_title }</div>
				<div class='col col3'>${board.b_writer }</div>
				<div class='col col2'>${board.b_date}</div>
				<div class='col col2'>${board.b_readcount}</div>
			</div>
		</c:forEach>
	</div>
</div>

</body>
<script src="https://code.jquery.com/jquery-3.5.0.slim.min.js"
  integrity="sha256-MlusDLJIP1GRgLrOflUQtshyP0TwT/RHXsI1wWGnQhs="
  crossorigin="anonymous">
</script>
<script>
	$(".board_row").on("click",function(){
		var b_id = $(this).children(".b_id").val();
		if(b_id == null){
			return false;
		}
		location.href="detail?b_id="+b_id;
	})
</script>
</html>
