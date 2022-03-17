<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body {background-image : url('https://m.skbroadband.com/common/img/vin/btv/btv_visual05.png');
	   background-repeat: no-repeat;
	   background-position: center center;
	   background-size: 600px 500px;
	   color : white;}
</style>
</head>
<body>
	<table align="center" border="1">
<form>
    <h2 align="center">Drama Update</h2>
    <tr><td>제목</td><td><input type="text" name="dname" placeholder="제목" value="${dramaDetail.dname }"/><br/></td></tr>
    <tr><td>가격</td><td><input type="text" name="dprice" placeholder="가격" value="${dramaDetail.dprice }"/><br/></td></tr>
    <tr><td>장르</td><td><input type="text" name="dgenre" placeholder="장르" value="${dramaDetail.dgenre }"/><br/></td></tr>
    <tr><td>방영일</td><td><input type="date" name="ddate" placeholder="방영일" value="${dramaDetail.ddate }"/><br/></td></tr>
    <tr><td>나이등급</td><td><input type="number" name="dage" placeholder="나이등급" value="${dramaDetail.dage }"/><br/></td></tr>
    <tr><td>섬네일</td><td><input type="url" name="dthumb" placeholder="섬네일" value="${dramaDetail.dthumb }" /><br/></td></tr>
    <tr><td>영상</td><td><input type="url" name="dvideo" placeholder="영상" value="${dramaDetail.dvideo }"/><br/></td></tr>
    <tr><td>주연배우</td><td><input type="text" name="actname" placeholder="주연배우" value="<c:forEach var="i" items="${actorList}">${i.actname },</c:forEach>"/><br/></td></tr>
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