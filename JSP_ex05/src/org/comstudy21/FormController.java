package org.comstudy21;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.comstudy21.model.Dao;

public class FormController extends HttpServlet {
	// Dao dao = new Dao();
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
		// String age = req.getParameter("age");
		String interests[] = req.getParameterValues("interest");

		// dao.addInfo(userId,passwd,age);
		System.out.println(">>> user id : " + userId);
		System.out.println(">>> user passwd : " + passwd);
		// System.out.println(">>> user age : " + age);
//		for (int i = 0; i < interests.length; i++) {
//			System.out.println(">>> " + i + " : " + interests[i]);
//		}
		Enumeration<String> enu = req.getParameterNames();
		while (enu.hasMoreElements()) {
			String paramName = (String) enu.nextElement();
			if (req.getParameterValues(paramName).length == 1) {
				String value = req.getParameter(paramName);
				System.out.println(paramName + " : " + value);
			} else {
				String[] arr = req.getParameterValues(paramName);
				for (int i = 0; i < arr.length; i++) {
					System.out.println(">>> " + i + " : " + arr[i]);
				}
			}

		}

		// 작업후에 index.html로 돌아간다.
		resp.sendRedirect("index.html");

	}
}
