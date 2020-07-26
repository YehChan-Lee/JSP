package org.comstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	ModelAndView service(HttpServletRequest req, HttpServletResponse resp);
	
	default String mkPath(HttpServletRequest req, HttpServletResponse resp){
		String path = (String)req.getAttribute("path");
		path = path.substring(path.lastIndexOf("/")+1);
		System.out.println(path);
		
		return path;
	}
	
	
}
