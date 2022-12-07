<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원매출조회</title>
</head>
<body>
	<jsp:include page="./include/header.jsp"/>
	<section>
		<table style="width: 50%;">
		<caption>회원매출조회</caption>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>고객등급</th>
				<th>매출</th>
			</tr>
			
			<c:forEach var="item" items="${list }">
				<tr>
					<td>${ item.custno }</td>
					<td>${ item.custname }</td>
					<td>${ item.grade }</td>
					<td>${ item.sales }</td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<jsp:include page="./include/footer.jsp"/>
</body>
</html>