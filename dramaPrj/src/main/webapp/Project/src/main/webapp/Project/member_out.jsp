<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String sId = (String)session.getAttribute("session_id");
	
	UserDAO dao = UserDAO.getInstance();
	dao.deleteUser(sId);

	session.invalidate();
%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= sId %>님의 계정 삭제가 완료되었습니다.</h1>
	<a href="sign.html">로그인 화면으로 돌아가기</a>
</body>
</html>








