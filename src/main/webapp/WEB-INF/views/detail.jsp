<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	.col10{width:83.33333%;}
	.col12{width:100%;}
	.row{
		width:100%;
		float:left;
		clear:both;
	}
	.title{
		height:40px;
	}
	.board{
		border:1px solid black;
		float:left;
		width:100%;
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
<title>상세보기</title>
</head>
<body>
	<div class="container">
		<div class="board">
			<div class="row title">
				<div class="col col12">${board.b_title}</div>
			</div>
			<div class="row">
				<div class="col_right">
					<div class="col col2">${board.b_writer}</div>
					<div class="col col2">작성일 : ${board.b_date}</div>
				</div>
			</div>
			<div class="row content_block">
				<div class="col col12">${board.b_content }</div>
			</div>
		</div>
	</div>
</body>
</html>