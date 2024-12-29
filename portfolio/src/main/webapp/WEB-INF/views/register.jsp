<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
  <h4>register here</h4>
  
  <c:if test="${not empty successmsg}">
     <h4>${successmsg}</h4>
  </c:if>
  
   <c:if test="${not empty errormsg}">
     <h4>${errormsg}</h4>
  </c:if>
  <form action="regForm" method="post">
     
     Name:<input type="text" name="name"/><br/><br/>
     Email:<input type="text" name="email"/><br/><br/>
     Address:<input type="text" name="address"/><br/><br/>
     Password:<input type="password" name="password"/><br/><br/>
     Mobile:<input type="text" name="mobile"/><br/><br/>
     
     <button>SUBMIT</button>
    
  </form>
  
    if already registered <a href="/login"><b>Click here </b></a>
  

</body>
</html>