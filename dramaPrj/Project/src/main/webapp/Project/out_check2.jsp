<%@page import="kr.co.ict.UserVO"%>
<%@page import="kr.co.ict.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	String fId = request.getParameter("fid");
	String fPw = request.getParameter("fpw");
	System.out.println("폼에서 날린 아이디 : " + fId);
	System.out.println("폼에서 날린 비밀번호 : " + fPw);
	
	UserDAO dao = UserDAO.getInstance();
		
		UserVO user = dao.getUserData(fId);
		System.out.println("DB에서 받아온 정보 : " + user);
		
		if(user != null){
			
			String uId = user.getuId();// hint * getter
			String uPw = user.getuPw();
			System.out.println("DB내 유저 아이디 : " + uId);
			System.out.println("DB내 유저 비밀번호 : " + uPw);
			
			if(fId.equals(uId) && fPw.equals(uPw)){
			
				session.setAttribute("session_id", uId);
				session.setAttribute("session_pw", uPw);
				
				response.sendRedirect("member_out.jsp");	
			} else {
				out.println("<h1>비밀번호가 틀렸습니다. 다시 확인해주세요.</h1>");
			}
			
		} else {
			out.println("<h2>아이디가 없습니다. <br> 입력 아이디 또는 비밀번호를 확인해주세요.</h2>");
		}
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>