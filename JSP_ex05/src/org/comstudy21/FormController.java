package org.comstudy21;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Path = "/WEB-INF/jsp/form.jsp";
		RequestDispatcher view = req.getRequestDispatcher(Path);
		view.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		System.out.println(">>>>doPost - FormController");
		String userId = req.getParameter("id");
		String passwd = req.getParameter("password");
		String interests[] = req.getParameterValues("interest");
		
		System.out.println(">>> user id : " + userId);
		System.out.println(">>> user passwd : " + passwd);
		for(int i=0;i<interests.length;i++){
			System.out.println(">>> "+ i + " : " + interests[i]);
		}
		//작업후에 index.html로 돌아간다.
		resp.sendRedirect("index.html");
	}
}
