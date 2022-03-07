<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원 가입 페이지</h1>
	<form action="join_check.jsp" method="post">
		아이디 : <input type="text" name="fid" placeholder="아이디" required /><br/>
		비밀번호 :  <input type="password" name="fpw" placeholder="비밀번호" required /><br/>
		이름 :  <input type="text" name="fname" placeholder="이름" required /><br/>
		이메일 : <input type="email" name="femail" placeholder="이메일" required /><br/>
		<input type="submit" value="회원가입" /><input type="reset" value="초기화"/>
	</form>	
</body>
</html>


