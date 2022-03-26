<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
  <link href="css/intro.css" rel="stylesheet"/>
  <link href="project/css/intro.css" rel="stylesheet"/>
  <title>K-Drama Site</title>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1><a href="#">K-Drama</a></h1>
      <div class="nav">
        <ul class="user_nav">
			<!-- 로그인 -->
			<c:if test="${sessionScope.session_id ne null }">
     	    	<li><a href="/dramaPrj/dramaSearchPage.do" onMouseOver='this.innerHTML="컨텐츠"' onMouseOut='this.innerHTML="Contents"'>Contents</a></li>
          		<li><a href="/dramaPrj/FavoriteList.do" onMouseOver='this.innerHTML="선호작"' onMouseOut='this.innerHTML="Favorite"'>Favorite</a></li>
          		<li><a href="/dramaPrj/loginUpdateForm.do" onMouseOver='this.innerHTML="정보수정"' onMouseOut='this.innerHTML="Edit"'>Edit</a></li>
        	  	<li><a href="/dramaPrj/logout.do" onMouseOver='this.innerHTML="로그아웃"' onMouseOut='this.innerHTML="Log Out"'>Log Out</a></li>       
			</c:if>
			<!-- 비로그인 -->
			<c:if test="${sessionScope.session_id eq null }">
				<li><a href="/dramaPrj/dramaSearchPage.do" onMouseOver='this.innerHTML="컨텐츠"' onMouseOut='this.innerHTML="Contents"'>Contents</a></li>
				<li><a href="/dramaPrj/signUpForm.do" onMouseOver='this.innerHTML="가입"' onMouseOut='this.innerHTML="Join"'>Join</a></li>
	          	<li><a href="/dramaPrj/sign.do" onMouseOver='this.innerHTML="로그인"' onMouseOut='this.innerHTML="Login"'>Login</a></li>
        	</c:if>
        </ul>
    </div>
  </div>
  
  <div class="hero">
    <h2>Get ready for watching<br>K-Drama?</h2>
    <p>This site is famous for Korean dramas.<br>
        It's a place where you can see it.<br>
        It is also a place where you can conversation<br>
        with many people through Korean dramas.</p>
    <button><h3>Let's Go!</h3></button>
  </div>
  </div>
</body> 
</html>