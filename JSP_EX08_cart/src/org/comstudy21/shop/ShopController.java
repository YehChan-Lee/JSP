package org.comstudy21.shop;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.command.CartCmd;
import org.comstudy21.command.Command;
import org.comstudy21.command.DetailCmd;
import org.comstudy21.command.ListsCmd;
import org.comstudy21.command.Resolve;


@WebServlet("*.do")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Hashtable<String, Command>cmdMap = new Hashtable<String,Command>();
	
	public ShopController (){
		cmdMap.put("list", new ListsCmd());
		cmdMap.put("cart", new CartCmd());
		cmdMap.put("detail", new DetailCmd());
	}
    
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getMethod();
		System.out.println("process - "+ method);
		
		PrintWriter out = response.getWriter();
		
		String path = (String)request.getAttribute("path");
		path = path.substring("car/".length());
		
		System.out.println(">>>>"+path);
		
		if("GET".equals(method)){
			Command cmd = cmdMap.get(path);
			Resolve res = cmd.Action(request, response);			
			res.forward(request,response);
		}else if("POST".equals(method)){
			System.out.println("POST로 요청");
			out.println("<p>POST으로 요청" + request.getAttribute("path") + "</p>");
			String carName = request.getParameter("name");
			out.println("차종 : " + carName);
			
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

}
