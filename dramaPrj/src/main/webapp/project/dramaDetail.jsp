<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	* {margin: 0; padding: 0; }
	div{border : solid 1px #000;}
	.container {border:none}
	.Ddetail_img{height:300px}
	.Ddetail_img img {width : 100%; height :100%}
	.Dtitle_wrap {height : 20%}
	.Dtext_wrap{height: 80%}
	.Ddate_wrap{text-align:right}
</style>
</head>
<body>

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
				<div class="col-6"><span>${dramaDetail.dprice }</span></div>
				<!-- 아래 div에 평점을 넣어주세요. 댓글 평점의 평균을 내서 넣어주시면 됩니다. -->
				<div class="col-3"></div>
				<div class="col-1"><span>${dramaDetail.dage }</span></div>
				<div class="col-2 Ddate_wrap"><span>${dramaDetail.ddate }</span></div>
			</div>
		</div>
	</div>
	<form action="/dramaPrj/dramaUpdateForm.do" method="post">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="submit" value="수정">
	</form>
	<form action="/dramaPrj/dramaBuyForm.do" method="post">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
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
	
	세션: ${sId }<br>
	유저아이디 : ${user.uid }<br>
	comt.unum : ${comt.unum }<br>
	${dto }
	<table class="table table-hover">
		<tr>
			<th>아이디</th>
			<th>댓글내용</th>
			<th>평점</th>
			<th>작성일시</th>
			
		</tr>
		<c:forEach var="comt" items="${comtList }">
			<tr>
				<td>${comt.unum}</td>
				<td>${comt.comtcont}</td>
				<td>${comt.comtrate}</td>
				<td>${comt.comtdate}</td>
				<td>${comt.comtnum }</td>
				<td>
				<c:if test="${sId ne null }"> <!-- 로그인x면 삭제수정 불가 -->
					<c:if test="${comt.unum eq user.unum}"> <!-- 작성자만 수정 삭제 가능 -->
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