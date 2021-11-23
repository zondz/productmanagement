package com.kv.controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kv.model.entity.Product;
import com.kv.model.service.ProductService;
import com.kv.model.service.implement.ProductServiceImplement;

@WebServlet("/product/search")
public class ProcessSearchProductServlet extends HttpServlet {
	private ProductService productService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> productList = productService.findByProductName(req.getParameter("keyword"));
		req.setAttribute("productlist", productList);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/product/searchproduct/SearchProduct.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImplement();
	}
}
