<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
//if(sId == null){
	// 로그인 안 한 사람이 해당 주소를 얻어서 접속한 경우
	//response.sendRedirect("sign.jsp");
//}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sId }님의 정보를 수정합니다!</h1><br/>
	<form action="update_check.jsp" method="post">
	
    <div class="form-group">
        <label for="password">비밀번호<br/></label>
        <input type="password" class="form-control" name="fpw" value="${user.upw }" placeholder="비밀번호"  required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">닉네임<br/></label>
        <input type="text" class="form-control" name="fnick"
       placeholder="닉네임" required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">이름<br/></label>
        <input type="text" class="form-control" name="fname"
       placeholder="이름" required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">나이<br/></label>
        <input type="text" class="form-control" name="fage"
       placeholder="나이" required /><br/>
    </div>
    <br/>
   	<div class="form-group">
        <label for="text">카드<br/></label>
        <input type="text" class="form-control" name="fcredit"
       placeholder="카드" required /><br/>
   	</div>
   	<br/>
   	<div class="form-group">
        <label for="text">주소<br/></label>
        <input type="text" class="form-control" name="faddress"
       placeholder="주소" required /><br/>
   	</div>
	<br/>
	<input type="submit" value="수정하기">
	<input type="button" value="탈퇴하기" onClick="location.href='http://localhost:8181/Project/Project/out.jsp'">
	</form>
</body>
</html>





