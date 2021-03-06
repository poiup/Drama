<!DOCTYPE html>
<html lang="en">
<head>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="project/css/signup.css" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
  <title>K-Drama Site</title>
</head>
<body>
   <form action="/dramaPrj/signUp.do" method="POST" class="joinForm">                                                                                              
	    <h2>회원가입</h2>
	    <div class="textForm">
	      <input name="fid" type="text" class="id" placeholder="아이디">
	    </div>
	    <div class="textForm">
	      <input name="fpw" type="password" class="pw" placeholder="비밀번호">
	    </div>
	    <div class="textForm">
	      <input name="fname" type="text" class="name" placeholder="이름">
	    </div>
	    <div class="textForm">
	      <input name="fnick" type="text" class="nickname" placeholder="닉네임">
	    </div>
	     <div class="textForm">
	      <input name="fage" type="number" class="age" placeholder="나이">
	    </div>
	    <div class="textForm">
	      <input name="fcredit" type="text" class="card" placeholder="신용카드">
	    </div>
	    <div class="textForm">
	      <input name="faddress" type="text" class="addr" placeholder="주소">
	    </div>
	    <input type="submit" class="btn" value="JOIN"/>
  </form>
</body>
</body> 
</html>