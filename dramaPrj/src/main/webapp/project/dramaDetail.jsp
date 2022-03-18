<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<<<<<< HEAD
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
=======
>>>>>>> 5f44e06d875b37d018fecb020352509425a9e24f
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
    <h2 align="center">Drama Detail</h2>
    <tr><td>섬네일</td><td> <input type="image" src="${dramaDetail.dthumb }" alt="테스트이미지"><br/></td></tr>
    <tr><td>제목</td><td><input type="text" name="dname" value="${dramaDetail.dname }"/><br/></td></tr>
    <tr><td>장르</td><td><input type="text" name="drama_genre" value="${dramaDetail.dgenre }"/><br/></td></tr>
    <tr><td>가격</td><td><input type="text" name="dprice" value="${dramaDetail.dprice }"/><br/></td></tr>
    <tr><td>나이등급</td><td><input type="number" name="dage"  value="${dramaDetail.dage }"/><br/></td></tr>
    <tr><td>방영일</td><td><input type="date" name="ddate" value="${dramaDetail.ddate }"/><br/></td></tr>
    <tr><td>줄거리</td><td><textarea cols="70" rows="10" style="overflow-y: scroll;"></textarea></td></tr> 
</form>
</table>
<table align="center">
    <tr><td>
        <form action="/dramaPrj/dramaDelete.do" method="post"></form>
        <tr><td>
    <input type="submit" value="확인">
    </td></tr>
</table>
</body>
</html>