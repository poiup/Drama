<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="project/css/drama_insert.css" rel="stylesheet"/>
<link href="css/drama_insert.css" rel="stylesheet"/>
<meta charset="UTF-8">
<title>작성페이지</title>
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
    
	<div class="container ">
		<div class="row border-bottom"  >
			<h2 class="pageTitle col-11">추가 페이지</h2>
		</div>
		<form action="/dramaPrj/dramaInsert.do" method="post">
			<div class="row g-0">
				<div class="col-8">
					<div class = "row Dtitle_wrap g-0">
						<div class= "col-6">				
							제목 : <input type="text" name="dname" placeholder="제목" value="${dramaDetail.dname }"/>
						</div>
						<div class="col-6">
							장르 : <input type="text" name="dgenre" placeholder="장르" value="${dramaDetail.dgenre }"/>
						</div>
					</div>	
					<div class = "row Dtext_wrap g-0" >
						<textarea cols="50" rows="10" name="dtext">${dramaDetail.dtext }</textarea>
					</div>	
				</div>
				<div class="col-4 Ddetail_img">
				</div> 
				 
				<div class="row">
					이미지 링크 : <input type="url" name="dthumb" placeholder="섬네일" value="${dramaDetail.dthumb }" />
					영상 링크 : <input type="url" name="dvideo" placeholder="영상" value="${dramaDetail.dvideo }"/><br/>
		
				</div>
				<div class = "row g-0 border-top" >
					<div class="col-3"><input type="number" name="dprice" placeholder="가격" value="${dramaDetail.dprice }"/></div>
					<div class="col-3"><span>배우 : <input type="text" name="actname" placeholder="주연배우" value="<c:forEach var="i" items="${actorList}">${i.actname },</c:forEach>"/>
							</span>
					</div>
					<!-- 아래 div에 평점을 넣어주세요. 댓글 평점의 평균을 내서 넣어주시면 됩니다. -->
					<div class="col-2 Dage_wrap"><span>등급: <input style="width: 90px" type="number" name="dage" placeholder="나이등급" value="${dramaDetail.dage }"/>세</span></div>
					<div class="col-4 Ddate_wrap"><span>방영일 : <input class="Ddate_input" type="date" name="ddate" placeholder="방영일" value="${dramaDetail.ddate }"/></span></div>
				</div>
			</div>
			<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
			<input type="submit" value="확인" class="ud_btn btn btn-primary">
		</form>
		
	</div>
</body>
</html>