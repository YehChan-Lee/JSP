package org.comstudy21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InitParamServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		String driver = getInitParameter("driver");
		String url = getInitParameter("url");
		String user = getInitParameter("user");
		String pass = getInitParameter("password");
		
		out.println("<html><body>");
		out.println("<table border=1><tr>");
		out.println("<td>" + driver + "</td>");
		out.println("<td>" + url + "</td>");
		out.println("<td>" + user + "</td>");
		out.println("<td>" + pass + "</td>");
		out.println("</tr></table");
		out.println("</body></html>");
		
		out.close();
	}
}
