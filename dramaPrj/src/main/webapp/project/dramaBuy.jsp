<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="project/css/dramaBuy.css"" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
  <title>K-Drama Site</title>
  
</head>
<body>
  <div class="Pay">
    <h1>결제 페이지</h1>
     <hr/>
    <form action="/dramaPrj/dramaBuy.do" method="post">
      <input type="text" class="text" name="uname" placeholder = "${sessionScope.session_uName }" readonly>
       <span>구매자 이름 : </span>
      <br>  
      <br>
      <input type="password" class="text" name="fpw" placeholder = "${param.dname }">
      <span>구매할 드라마 제목</span>
      <br>
      <br>
      <input type = "text" class ="text" name = "ucredit" placeholder = ****-****">
      <span>유저 카드 번호 입력</span>
      <br>
      
      
      <input type ="submit" class="payin" value = "결제하기">
   
      
      <input type = "hidden" name = "unum"  value="${sessionScope.session_uNum }"><br/>
      <input type = "hidden" name = "dnum"  value="${param.dnum }"><br/>
      
      <hr>
    </form>
  
  </div>
