<%@page import="kr.co.ict.UserVO"%>
<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String sId = (String)session.getAttribute("session_id");
	if(sId == null){
		// 로그인 안 한 사람이 해당 주소를 얻어서 접속한 경우
		response.sendRedirect("sign.jsp");
	}
	
	UserDAO dao = UserDAO.getInstance();

	UserVO user = dao.getUserData(sId);
%>
<!DOCTYPE html>
<html>
<head>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/custom2.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1><%=sId %>님의 정보를 수정합니다!</h1><br/>
	<form action="update_check.jsp" method="post">
	
    <div class="form-group">
        <label for="password">비밀번호<br/></label>
        <input type="password" class="form-control" name="fpw"
        placeholder="비밀번호" value="<%= user.getuPw() %>" required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">닉네임<br/></label>
        <input type="text" class="form-control" name="fnick"
       placeholder="닉네임" value="<%= user.getuNick() %>"required /><br/>
    </div>
    <br/>
    <div class="form-group">
        <label for="text">닉네임<br/></label>
        <input type="text" class="form-control" name="fage"
       placeholder="나이" value="<%= user.getuAge() %>"required /><br/>
    </div>
    <br/>
   	<div class="form-group">
        <label for="text">카드<br/></label>
        <input type="text" class="form-control" name="fcredit"
       placeholder="카드" value="<%= user.getUcredit() %>"required /><br/>
   	</div>
   	<br/>
   	<div class="form-group">
        <label for="text">주소<br/></label>
        <input type="text" class="form-control" name="faddress"
       placeholder="주소" value="<%= user.getuAddress() %>"required /><br/>
   	</div>
	<br/>
	<input type="submit" value="수정하기">
	<input type="button" value="탈퇴하기" onClick="location.href='http://localhost:8181/Project/Project/out.jsp'">
	</form>
</body>
</html>





