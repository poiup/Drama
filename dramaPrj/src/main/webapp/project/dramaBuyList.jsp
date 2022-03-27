<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet"> 
  <link href="project/css/FavoriteList.css" rel="stylesheet"/>
  <link href="project/css/header_navbar.css" rel="stylesheet"/>
  
  <title>K-Drama Site</title>
</head>


<body>
<div class="header_wrap">
		<div class="header">
			<nav class="navbar navbar-dark bg-dark">
				<h1 class="logo"><a href="/dramaPrj/main.do">K-Drama</a></h1>
		  		<ul class="user_nav">
						<!-- 로그인 -->
					<c:if test="${sessionScope.session_id ne null }">
			          	<li><a href="/dramaPrj/dramaSearchPage.do" onMouseOver='this.innerHTML="컨텐츠"' onMouseOut='this.innerHTML="Contents"'>Contents</a></li>
			          	<li><a href="/dramaPrj/FavoriteList.do" onMouseOver='this.innerHTML="선호작"' onMouseOut='this.innerHTML="Favorite"'>Favorite</a></li>
			          	<li><a href="/dramaPrj/dramaBuyList.do" onMouseOver='this.innerHTML="구매내역"' onMouseOut='this.innerHTML="BuyList"'>BuyList</a></li>
			          	<li><a href="/dramaPrj/loginUpdateForm.do" onMouseOver='this.innerHTML="계정정보"' onMouseOut='this.innerHTML="Edit"'>Edit</a></li>
			        	  <li><a href="/dramaPrj/logout.do" onMouseOver='this.innerHTML="로그아웃"' onMouseOut='this.innerHTML="Log Out"'>Log Out</a></li>       
					</c:if>
						<!-- 비로그인 -->
					<c:if test="${sessionScope.session_id eq null }">
			     	    <li><a href="/dramaPrj/dramaSearchPage.do" onMouseOver='this.innerHTML="컨텐츠"' onMouseOut='this.innerHTML="Contents"'>Contents</a></li>
						<li><a href="/dramaPrj/signUpForm.do" onMouseOver='this.innerHTML="가입"' onMouseOut='this.innerHTML="Join"'>Join</a></li>
				        <li><a href="/dramaPrj/sign.do" onMouseOver='this.innerHTML="로그인"' onMouseOut='this.innerHTML="Login"'>Login</a></li>
			        </c:if>
	        	</ul>
			</nav>
	    </div>
    </div>
    
  <div class="Pay">
    <h3>"${sessionScope.session_uNick }"님의 구매리스트</h1>
     <hr/>

   <table class="table table-dark table-hover">
      <thead>
         <tr>
            <th>번호</th>
            <th>드라마 제목</th>
            <th>등록일</th>
         </tr>
      </thead>
      <tbody>
         <c:forEach var="buyList" items="${buyList}">
            <tr>
               <td>${buyList[0]}</td>
               <td>${buyList[1]}</a></td>
               <td>${buyList[2] }</td>
            </tr>
         </c:forEach>
      </tbody>
   </table>   
  </div>
</body>
</html>



