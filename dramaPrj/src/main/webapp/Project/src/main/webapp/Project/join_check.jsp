<%@page import="kr.co.ict.UserDAO"%>
<%@page import="kr.co.ict.UserVO"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String fId = request.getParameter("fid");
	String fPw = request.getParameter("fpw");
	String fNick = request.getParameter("fnick");
	String fAge = request.getParameter("fage");
	String fCredit = request.getParameter("fcredit");
	String fAddress = request.getParameter("faddress");
	System.out.println("1. fAddress : " + fAddress);
	
	UserDAO dao = UserDAO.getInstance();
	UserVO user = dao.getUserData(fId);
	System.out.println("DB에서 받아온 정보 : " + user);

	if(user != null){
		out.println("<h1>사용중인 아이디가 있습니다. 다시 확인해주세요.</h1>");
	}else{
		dao.insertUser(fId, fPw, fNick, fAge, fCredit, fAddress);
	}
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="sign.html">로그인창으로 이동하기</a>
</body>
</html>