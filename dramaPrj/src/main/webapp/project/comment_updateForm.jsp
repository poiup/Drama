<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom2.css" rel="stylesheet">
	<link href="project/css/updateForm.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>댓글 수정창</h1>
		<form action="http://localhost:8181/dramaPrj/UpdateComt.do" method="post">
			<input type="hidden" name="comtnum" value="${comtList.comtnum }">
			<input type="hidden" name="unum" value="${comtList.unum }">
			<input type="hidden" name="dnum" value="${comtList.dnum }">
	<div class="form-group">		
		<label for="text">댓글<br/></label>
			<textarea  cols="50" name ="comtcont" placeholder="${comtList.comtcont }" required></textarea>		
	</div>	
	<div class="form-group">	
		<label for="text">평점<br/></label>
			<input  type="number" class="form-control" name="comtrate" placeholder="${comtList.comtrate}" required>
	</div>
			<input type="submit" value="수정">
		</form>
</body>
</html>