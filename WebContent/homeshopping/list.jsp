<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원목록조회/수정</title>

</head>
<body>
	<jsp:include page="./include/header.jsp"/>
	<section>
		<table>
		<caption>회원목록조회/수정</caption>
			<tr>
				<th>회원번호</th>
				<th>회원성명</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>가입일자</th>
				<th>고객등급</th>
				<th>거주지역</th>
			</tr>
			
			<c:forEach var="item" items="${list }">
				<tr>
					<td><a href="/modifyForm.do?custno=${item.custno }">${ item.custno }</a></td>
					<td>${ item.custname }</td>
					<td>${ item.phone }</td>
					<td>${ item.address }</td>
					<td>${ item.joindate }</td>
					<c:choose>
						<c:when test="${item.grade == 'A' }">
							<td>VIP</td>
						</c:when>
						<c:when test="${item.grade == 'B' }">
							<td>일반</td>
						</c:when>
						<c:when test="${item.grade == 'C' }">
							<td>직원</td>
						</c:when>
					</c:choose>
					<td>${ item.city }</td>
				</tr>
			</c:forEach>
		</table>
	</section>
	<jsp:include page="./include/footer.jsp"/>
</body>
</html>