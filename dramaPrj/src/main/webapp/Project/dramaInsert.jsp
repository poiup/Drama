<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성페이지</title>
</head>
<body>
	<form action="/dramaPrj/dramaInsert.do" method="post">
		<input type="text" name="dname" placeholder="제목" /><br/>
		<input type="number" name="dprice" placeholder="가격" /><br/>
		<input type="text" name="dgenre" placeholder="장르" /><br/>
		<input type="date" name="ddate" placeholder="방영일" /><br/>
		<input type="number" name="dage" placeholder="나이등급" /><br/>
		<input type="url" name="dthumb" placeholder="섬네일" /><br/>
		<input type="url" name="dvideo" placeholder="영상주소" /><br/>
		<input type="text" name="actname" placeholder="주연배우" /><br/>
		<textarea cols="50" rows="10" name="dtext"></textarea><br/>
		<input type="submit" value="확인">
	</form>
</body>
</html>