<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>댓글 수정창</h1>
		<form action="http://localhost:8181/dramaPrj/UpdateComt.do" method="post">
		<input type="hidden" name="comtnum" value="${comtList.comtnum }">
		<input type="hidden" name="unum" value="${comtList.unum }">
		<input type="hidden" name="dnum" value="${comtList.dnum }">
		댓글:	<input type="text" name="comtcont" placeholder="${comtList.comtcont }">
		평점:	<input type="text" name="comtrate" value="${comtList.comtrate}">
			<input type="submit" value="수정">
		</form>
</body>
</html>