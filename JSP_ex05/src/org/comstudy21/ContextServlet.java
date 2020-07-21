package org.comstudy21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.BufferUnderflowException;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { "/file" }, 
		initParams = { 
				@WebInitParam(name = "file_url", value = "/WEB-INF/file.txt")
		})
public class ContextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		ServletContext context = getServletContext();
		String fileURL = context.getInitParameter("file_url");
		
		InputStream is = context.getResourceAsStream("/WEB-INF/file.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		
		String driver = null;
		String url = null;
		String user = null;
		String pass = null;
		
		String str = null;
		while((str = br.readLine())!=null){
			StringTokenizer tk = new StringTokenizer(str,"&");
			driver = tk.nextToken();
			url = tk.nextToken();
			user = tk.nextToken();
			pass = tk.nextToken();
		}
		
		context.setAttribute("hello", "World");
		context.log(">>>log : " + driver + ", " + context.getAttribute("hello"));
		
		PrintWriter out = response.getWriter();
		out.println(driver+"<br>" + url+"<br>"+ user+"<br>" + pass);
		out.close();
	}

}
