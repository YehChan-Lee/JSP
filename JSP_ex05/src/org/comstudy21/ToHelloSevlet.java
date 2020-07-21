package org.comstudy21;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/toHello")
public class ToHelloSevlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String message = "no-message";
		if(req.getAttribute("message") != null){
			message = (String)req.getAttribute("message");
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>ToHelloServlet class</h1>");		
		out.println("<h3>this is toHello page</h3>");
		out.println("<p>" + message + "</p>");
		out.close();
	}
}
