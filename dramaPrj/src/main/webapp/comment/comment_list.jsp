<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table class="table table-hover">
		<tr>
			<th>유저번호</th>
			<th>댓글내용</th>
			<th>평점</th>
			<th>작성일시</th>
			
		</tr>
		<c:forEach var="comt" items="${comtList }">
			<tr>
				<td>${comt.unum}</td>
				<td>${comt.comtcont}</td>
				<td>${comt.comtrate}</td>
				<td>${comt.comtdate}</td>
				<td>
					<form action="http://localhost:8181/dramaPrj/DeleteComt" method="post">
						<input type="hidden" name="comtnum" value="${comt.comtnum }">
						<input type="submit" value="삭제">
					</form>
					<form action="http://localhost:8181/dramaPrj/UpdateComtForm" method="post" >
						<input type="hidden" name="comtnum" value="${comt.comtnum }">
						<input type="submit" value="수정">
					</form>
				</td>
			</tr> 
		</c:forEach>
	</table>
	
</body>
</html>