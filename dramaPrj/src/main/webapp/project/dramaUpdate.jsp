<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/dramaPrj/dramaUpdateActive" method="post">
		<input type="text" name="dname" placeholder="제목" value="${dramaDetail.dname }"/><br/>
		<input type="number" name="dprice" placeholder="가격" value="${dramaDetail.dprice }"/><br/>
		<input type="text" name="dgenre" placeholder="장르" value="${dramaDetail.dgenre }"/><br/>
		<input type="date" name="ddate" placeholder="방영일" value="${dramaDetail.ddate }"/><br/>
		<input type="number" name="dage" placeholder="나이등급" value="${dramaDetail.dage }"/><br/>
		<input type="file" name="dthumb" placeholder="섬네일" value="${dramaDetail.dthumb }" /><br/>
		<input type="file" name="dvideo" placeholder="영상" value="${dramaDetail.dvideo }"/><br/>
		<input type="text" name="actname" placeholder="주연배우" value="<c:forEach var="i" items="${actorList}">${i.actname },</c:forEach>"/><br/>
		<textarea cols="50" rows="10" name="dtext">${dramaDetail.dtext }</textarea><br/>
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="submit" value="확인">
	</form>
	<form action="/dramaPrj/dramaDelete" method="post">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="submit" value="삭제">
	</form>
</body>
</html>