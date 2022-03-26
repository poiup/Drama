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
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom2.css" rel="stylesheet">
    <link href="project/css/update.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${user.unick }님의 정보를 수정합니다!</h1><br/>
	<form action="/dramaPrj/loginUpdate.do" method="post">
	
    <div class="form-group">
        <label for="password">비밀번호<br/></label>
        <input type="password" class="form-control" name="fpw"
        placeholder="비밀번호" value="${user.upw }" required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">닉네임<br/></label>
        <input type="text" class="form-control" name="fnick"
       placeholder="닉네임" value="${user.unick }" required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">이름<br/></label>
        <input type="text" class="form-control" name="fname"
       placeholder="이름" value="${user.uname }" required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">나이<br/></label>
        <input type="text" class="form-control" name="fage"
       placeholder="나이" value="${user.uage }"required /><br/>
    </div>
    <br/>
   	<div class="form-group">
        <label for="text">카드번호<br/></label>
        <input type="text" class="form-control" name="fcredit"
       placeholder="카드" value="${user.ucredit }"required /><br/>
   	</div>
   	<br/>
   	<div class="form-group">
        <label for="text">주소<br/></label>
        <input type="text" class="form-control" name="fadress"
       placeholder="주소" value="${user.uadress }"required /><br/>
   	</div>
	<br/>
	<input type="hidden" name = "fid" value = "${user.uid }">
	<input type="submit" value="수정하기">
	<input type="button" value="탈퇴하기" onClick="location.href='/dramaPrj/out.do'">
	</form>
</body>
</html>





