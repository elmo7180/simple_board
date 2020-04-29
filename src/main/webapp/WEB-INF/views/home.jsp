<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>SimpleBoard</title>
	<style>
	*{margin:0;padding:0;}
	.container{
		width:90%;
		margin:0 auto;
	}
	.board_container{
		margin-top:15px;
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
	</style>
</head>
<body>

<div class='container'>
	<h1>
		간단한 게시판 프로그래밍
	</h1>
	<div class="board_container">
		<div class='row'>
			<div class='col col1'>No</div>
			<div class='col col4'>TITLE</div>
			<div class='col col3'>WRITER</div>
			<div class='col col2'>DATE</div>
			<div class='col col2'>READCOUNT</div>
		</div>
		<c:forEach items="boards" var="board">
			<div class='row'>
				<div class='col col1'>${board.b_id }</div>
				<div class='col col4'>${board.b_title }</div>
				<div class='col col3'>${board.b_writer }</div>
				<div class='col col2'>${board.b_date}</div>
				<div class='col col2'>${board.b_readcount }</div>
			</div>
		</c:forEach>
	</div>
</div>

</body>
</html>
