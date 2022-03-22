
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>


<link rel="stylesheet" href="project/css/searchList.css">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<head>
<meta charset="UTF-8">

<script>
function redirect(num) {
	console.log(num);
	var redirect = "/dramaPrj/dramaDetail.do?dnum="+num;
	location.href=redirect;
}
</script>


<title>Insert title here</title>
</head>
	
<body>

      <div align="center" id="searchBox">
      	<form action="/dramaPrj/dramaSearch.do" method="post">
	      	
		      <input type="text" 
		      id="twotabsearchtextbox"  
		      class="searchSelect" 
		      name="keywords" 
		      value="" size="50" 
		      title="Search for" 
		      style="width:50%; 
		      background-color: #FFF;"
		       />
		      <span>
		      	<input name="button"
		      	type="submit" >
		      </span>
		      
	      </form>
      </div>
      
      
 <div class="container" >
      <div class="row" align="center">
      
      
				<c:forEach var="search" items="${search_result}">
				
				
			        <div class="col-3" onclick="redirect('${search.dnum}');">
			          <div class="card">
			            <div class="card-header">
			              <p>${search.dname }</p> <p class="horror genre">${search.dgenre }</p>
			            </div>
			            <div class="wrap_content"  align="center">
				            <img class="thumbnail" src="Project${search.dthumb }" alt="#" />
					        <div class="card-body">
					              <p class="card-text">${search.dtext }</p>
				              
				            </div>
				      	</div>
			          </div>
			        </div>
				</c:forEach>
				
		        <div class="col-3">
		          <div class="card">
		            <div class="card-header">
		              <p>ASDF</p> <p class="horror genre">호러</p>
		            </div>
		            <div class="wrap_content"  align="center">
			            <img class="thumbnail" src="img/thumbnail/hotel_1.png" alt="#" />
				            <div class="card-body">
				              <p class="card-text">asdf</p>
			              </div>
			            </div>
		          </div>
		        </div>
      </div>
    </div>
          
</body>
</html>