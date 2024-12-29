<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Create Portfolio</title>
</head>
<body>
    <h1>Create Portfolio</h1>

     <c:if test="${not empty result}">
        <p style="color: green;">${result}</p>
    </c:if>
    
    <form action="${pageContext.request.contextPath}/portfolio/create" method="post">
        <label>Customer ID:</label>
        <input type="text" name="customerId" required><br>
        
        <label>PORTFOLIO id:</label>
        <input type="text" name="portfolioId" required><br>
        

        <label>Ownership:</label>
        <input type="number" name="owner_ship" required><br>
        
         <label>PORTFOLIO NAME:</label>
        <input type="text" name="pname" required><br>
        
        

        <button type="submit">Create Portfolio</button>
    </form>
    
    <h1>DELETE Portfolio</h1>
    <h4>ENTER the portfolio Id you want to delete </h4>
   
     <c:if test="${not empty resultMessage}">
        <p style="color: green;">${resultMessage}</p>
    </c:if>
    
    <form action="${pageContext.request.contextPath}/portfolio/delete" method="post">
     <label>PORTFOLIO id:</label>
        <input type="text" name="portfolioId" required><br>
         <button type="submit">Delete Portfolio</button>
    </form>
    <a href="/profile"> <b> go back to home page </b></a>
    
</body>
</html>
