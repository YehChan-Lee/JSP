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

import org.comstudy21.dao.dao;
import org.comstudy21.dto.Person;

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
		
		context.log(">>>> "+ path);
		
		String prefix = "/WEB-INF/jsp/";
		String suffix = ".jsp";
		String viewName = "form"; 
		boolean isRedirect = false;
		
		switch(path){
		case "/list":
			viewName = "list";
			break;
		case "/list/input":
			viewName = "form";
			break;
		}
		req.setAttribute("P_list", pList);
		if(isRedirect){
			resp.sendRedirect(ctxPath + "/" + viewName);
		}else{
			viewName = prefix + viewName +suffix;
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req, resp);
		}
			
	}
}
