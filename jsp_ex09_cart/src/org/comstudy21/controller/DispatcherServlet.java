package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HandlerMapping ctrHandlerlMap = new HandlerMapping();
	private ServletContext context = null;
	
	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = (String)req.getAttribute("path");
		context = getServletContext();
		path = path.substring(0, path.indexOf("/"));//shop인지 bbs인지 구별하기 위해 잘라준다.
		context.log("DispatcherServlet>>>>>>> path : " + path);
		
		Controller ctrl = ctrHandlerlMap.getController(path);//잘린 path를 기반으로 그에 맞는 컨트롤러로 연결해준다.
		ModelAndView view = ctrl.service(req, resp);
		view.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}
}
