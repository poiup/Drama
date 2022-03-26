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
  
  <title>K-Drama Site</title>
</head>


<body>
	${favoriteList }
  <div class="Pay">
    <h3>"${sessionScope.session_uNick }"님의 선호작 리스트</h1>
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
         <c:forEach var="favoriteList" items="${favoriteList}">
            <tr>
               <td>${favoriteList[0]}</td>
               <td>${favoriteList[1]}</a></td>
               <td>${favoriteList[2] }</td>
            </tr>
         </c:forEach>
      </tbody>
   </table>   
  </div>
</body>
</html>



