<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://fonts.googleapis.com/css2?family=Do+Hyeon&family=Dokdo&family=Nanum+Myeongjo:wght@400;700&family=Song+Myung&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="project/css/dramaDetail.css" rel="stylesheet"/>
</head>
<body>
	<div class="hearder_wrap">
		<div class="header">
			<nav class="navbar navbar-dark bg-dark">
				<h1 class="logo"><a href="/dramaPrj/main.do">K-Drama</a></h1>
		  		<ul class="user_nav">
			        <form class="SerchForm" action="/dramaPrj/dramaSearch.do" method="post" style="display : inline">
				        <td><input type="text" placeholder="검색어 입력" name="keywords" maxlength="100" style='text-align:center'></td>
						<td><button type="submit" class="btn btn-outline-dark">검색</button></td>
					</form>
						<!-- 로그인 -->
					<c:if test="${sessionScope.session_id ne null }">
			          	<li><a href="/dramaPrj/dramaSearchPage.do" onMouseOver='this.innerHTML="컨텐츠"' onMouseOut='this.innerHTML="Contents"'>Contents</a></li>
			          	<li><a href="#" onMouseOver='this.innerHTML="선호작"' onMouseOut='this.innerHTML="Favorite"'>Favorite</a></li>
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
			</nav>
	    </div>
    </div>
    
	<div class="container ">
		<div class="row g-0">
			<div class="col-4 Ddetail_img">

				<img alt="테스트 이미지" src="${dramaDetail.dthumb }">
			</div> 
			<div class="col-8">
				<div class = "row Dtitle_wrap g-0">
					<div class= "col-9">				
						<h2 class="drama_title">${dramaDetail.dname }</h2>
					</div>
					<div class="col-3"><p class="drama_genre">${dramaDetail.dgenre }</p></div>
				</div>	
				<div class = "row Dtext_wrap g-0" >
					<p>${dramaDetail.dtext }</p>
				</div>	
			</div> 
			<div class = "row g-0">
				<div class="col-3"><span>가격 : ${dramaDetail.dprice }원</span></div>
				<div class="col-3"><span>
					 <c:forEach var="name" items="${actorList }">
						${name.actname },					 
					 </c:forEach>
					</span>
				</div>
				<!-- 아래 div에 평점을 넣어주세요. 댓글 평점의 평균을 내서 넣어주시면 됩니다. -->
				<div class="col-3"></div>
				<div class="col-1"><span>등급: ${dramaDetail.dage }세</span></div>
				<div class="col-2 Ddate_wrap"><span>방영일 : ${dramaDetail.ddate }</span></div>
			</div>
		</div>
	</div>
	
	<!-- 로그인이 안되어있으면 선호작 등록 불가 -->
	<c:if test="${sessionScope.session_id ne null }">
	<!-- 선호작 선택 안되있을시 -->
		<c:if test="${favoriteDetail.dnum ne dramaDetail.dnum}">
			<form action="/dramaPrj/dramaFavorite.do" method = "post">
				<input type="hidden" value="${sessionScope.session_uNum }" name = "unum">
				<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
				<input type="hidden" value = "${dramaDetail.dname }" name = "dname">
				<input type="submit" value="(선호작등록)">
			</form>
		</c:if>
	<!-- 선호작 선택 됬을시 -->
		<c:if test = "${favoriteDetail.dnum eq dramaDetail.dnum }">
			<form action="/dramaPrj/dramaFavDelete.do" method = "post">
				<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
				<input type="hidden" value="${favoriteDetail.favnum }" name = "favnum">
				<input type="submit" value="(선호작취소)">
			</form>
		</c:if>
	</c:if>
	<c:if test = "${sessionScope.session_uNum eq 1 }">
		<form action="/dramaPrj/dramaUpdateForm.do" method="post">
			<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
			<input type="submit" value="수정">
		</form>
	</c:if>
	<form action="/dramaPrj/dramaBuyForm.do" method="post">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="hidden" value = "${dramaDetail.dname }" name = "dname">
		<input type="submit" value="구매">
	</form>
	
	<c:if test="${sId ne null }"> <!-- 로그인x 댓글작성 불가 -->
		<form action="http://localhost:8181/dramaPrj/InsertComt.do" method="post">
			<input type="hidden" name="unum" placeholder="유저넘버" value="${user.unum}">
			<input type="hidden" name="dnum" placeholder="드라마넘버" value="${dramaDetail.dnum }">
			<input type="text" name="comtcont" placeholder="댓글">
			<input type="text" name="comtrate" placeholder="평점">
			<input type="submit" value="작성">
		</form>
	</c:if>
	<table class="table table-hover">
		<tr>
			<th>닉네임</th>
			<th>댓글내용</th>
			<th>평점</th>
			<th>작성일시</th>
			
		</tr>
		
		<c:forEach var="comt" items="${comtDataList }">
			<tr> 
			 	<td>${comt.unick }</td>
				<td>${comt.comtcont}</td>
				<td>${comt.comtrate}</td>
				<td>${comt.comtdate}</td>
				<c:if test="${sId ne null }"> <!-- 로그인x면 삭제수정 불가 -->
					<c:if test="${comt.unum eq sessionScope.session_uNum}"> <!-- 작성자만 수정 삭제 가능 -->
						<form action="http://localhost:8181/dramaPrj/DeleteComt.do" method="post">
							<input type="hidden" name="comtnum" value="${comt.comtnum }">
							<input type="hidden" name="dnum" value="${comt.dnum }">
							<input type="submit" value="삭제">
						</form>
						<form action="http://localhost:8181/dramaPrj/UpdateComtForm.do" method="post" >
							<input type="hidden" name="comtnum" value="${comt.comtnum }">
							<input type="submit" value="수정">
						</form>
					</c:if>
				</c:if>
				</td>
			</tr> 
		</c:forEach>
	</table>
	
	<!-- 댓글 넘기기 버튼 -->
	<nav aria-label="...">
	  <ul class="pagination pagination-sm justify-content-center">	
	    		<li class="page-item ${dto.startPage eq 1 ? 'disabled' : '' }">
	    			<a class="page-link" href="http://localhost:8181/dramaPrj/dramaDetail.do?dnum=${dramaDetail.dnum }&pageNum=${dto.startPage - 1}">&laquo;</a>
	    		</li>	
	    	<c:forEach var="pageIndex" begin="${dto.startPage }" end="${dto.endPage }">
	    		<li class="page-item ${dto.currentPage eq pageIndex ? 'active' : ''} ">
	    			<a class="page-link" href="http://localhost:8181/dramaPrj/dramaDetail.do?dnum=${dramaDetail.dnum }&pageNum=${pageIndex}">${pageIndex }</a>
	    		</li>
	  		</c:forEach>
			    <li class="page-item ${dto.totalPages eq dto.endPage ? 'disabled' : ''}">
			    	<a class="page-link" href="http://localhost:8181/dramaPrj/dramaDetail.do?dnum=${dramaDetail.dnum }&pageNum=${dto.endPage + 1}">&raquo;</a>
			    </li>
	  </ul>
	</nav>
	

</body>
</html>