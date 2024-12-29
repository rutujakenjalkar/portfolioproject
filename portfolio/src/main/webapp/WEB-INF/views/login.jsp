<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h4>Login here</h4>
  
  
  <c:if test="${not empty errormsg}">
     <h4>${errormsg}</h4>
  </c:if>
  <form action="loginForm" method="post">
     
    
     Email:<input type="text" name="email"/><br/><br/>
     Password:<input type="password" name="password"/><br/><br/>
     <button>SUBMIT</button>
     
     
    
  </form><br><br>
    
    if not registered <a href="/register"><b>Click here </b></a>


</body>
</html>