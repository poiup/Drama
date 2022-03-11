<!DOCTYPE html>
<html lang="en">
<head>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="Project/intro.css" rel="stylesheet"/>
  <link href="intro.css" rel="stylesheet"/>
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
  <title>K-Drama Site</title>
</head>
<body>
  <div class="container">
    <div class="header">
      <h1><a href="#">K-Drama</a></h1>
      <div class="nav">
       <ul>
        	<td><input type="text" class="form-control" style='text-align:center'
			placeholder="Search" name="searchText" maxlength="100" ></td>
			<td><button type="submit" class="btn btn-success">Search</button></td>
			
          <li><a href="#" onMouseOver='this.innerHTML="컨텐츠"' onMouseOut='this.innerHTML="Contents"'>Contents</a></li>
          <li><a href="#" onMouseOver='this.innerHTML="선호작"' onMouseOut='this.innerHTML="Favorite"'>Favorite</a></li>
         <li><a href="http://localhost:8181/Project/Project/login_update.jsp" onMouseOver='this.innerHTML="정보수정"' onMouseOut='this.innerHTML="Edit"'>Edit</a></li>
          <li><a href="http://localhost:8181/Project/Project/intro.jsp" onMouseOver='this.innerHTML="로그아웃"' onMouseOut='this.innerHTML="Log Out"'>Log Out</a></li>
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