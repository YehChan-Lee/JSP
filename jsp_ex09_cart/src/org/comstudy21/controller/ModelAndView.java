package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModelAndView {
	public boolean isRedirect = false;
	public String viewName = "";

	public ModelAndView() { }
	
	public ModelAndView(String viewName) {
		this.viewName = viewName;
	}
	
	public ModelAndView(boolean isRedirect, String viewName) {
		this.isRedirect = isRedirect;
		this.viewName = viewName;
	}
	
	public void forward(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		if(isRedirect) {
			resp.sendRedirect(req.getContextPath() + "/" + viewName);
		} else {
			viewName = (String)req.getAttribute("prefix") + "/" + viewName;
			viewName += (String)req.getAttribute("suffix");
			RequestDispatcher view = req.getRequestDispatcher(viewName);
			view.forward(req,  resp);
		}
	}
	
}
