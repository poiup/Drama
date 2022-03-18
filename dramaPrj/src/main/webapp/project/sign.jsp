<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${SessionScope.session_id ne null }">
	<%response.sendRedirect("/dramaPrj/main.do");%>
</c:if>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="project/css/sign.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
  <title>K-Drama Site</title>
</head>
<body>
  <div class="login">
    <form action="/dramaPrj/login.do" method="post">
      <input type="text" class="text" name="fid">
       <span>userid</span>
      <br>  
      <br>
      <input type="password" class="text" name="fpw">
      <span>password</span>
      <br>
      <input type="checkbox" id="checkbox-1-1" class="custom-checkbox" />
      <label for="checkbox-1-1">Keep me Signed in</label>
      <button class="signin">
        Sign In
      </button>
      <hr>
      <a href="#">Forgot Password?</a>
    </form>
  
  </div>
</body> 
</html>