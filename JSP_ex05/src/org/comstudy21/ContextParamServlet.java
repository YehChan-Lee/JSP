package org.comstudy21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/init2")
public class ContextParamServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=UTF-8");
		PrintWriter out = resp.getWriter();
		
		ServletContext context = this.getServletContext();
		
		String driver = context.getInitParameter("driver");
		String url = context.getInitParameter("url");
		String user = context.getInitParameter("user");
		String pass = context.getInitParameter("password");
		
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
