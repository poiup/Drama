<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>결제 페이지</h1>
	<form action = "/dramaPrj/dramaBuy.do" method = "post">
		유저번호 : <input type = "text" name = "unum" placeholder = "유저번호" value="${sessionScope.session_uNum }">
		드라마번호 : <input type = "text" name = "dnum" placeholder = "드라마 번호" value="${param.dnum }">
		유저 카드 번호 : <input type = "text" name = "ucredit" placeholder = ****-****">
		<input type = "submit" value = "결제하기">
	</form>
</body>
</html>