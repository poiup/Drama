<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	request.setCharacterEncoding("utf-8");

	String fPw = request.getParameter("fpw");
	String fNick = request.getParameter("fnick");
	String fAge = request.getParameter("fage");
	String fCredit = request.getParameter("fcredit");
	String fAddress = request.getParameter("faddress");
	
	String sId = 
		(String)session.getAttribute("session_id");
	

	UserDAO dao = UserDAO.getInstance();
	
	dao.updateCheck(sId, fPw, fNick, fAge, fCredit, fAddress);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= sId %>님의 정보가 수정되었습니다.</h1>
	<a href="intro2.jsp">메인페이지로 돌아가기.</a>
</body>
</html>