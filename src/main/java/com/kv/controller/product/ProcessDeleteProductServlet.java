package com.kv.controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kv.model.service.ProductService;
import com.kv.model.service.implement.ProductServiceImplement;

@WebServlet("/product/delete-product")
public class ProcessDeleteProductServlet extends HttpServlet {
	private ProductService productService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("productid"));
		boolean result = productService.deleteById(id);

		if (result) {
			HttpSession session = req.getSession(false);
			session.setAttribute("pagenumber", null);
			resp.sendRedirect("/home/viewproduct");

		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("404.jsp");
			dispatcher.forward(req, resp);

		}

	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		productService = new ProductServiceImplement();
	}

}
