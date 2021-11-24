<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="com.kv.model.entity.Product"%>
<%@ page import ="com.kv.model.service.*"%>
<%@ page import ="com.kv.model.service.implement.*"%>


<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<style>
.button-submit{
margin-left: 36%

}

</style>

</head>

<%
String wrongUpdateId = request.getParameter("productid");

String id = request.getParameter("id");


//int id =Integer.parseInt(request.getParameter("id")) ;
ProductService productService = new ProductServiceImplement();
Product updateProduct  = null;
if(wrongUpdateId!=null){
	updateProduct = productService.findById(Integer.parseInt(wrongUpdateId));
	
}else{
	updateProduct= productService.findById(Integer.parseInt(id));

}

%>
<body>
<%@ include file="/Header.jsp" %>
<div class="container">
<div class="d-flex justify-content-center align-items-center container ">
 <div class="row ">

<form action="/product/update-product" method = "Post">
	<h3>Edit product form</h3>
	 <div class="form-group">
    <label for="formGroupExampleInputId">Product id</label>
    <input  name="productid" type="text" class="form-control" id="formGroupExampleInputId" readonly="readonly"  value=<%= updateProduct.getId() %>>
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput">Product name</label>
    <input  name="productname" type="text" class="form-control" id="formGroupExampleInput" value="<%=updateProduct.getName()%>">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput2">Product price</label>
    <input  name="productprice" type="text" class="form-control" id="formGroupExampleInput2" value="<%=updateProduct.getPrice()%>">
  </div>
  <div class="form-group">
    <label for="formGroupExampleInput3">Product description</label>
    <input name="productdescription" type="text" class="form-control" id="formGroupExampleInput3" value="<%=updateProduct.getDescription()%>">
  </div>
 
    <button type="submit"  value="Submit" class="btn btn-primary button-submit">Update</button>
</form>
</div>
</div>
</div>


</body>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</html>