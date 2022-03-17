<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성페이지</title>
<style type="text/css">
	body {background-image : url('https://m.skbroadband.com/common/img/vin/btv/btv_visual05.png');
	   background-repeat: no-repeat;
	   background-position: center center;
	   background-size: 600px 550px;
	   color : white;}
	
</style>
</head>
<body>
	<table align="center" border="1">
<form>
    <h2 align="center">Drama Insert</h2>
    <tr><td>제목</td><td><input type="text" name="dname" placeholder="제목" /><br/></td></tr>
    <tr><td>가격</td><td><input type="text" name="dprice" placeholder="가격" /><br/></td></tr>
    <tr><td>장르</td><td><input type="text" name="dgenre" placeholder="장르" /><br/></td></tr>
    <tr><td>방영일</td><td><input type="date" name="ddate" placeholder="방영일" /><br/></td></tr>
    <tr><td>나이등급</td><td><input type="number" name="dage" placeholder="나이등급" /><br/></td></tr>
    <tr><td>섬네일</td><td><input type="url" name="dthumb" placeholder="섬네일" /><br/></td></tr>
    <tr><td>영상주소</td><td><input type="url" name="dvideo" placeholder="영상주소" /><br/></td></tr>
    <tr><td>주연배우</td><td><input type="text" name="actname" placeholder="주연배우" /><br/></td></tr>
    <tr><td>줄거리</td><td><textarea cols="70" rows="10" style="overflow-y: scroll;"></textarea></td></tr> 
</form>
</table>
<table align="center">
    <tr><td>
    <input type="submit" value="확인">
    </td></tr>
</table>
</body>
</html>