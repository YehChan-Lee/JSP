package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("homecontroller ... doget");
		
		String path = "/WEB-INF/jsp/home.jsp";
		RequestDispatcher test = req.getRequestDispatcher(path);
		test.forward(req, resp);
	}
}
