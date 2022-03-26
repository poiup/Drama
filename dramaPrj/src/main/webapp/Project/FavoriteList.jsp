<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${favoriteList }
	<h1>선호작 리스트 입니다.</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>유저번호</th>
				<th>드라마번호</th>
				<th>선호 번호</th>
				<th>선호작 등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="favoriteList" items="${favoriteList}">
				<tr>
					<td>${favoriteList.unum }</td>
					<td><a href="#">${favoriteList.dnum }</a></td>
					<td>${favoriteList.favnum }</td>
					<td>${favoriteList.favdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>