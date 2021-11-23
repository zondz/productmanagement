<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
<%@ page import ="com.kv.model.entity.Product"%>
<%@ page import = "com.kv.util.Helper" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Bootstrap CRUD Data Table for Database with Modal Form</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/product/css/ViewProduct.css">
<script src="/product/js/ViewProductJS.js"></script>

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="/Header.jsp" %>
<%
// get data
List<Product> allProducts =(List<Product>) request.getAttribute("products");
List<List<Product>> pages =  Helper.getPages(allProducts, 5);
if(session.getAttribute("pagenumber")==null){
	System.out.println(session.getAttribute("pagenumber"));
	session.setAttribute("pagenumber", 0);
}

System.out.println("Request page number : "+session.getAttribute("pagenumber"));

%>
<div class="container-xl">
	<div class="table-responsive">
		<div class="table-wrapper">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>View <b>Product</b></h2>
					</div>
					
				</div>
			</div>
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>id</th>
						<th>name</th>
						<th>price</th>
						<th>description</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
				<% 
				int pageNo = (int)session.getAttribute("pagenumber");
				
				List<Product> products = pages.get(pageNo);
				
				for(Product p : products) { %>
					<tr>	
						<td><%= p.getId() %></td>
						<td><%= p.getName() %></td>
						<td><%= p.getPrice() %></td>
						<td><%= p.getDescription() %></td>
						<td>
							<a href="/product/UpdateProduct.jsp?id=<%=p.getId() %>"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
						</td>	
						<td>
       					 <form id="my_form_<%=p.getId() %>" method="post" action="/product/delete-product">
       					 <input hidden  name="productid" value=<%= p.getId() %>>
           				 <a href="javascript:{}" onclick="document.getElementById('my_form_<%=p.getId() %>').submit();"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
      				 	 </form>
 
						</td>
					</tr>
					<%} %>
				</tbody>
			</table>
			<div class="clearfix">
				<div class="hint-text">Showing <b><%=products.size() %></b> out of <b><%= allProducts.size() %></b> entries</div>
				<ul class="pagination">
					<% for (int i = 0 ; i < pages.size();i++ ) {%>
					<li class="page-item">
					<a class="page-link" href='/viewpage?pagenumber=<%=i%>'><%=i+1%></a>
				
					</li>
					<%} %>
				</ul>
			</div>
		</div>
	</div>        
</div>

</body>
</html>