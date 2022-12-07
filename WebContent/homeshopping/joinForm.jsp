<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>홈쇼핑 회원 등록</title>
 <style type="text/css">
 	td:not(:first-child) {
	text-align: left;
}
 </style>
</head>
<body>
<jsp:include page="./include/header.jsp"/>
	<section>
		<form id="joinForm" action="join.do" method="post" onsubmit="return valchk();">
			<table style="width: 50%;">
			<caption>홈쇼핑 회원 등록</caption>
				<tr>
					<td width="45%">회원번호(자동발생)</td>
					<td width="55%"><input type="text" readonly name="custno" value="${custno }">
				</tr>
				<tr>
					<td>회원성명</td>
					<td><input type="text" name="custname" maxlength="20"></td>
				</tr>
				<tr>
					<td>회원전화</td>
					<td><input type="text" name="phone" maxlength="20" placeholder="000-0000-0000" style="width: 60%;"></td>
				</tr>
				<tr>
					<td>회원주소</td>
					<td><input type="text" name="address" maxlength="60" style="width: 70%;"></td>
				</tr>
				<tr>
					<td>가입일자</td>
					<td><input type="text" name="joindate" maxlength="8" placeholder="yyyymmdd"></td>
				</tr>
				<tr>
					<td>고객등급()A:VIP,B:일반,C:직원)</td>
					<td><input type="text" name="grade" maxlength="1" placeholder="A,B,C"></td>
				</tr>
				<tr>
					<td>도시코드</td>
					<td><input type="text" name="city" maxlength="2" placeholder="00"></td>
				</tr>
				<tr>
					<td colspan="2">
						<button>등록</button>
						<button type="button" onclick="location.href='${pageContext.request.contextPath}/list.do'">조회</button>
					</td>
				</tr>
			</table>
		</form>
	</section>
	<jsp:include page="./include/footer.jsp"/>
	<script type="text/javascript">
		function valchk() {
			const form = document.getElementById('joinForm');
			const dateregx = /(19[0-9]{2}|20[0-9]{2})(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])/;
			const phoneregx = /^\d{3}-\d{3,4}-\d{4}$/;
			const graderegx = /^[A,B,C]$/;
			const cityregx	= /^\d{2}%/;
			
			if (form.custname.value == '' ) {
				alert('회원성명이 입력되지않았습니다.');
				form.custname.focus();
				return false;
			}
			if (form.phone.value == '' ) {
				alert('회원전화가 입력되지않았습니다.');
				form.phone.focus();
				return false;
			}
			if (!phoneregx.test(form.phone.value)) {
				alert('회원전화 형식을 지켜주세요');
				form.phone.focus();
				return false;
			}
			if (form.address.value == '' ) {
				alert('회원주소가 입력되지않았습니다.');
				form.address.focus();
				return false;
			}
			if (form.joindate.value == '' ) {
				alert('가입일자가 입력되지않았습니다.');
				form.joindate.focus();
				return false;
			}
			if (!dateregx.test(form.joindate.value)) {
				alert('날짜형식을 지켜주세요');
				form.joindate.focus();
				return false;
			}
			if (form.grade.value == '' ) {
				alert('고객등급이 입력되지않았습니다.');
				form.grade.focus();
				return false;
			}
			if (!graderegx.test(form.grade.value)) {
				alert('고객등급형식을 지켜주세요');
				form.grade.focus();
				return false;
			}
			if (form.city.value == '' ) {
				alert('도시코드가 입력되지않았습니다.');
				form.city.focus();
				return false;
			}
			if (!cityregx.test(form.city.value)) {
				alert('도시코드형식을 지켜주세요');
				form.city.focus();
				return false;
			}
			alert('회원등록 완료 되었습니다!');
		}
	</script>
</body>
</html>