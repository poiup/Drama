<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
				<div class="col-6"><span>가격 : ${dramaDetail.dprice }원</span></div>
				<!-- 아래 div에 평점을 넣어주세요. 댓글 평점의 평균을 내서 넣어주시면 됩니다. -->
				<div class="col-3"></div>
				<div class="col-1"><span>등급: ${dramaDetail.dage }세</span></div>
				<div class="col-2 Ddate_wrap"><span>방영일 : ${dramaDetail.ddate }</span></div>
			</div>
		</div>
	</div>
	<form action="/dramaPrj/dramaFavorite.do" method = "post">
		${sessionScope.session_uAge }
		${dramaDetail.dnum }<br/>
		${dramaDetail.dname }<br/>
		<input type="hidden" value="${sessionScope.session_uNum }" name = "unum">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="hidden" value = "${dramaDetail.dname }" name = "dname">
		<input type="submit" value="선호작 등록">
	</form>
	<form action="/dramaPrj/dramaUpdateForm.do" method="post">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="submit" value="수정">
	</form>
	<form action="/dramaPrj/dramaBuyForm.do" method="post">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="hidden" value = "${dramaDetail.dname }" name = "dname">
		<input type="submit" value="구매">
	</form>
	<form action="/dramaPrj/commentForm.do" method="post">
		<input type="hidden" value="${dramaDetail.dnum }" name = "dnum">
		<input type="submit" value="댓글보기">
	</form>
</body>
</html>