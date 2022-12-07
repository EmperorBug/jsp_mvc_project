<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="../css/homeshopping.css" type="text/css" rel="stylesheet">
<style>
	header {
		background-color: #4C67D2;
		font-size: 30px;
		text-align: center;
		color: white;
		padding-block: 1em;
	}
	nav {
		padding-block : 1em;
		font-size: 20px;
		background-color: #6D67E4;
	}
	
	a {
		text-decoration: none;
		color: white;
		margin: 2em;
	}
	
	caption {
		font-weight:bold;
		font-size: 22px;
		margin: 20px auto;
	}
	
	section {
		width: 100vw;
		height : 70vh;
	
	}
</style>
</head>
<body>
	<header>
		쇼핑몰 회원관리 ver1.0
	</header>
	<nav>
		<a href="/joinForm.do">회원등록</a>
		<a href="/list.do">회원목록조회/수정</a>
		<a href="/salesList.do">회원매출조회</a>
		<a href="/list.do">홈으로</a>
	</nav>
</body>
</html>