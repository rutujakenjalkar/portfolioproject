<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Details</title>
</head>
<body>
    <h1>Customer Details</h1>
    
    <c:if test="${not empty customer}">
        <p><strong>ID:</strong> ${customer.id}</p>
        <p><strong>Name:</strong> ${customer.name}</p>
        <p><strong>Email:</strong> ${customer.email}</p>
        <p><strong>Address:</strong> ${customer.address}</p>
        <p><strong>Mobile:</strong> ${customer.mobile_no}</p>
    </c:if>

   <h2>update customer details</h2>
     <p style="color:red;">Be carefull while changing the email and the password as they are the credentials</p>
   <form action="/customers/update" method="post">
        <input type="hidden" name="modelid" value="${customer.id}">

        <label for="name">Name:</label>
        <input type="text" name="name" id="name" value="${customer.name}" required><br><br>

        <label for="email">Email:</label>
        <input type="email" name="email" id="email" value="${customer.email}" required><br><br>

        <label for="address">Address:</label>
        <input type="text" name="address" id="address" value="${customer.address}" required><br><br>

        <label for="mobile_no">Mobile No:</label>
        <input type="text" name="mobile_no" id="mobile_no" value="${customer.mobile_no}" required><br><br>

        <button type="submit">Update Details</button>
    </form>
    
    <p style="color:green;">${message}</p>
 
   
</body>
</html>
