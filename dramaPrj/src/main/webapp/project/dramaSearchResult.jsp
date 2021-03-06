<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.drama.dramainfoDAO"%>
<%@page import="kr.co.drama.dramainfoVO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
  

<link rel="stylesheet" href="./project/css/searchList.css">
<link rel="stylesheet" href="css/searchList.css">

<head>
<meta charset="UTF-8">

<%
	String search_type = request.getParameter("keywords");
	if(search_type == null || search_type.equals(null)){
		search_type = "";
	}
%>

<script>
function redirect(num) {
	location.href="/dramaPrj/dramaDetail.do?dnum="+num;
}
</script>



<title>Insert title here</title>
</head>
	
<body>

	<div class="header">
	      <h1><a href="/dramaPrj/main.do">K-Drama</a></h1>
	      <div class="nav">
	        <ul class="user_nav">
				<!-- 로그인 -->
				<c:if test="${sessionScope.session_id ne null }">
	     	    	<li><a href="/dramaPrj/dramaSearchPage.do" onMouseOver='this.innerHTML="컨텐츠"' onMouseOut='this.innerHTML="Contents"'>Contents</a></li>
	          		<li><a href="/dramaPrj/FavoriteList.do" onMouseOver='this.innerHTML="선호작"' onMouseOut='this.innerHTML="Favorite"'>Favorite</a></li>
	          		<li><a href="/dramaPrj/dramaBuyList.do" onMouseOver='this.innerHTML="구매내역"' onMouseOut='this.innerHTML="BuyList"'>BuyList</a></li>
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

      <div align="center" id="searchBox">
      	<form action="/dramaPrj/dramaSearch.do" method="post">
	      	  <select name="search_type">
					<option value="dname">제목</option>
					<option value="actor">배우</option>
					<option value="dgenre">장르</option>
				</select>
		      <span>
		      <input type="text" 
		      id="twotabsearchtextbox"  
		      class="searchSelect" 
		      name="keywords" 
		      value="<%=search_type %>" size="50" 
		      title="Search for" 
		      style="width:50%; 
		      background-color: #FFF;"
		      
		       />
		      </span>
		      <span>
		      	<input name="button"
		      	type="submit" >
		      </span>
		      
	      </form>
      </div>
      
      
 <div class="container">
      <div class="row"  align="center" >
      
      <c:if test="${empty search_result || search_result.size() == 0}">

			          <div class="card" style="margin-top:50px">
			            <div class="card-header">
			              <p>검색결과가 없습니다</p> 
			            </div>
			          </div>
      </c:if>
      
    
      	
				<c:forEach var="search" items="${search_result}">
				
				
			        <div class="col-3 searchList" onclick="redirect('${search.dnum}');">
			          <div class="card">
			            <div class="card-header">
			              <p>${search.dname }</p> <p class="horror genre">${search.dgenre }</p>
			            </div>
			            <div class="wrap_content"  align="center">
				            <img class="thumbnail" src="${search.dthumb }" alt="#" />
					        <div class="card-body">
					              <p class="card-text">${search.dtext }</p>
				              
				            </div>
				      	</div>
			          </div>
			        </div>
				</c:forEach>
				
      </div>
      <c:if test = "${sessionScope.session_uNum eq 1 }">
      	<button type="button" class="btn btn-secondary drama_add"><a href="/dramaPrj/dramaInsertForm.do">드라마 추가</a></button>
   	 </c:if>
   	</div>

</body>
</html>