<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="kr.co.drama.dramainfoDAO"%>
<%@page import="kr.co.drama.dramainfoVO"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">


<link rel="stylesheet" href="/css/searchList.css">
<link rel="stylesheet" href="project/css/searchList.css">
 
<script>
function redirect(num) {
	location.href="/dramaPrj/dramaDetail.do?dnum="+num;
}
</script>
 
<%
	dramainfoDAO dao = dramainfoDAO.getInstance();
	List<dramainfoVO> dvo = dao.SelectAllDrama();
	
	
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>


<body>

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
		      value="" size="50" 
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
      
      
 <div class="container" >
      <div class="row" align="center">
      
      	
				<%for(dramainfoVO vo : dvo) {%>
				
				
			        <div class="col-3 searchList" onclick="redirect('<%=vo.getDnum() %>');">
			          <div class="card">
			            <div class="card-header">
			              <p><%=vo.getDname() %></p> <p class="horror genre"><%=vo.getDgenre() %></p>
			            </div>
			            <div class="wrap_content"  align="center">
				            <img class="thumbnail" src="<%=vo.getDthumb() %>" alt="#" />
					        <div class="card-body">
					              <p class="card-text"><%=vo.getDtext() %></p>
				              
				            </div>
				      	</div>
			          </div>
			        </div>
      		<%} %>
				
      </div>
   	 </div>
       
</body>
</html>