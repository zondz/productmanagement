<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        
<%@ page import ="com.kv.model.entity.Product"%>
<%@ page import ="com.kv.model.service.*"%>
<%@ page import ="com.kv.model.service.implement.*"%>
<%@ page import ="java.util.*"%>


    
<%

	List<Product> productList =(List<Product>) request.getAttribute("productlist");
%>
    
    
<!DOCTYPE html>
<html>
<head>
 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap 4 Search Box with Icon Example</title>
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.min.css'>
	<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css'>
      <link rel="stylesheet" href="/product/css/style.css">
	<!-- Demo CSS -->
	<link rel="stylesheet" href="/product/css/demo.css">
</head>
<style>
.my-custom-scrollbar {
position: relative;
height: 300px;
overflow: auto;
}
.table-wrapper-scroll-y {
display: block;
}
.t-head{

background-color: #54afe3;
    color: white;
}
</style>
<body>
<%@ include file="/Header.jsp" %>

  <div class="main">
  
  <!-- Another variation with a button -->
  <form action ="/product/search" method = "Post">
  <div class="input-group">
    <input name="keyword" type="text" class="form-control" placeholder="product name">
    <div class="input-group-append">
      <button class="btn btn-primary" type="submit" value="Submit">
        <i class="fa fa-search"></i>
      </button>
    </div>
  </div>
</form>

<div>
<div class="table-wrapper-scroll-y my-custom-scrollbar">
<table class="table table-bordered table-striped mb-0" >
  <thead class="t-head">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Price</th>
      <th scope="col">Description</th>
    </tr>
  </thead>
  <tbody>
  	<%
  	if(productList==null||productList.isEmpty()){	
  	%>
  
    <tr class="table-light">
   
      <td >Not found any record !!</td>
      
    </tr>
    
    <% }else {
    	for(Product p : productList){
    	
    	
     %>
    <tr>
      <th scope="row"><%=p.getId() %></th>
      <td><%= p.getName() %></td>
      <td><%= p.getPrice() %></td>
      <td><%= p.getDescription() %></td>
    </tr>
    <%}
    	} %>
    
  </tbody>
</table>
</div>
</div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
</html>