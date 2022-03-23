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
	<h1>"${sessionScope.session_uNick }"님의 선호작 리스트</h1>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>번호</th>
				<th>드라마 제목</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="favoriteList" items="${favoriteList}">
				<tr>
					<td>${favoriteList[0]}</td>
					<td><a href="#">${favoriteList[1]}</a></td>
					<td>${favoriteList[2] }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>