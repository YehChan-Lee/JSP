package org.comstudy21.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Resolve {
	public boolean isRedirect = false;
	public String viewName = "";
	
	public Resolve() {}

	public Resolve(boolean isRedirect, String viewName) {
		this.isRedirect = isRedirect;
		this.viewName = viewName;
	}

	public void forward(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		if(isRedirect){
			response.sendRedirect(request.getContextPath() +"/"+ viewName);			
		}else{
			viewName = request.getAttribute("prefix") + "/" + viewName + request.getAttribute("suffix");
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		}		
	}
	
}
