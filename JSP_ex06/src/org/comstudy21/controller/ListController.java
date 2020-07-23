package org.comstudy21.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.model.Person;
import org.comstudy21.model.dao;

@WebServlet("/list/*")
public class ListController extends HttpServlet {
	private ArrayList<Person> pList = null;
	String ctxPath = null;
	ServletContext context;

	public ListController() throws SQLException {
		pList = dao.selectAll();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ListController ... doget");
		context = getServletContext();
		String reqUri = req.getRequestURI();
		ctxPath = req.getContextPath();
		int beginIndex = ctxPath.length();
		String path = reqUri.substring(beginIndex);

		context.log("ctxPath >>> " + ctxPath);
		context.log(">>>> " + path);

		String prefix = "/WEB-INF/views/";
		String suffix = ".jsp";
		String viewName = "form";
		boolean isRedirect = false;

		switch (path) {
		case "/list":
			viewName = "list";
			req.setAttribute("P_list", pList);
			break;
		case "/list/input":
			viewName = "form";
			if (req.getParameter("input") != null) {
				String name = req.getParameter("name");
				String addr = req.getParameter("addr");
				int age = Integer.parseInt(req.getParameter("age"));
				try {
					dao.insert(new Person(name, addr, age));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			break;
		}		
		if (isRedirect) {
			resp.sendRedirect(ctxPath + "/" + viewName);
		} else {
			viewName = prefix + viewName + suffix;
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}

	}
}
