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

@WebServlet("/product/update-product")
public class ProcessUpdateProductServlet extends HttpServlet {
	private ProductService productService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			Helper.validateInputFloat(req.getParameter("productprice"));
		} catch (Exception e) {
			resp.setContentType("text/html");
			PrintWriter printWriter = resp.getWriter();
			printWriter.println("<h4 style=\"text-align:center\">" + e.getMessage() + "</h4>");

			RequestDispatcher dispatcher = req.getRequestDispatcher("/product/UpdateProduct.jsp");

			dispatcher.include(req, resp);

			return;
		}

		int id = Integer.parseInt(req.getParameter("productid"));
		String updateName = req.getParameter("productname");
		float updatePrice = Float.parseFloat(req.getParameter("productprice"));
		String description = req.getParameter("productdescription");

		Product p = new Product();
		p.setId(id);
		p.setName(updateName);
		p.setPrice(updatePrice);
		p.setDescription(description);
		boolean result = productService.update(p);
		if (result) {
			HttpSession session = req.getSession(false);
			session.setAttribute("pagenumber", 0);
			resp.sendRedirect("/home/viewproduct");

		} else {
			RequestDispatcher dispatcher = req.getRequestDispatcher("404.jsp");
			dispatcher.forward(req, resp);

		}
	}

	@Override
	public void init() throws ServletException {
		productService = new ProductServiceImplement();
	}
}
