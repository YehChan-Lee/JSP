package org.comstudy21;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 어노테이션 : web.xml에 servlet-mapping 생략 가능
//@WebServlet(url-pattern)
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("HelloServlet 찍고...");
//		response.sendRedirect("toHello");
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.setAttribute("message", "Hello Servlet Worlds");
		
		boolean isRedirect = new Boolean(request.getParameter("bool"));
		String path = "/toHello";
		//Dispatcher 방식 - forward : forward되는 페이지에서 리소스를 그대로 사용가능
		if(isRedirect){
			response.sendRedirect("toHello");
		}else{			
			RequestDispatcher view = request.getRequestDispatcher(path);
			view.forward(request, response);
		}
		
	}

}
