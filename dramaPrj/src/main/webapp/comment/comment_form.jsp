<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="http://localhost:8181/dramaPrj/InsertComt" method="post">
		<input type="text" name="unum" placeholder="유저넘버">
		<input type="text" name="dnum" placeholder="드라마넘버">
		<input type="text" name="comtcont" placeholder="댓글">
		<input type="text" name="comtrate" placeholder="평점">
		<input type="submit" value="작성">
	</form>
</body>
</html>