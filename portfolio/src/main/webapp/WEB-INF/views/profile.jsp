<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map" %>
<%@ page import="rutuja.project.portfolio.CustomerPortfolio" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile Page</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h4>Welcome ${modelname} </h4><!-- Display user name (optional) -->
   <h4>Customer Id: ${modelid}</h4>

   <form action="/customers/details" method="get">
          <input type="hidden" name="modelid" value="${modelid}">
        <button type="submit">View Customer Details</button>
    </form>

<!-- Display error message if any -->
    <c:if test="${not empty error}">
        <div style="color: red;">${error}</div>
    </c:if>

<h3>YOUR PORTFOLIOS:</h3>
 <form action="/profile/viewportfolios" method="post">
        <input type="hidden" name="modelid" value="${modelid}">
        <input type="hidden" name="modelname" value="${modelname}">
       <button type="submit">Get portfolios</button>
    </form>
   
     <c:if test="${not empty portfolios}">
        <h2>portfolios for Customer ID: ${modelid}</h2>
        
        

           <table>
            <thead>
                <tr>
                    <th>Portfolio ID</th>
                    <th>Ownership</th>
                    
                </tr>
            </thead>
            <%
            // Retrieve the holdings list from the request or session
            List<CustomerPortfolio> portfolios = (List<CustomerPortfolio>) request.getAttribute("portfolios");
            
            // Check if the list is not null
            if (portfolios != null) {
                for (CustomerPortfolio portfolio : portfolios) {
        %>
                    <tr>
                        <td><%= portfolio.getPortfolioId() %></td>
                        <td><%= portfolio.getOwnership() %></td>
                        
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="5">No Portfolio Avaliable</td>
                </tr>
        <%
            }
        %>
        </table>
    </c:if>

 
 <br>
 
  <a href="/portfolio"> <button> PORTFOLIO functionality </button></a>
  
   
   <br>
   <br>


    <!-- Form to Enter Portfolio ID -->
    <form action="/profile/holdings" method="post">
        <input type="hidden" name="modelname" value="${modelname}">
        <label for="portfolioId">Portfolio ID:</label>
        <input type="text" id="portfolioId" name="portfolioId"  required>
        <button type="submit">Get Holdings</button>
    </form>
    
    
    

   
    <!-- Display Holdings if Found -->
    <c:if test="${not empty holdings}">
        <h2>Holdings for Portfolio ID: ${portfolioId}</h2>
        
        

        
        <!-- Table to Display Holdings Information -->
        <table>
            <thead>
                <tr>
                    <th>Security Name</th>
                    <th>Security Price</th>
                    <th>Average Cost</th>
                    <th>Quantity</th>
                    <th>Currency</th>
                </tr>
            </thead>
            <%
            // Retrieve the holdings list from the request or session
            List<Map<String, Object>> holdings = (List<Map<String, Object>>) request.getAttribute("holdings");
            
            // Check if the list is not null
            if (holdings != null) {
                for (Map<String, Object> holding : holdings) {
        %>
                    <tr>
                        <td><%= holding.get("securityName") %></td>
                        <td><%= holding.get("securityPrice") %></td>
                        <td><%= holding.get("avgCost") %></td>
                        <td><%= holding.get("quantity") %></td>
                        <td><%= holding.get("currency") %></td>
                    </tr>
        <%
                }
            } else {
        %>
                <tr>
                    <td colspan="5">No holdings available</td>
                </tr>
        <%
            }
        %>
        </table>
    </c:if>
    <br>
     <a href="/addholdings"> <button> add holdings </button></a>
    
</body>
</html>
