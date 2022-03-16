<!DOCTYPE html>
<html lang="en">
<head>
   <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="ubt.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
  <title>K-Drama Site</title>
  <style>
  a:link { color: white; text-decoration: none;}
  a:visited { color: white; text-decoration: none;}
  a:hover { color: white; text-decoration: underline;}
  a { text-decoration:none }
  </style>
</head>
<body>
  <div class="wrapper">
    <div class="box">
     <li><a href="sign.jsp" style="text-decoration:none" 
          onMouseOver='this.innerHTML="로그인"' onMouseOut='this.innerHTML="Login"'>Login
      </a></li>
    </div>
  <div class="box">
     <li><a href="signup.jsp" style="text-decoration:none"
          onMouseOver='this.innerHTML="회원가입"' onMouseOut='this.innerHTML="Sign up"'>Sign up
      </a></li>
    </div>
  </div>
</body> 
</html>