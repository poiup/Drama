
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

  <script type="text/javascript">
	$(document).ready(function(){
		$("#twotabsearchtextbox").on("change keyup paste", 
				function(){
					console.log(document.getElementById("twotabsearchtextbox").value);
				}
		);
	});
</script>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

      <div align="center">
      	<form action="/dramaPrj/select" method="post">
	      	
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
      
          
</body>
</html>