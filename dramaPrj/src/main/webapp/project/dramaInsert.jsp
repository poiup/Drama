<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dramaPrj/dramaInsert" method="post">
		<input type="text" name="dname" placeholder="제목" /><br/>
		<input type="number" name="dprice" placeholder="가격" /><br/>
		<input type="text" name="dgenre" placeholder="장르" /><br/>
		<input type="date" name="ddate" placeholder="방영일" /><br/>
		<input type="number" name="dage" placeholder="나이등급" /><br/>
		<input type="file" name="dthumb" placeholder="섬네일" /><br/>
		<input type="file" name="dvideo" placeholder="영상" /><br/>
		<input type="text" name="actname" placeholder="주연배우" /><br/>
		<textarea cols="50" rows="10" name="dtext"></textarea><br/>
		<input type="submit" value="확인">
	</form>
</body>
</html>