package com.kv.controller.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kv.model.entity.User;
import com.kv.model.service.UserService;
import com.kv.model.service.implement.UserServiceImplement;

@WebFilter(urlPatterns = { "/home" })
public class LoginFilter implements Filter {
	private UserService userService;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("In login filter");

		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;

		HttpSession session = servletRequest.getSession(false);
		String username = servletRequest.getParameter("username");
		String password = servletRequest.getParameter("password");

		String name = (String) servletRequest.getAttribute("name");
		if (name != null) {
			RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/Home.jsp");
			dispatcher.forward(servletRequest, servletResponse);
			return;
		}

		// kiem tra session xem no tu y an vao link
		if (session == null) {
			PrintWriter printWriter = servletResponse.getWriter();
			printWriter.println("<p align=center>Vui long dang nhap<p>");
			servletResponse.setContentType("text/html");
			RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/login/Login.jsp");
			dispatcher.include(servletRequest, servletResponse);
			return;
		}
		// khong dang nhap ,lay session de co tinh vao link home
		if (username == null && password == null) {
			PrintWriter printWriter = servletResponse.getWriter();
			printWriter.println("<p align=center>Vui long dang nhap<p>");
			servletResponse.setContentType("text/html");
			RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/login/Login.jsp");
			dispatcher.include(servletRequest, servletResponse);
			return;
		}

		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user = userService.checkLogin(user);
		if (user != null) {
			session.setAttribute("name", user.getUserName());
			RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/Home.jsp");
			dispatcher.forward(servletRequest, servletResponse);
		} else {
			servletResponse.setContentType("text/html");
			RequestDispatcher dispatcher = servletRequest.getRequestDispatcher("/login/Login.jsp");

			PrintWriter printWriter = servletResponse.getWriter();
			printWriter.println("<p align=center>Wrong Username or password !<p>");
			dispatcher.include(servletRequest, servletResponse);

		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		userService = new UserServiceImplement();
		System.out.println("In init");

	}

}
