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
	<!--  이상하게 name을 불러오면 nick이 표시되고 nick을 불러오면 name이 표시됩니다........
	그리구 유저번호 대신 유저 나이를 불러옵니다... 왜그럴까요..? -->
		구매자 이름 : <input type = "text" name = "uname" placeholder = "${sessionScope.session_uName }" readonly><br/>
		구매할 드라마 제목 : <input type = "text" name = "dname" placeholder = "${param.dname }" readonly><br/>
		유저 카드 번호 입력 : <input type = "text" name = "ucredit" placeholder = ****-****"><br/>
		<input type = "submit" value = "결제하기"><br/>
		<input type = "hidden" name = "unum"  value="${sessionScope.session_uNum }"><br/>
		<input type = "hidden" name = "dnum"  value="${param.dnum }"><br/>
	</form>
</body>
</html>