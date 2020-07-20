package org.comstudy21.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dao.dao;
import org.comstudy21.dto.Person;

public class ListController extends HttpServlet {
	private ArrayList<Person> pList = null;
	public ListController() throws SQLException {
		pList = dao.selectAll();
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ListController ... doget");
		
		String path = "/WEB-INF/jsp/list.jsp";
		req.setAttribute("P_list", pList);
		RequestDispatcher test = req.getRequestDispatcher(path);
		test.forward(req, resp);
	}
}
