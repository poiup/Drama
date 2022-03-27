<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    
	<div class="container ">
		
		<div class="row g-0 border-top">
			<div class="col-4 Ddetail_img">

				<img alt="테스트 이미지" src="${dramaDetail.dthumb }">
			</div> 
			<div class="col-8">
				<div class = "row Dtitle_wrap g-0">
					<div class= "col-9">				
						<h2 class="drama_title">${dramaDetail.dname }</h2>
					</div>
					<div class="col-3"><p class="drama_genre">장르:${dramaDetail.dgenre }</p></div>
				</div>	
				<div class = "row Dtext_wrap g-0" >
					<p>${dramaDetail.dtext }</p>
				</div>	
			</div> 
			<div class = "row g-0 border-top" >
				<div class="col-3"><span>가격 : ${dramaDetail.dprice }원</span></div>
				<div class="col-3"><span>배우 : 
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
		<!-- 로그인이 안되어있으면 선호작 등록 불가 -->
		<div class="clear">
			<c:if test = "${sessionScope.session_uNum eq 1 }">
				<div class="edit_btn">
				<form action="/dramaPrj/dramaUpdateForm.do" method="post" >
					<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
					<input type="submit" value="수정" style="padding:10px">
				</form>
				</div>
			</c:if>
			<c:if test="${sessionScope.session_id ne null }">
				<div  class="favorit_btn">
			<!-- 선호작 선택 안되있을시 -->
				<c:if test="${favoriteDetail.dnum ne dramaDetail.dnum}">
					<form action="/dramaPrj/dramaFavorite.do" method = "post" >
						<input type="hidden" value="${sessionScope.session_uNum }" name = "unum">
						<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
						<input type="hidden" value = "${dramaDetail.dname }" name = "dname">
						<input type="submit" value="♡" style="padding:10px">
					</form>
				</c:if>
			<!-- 선호작 선택 됬을시 -->
				<c:if test = "${favoriteDetail.dnum eq dramaDetail.dnum }">
					<form action="/dramaPrj/dramaFavDelete.do" method = "post">
						<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
						<input type="hidden" value="${favoriteDetail.favnum }" name = "favnum">
						<input type="submit" value="♥" style="padding:10px">
					</form>
				</c:if>
				</div>
			</c:if>
			
			<div class="buy_btn">
				<form action="/dramaPrj/dramaBuyForm.do" method="post" >
					<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
					<input type="hidden" value = "${dramaDetail.dname }" name = "dname">
					<input type="submit" value="구매" style="padding:10px;border:none; width: 150px; font-weight: bold; color:#fff; background-color: #FF5500;">
				</form>
			</div>
		</div>
	</div>
	
	<div class="container ">
	<c:if test="${sId ne null }"> <!-- 로그인x 댓글작성 불가 -->
		<form action="http://localhost:8181/dramaPrj/InsertComt.do" method="post" class="input-group">
			<input type="hidden" name="unum" placeholder="유저넘버" value="${sessionScope.session_uNum}">
			<input type="hidden" name="dnum" placeholder="드라마넘버" value="${dramaDetail.dnum }">
			<textarea cols="50" name ="comtcont" aria-label="With textarea" class="input-group-text comt_text_box">댓글을 적어주세요</textarea>
			<input type="number" name="comtrate" placeholder="평점" class="comt_rate" required>
			<input class="comt_submit" type="submit" value="작성" >
		</form>
	</c:if>
	<table class="table table-hover">
		<tr>
			<th class="col-2">닉네임</th>
			<th class="col-6">댓글내용</th>
			<th class="col-1">평점</th>
			<th class="col-3" colspan="2">작성일시</th>
			
		</tr>
		
		<c:forEach var="comt" items="${comtDataList }">
			<tr> 
			 	<td class="col-2">${comt.unick }</td>
				<td class="col-6">${comt.comtcont}</td>
				<td class="col-1">${comt.comtrate}</td>
				<td class="col-2">${comt.comtdate}</td>
				<td class="col-1">
				<c:if test="${sId ne null }"> <!-- 로그인x면 삭제수정 불가 -->
					<c:if test="${comt.unum eq sessionScope.session_uNum}"> <!-- 작성자만 수정 삭제 가능 -->
						<form action="http://localhost:8181/dramaPrj/DeleteComt.do" method="post" class="comt_del_btn">
							<input type="hidden" name="comtnum" value="${comt.comtnum }">
							<input type="hidden" name="dnum" value="${comt.dnum }">
							<input type="submit" value="삭제">
						</form>
						<form action="http://localhost:8181/dramaPrj/UpdateComtForm.do" method="post" class="comt_ud_btn">
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
	</div>

</body>
</html>