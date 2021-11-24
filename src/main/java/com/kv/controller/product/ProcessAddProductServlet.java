package com.kv.controller.product;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kv.model.entity.Product;
import com.kv.model.service.ProductService;
import com.kv.model.service.implement.ProductServiceImplement;
import com.kv.util.Helper;

@WebServlet("/product/add-product")
public class ProcessAddProductServlet extends HttpServlet {
	private ProductService productService;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		productService = new ProductServiceImplement();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Helper.validateInputFloat(req.getParameter("productprice"));
		} catch (Exception e) {
			resp.setContentType("text/html");

			PrintWriter printWriter = resp.getWriter();
			printWriter.println("<h4 style=\"text-align:center\">" + e.getMessage() + "</h3>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/AddProduct.jsp");
			dispatcher.include(req, resp);

		}

		String productName = req.getParameter("productname");
		float productPrice = Float.parseFloat(req.getParameter("productprice"));
		String productDescription = req.getParameter("productdescription");

		Product p = new Product();
		p.setName(productName);
		p.setPrice(productPrice);
		p.setDescription(productDescription);

		boolean result = productService.add(p);

		if (result) {
			HttpSession session = req.getSession(false);
			session.setAttribute("pagenumber", 0);
			resp.sendRedirect("/home/viewproduct");
		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/404.jsp");

		}

	}
}
