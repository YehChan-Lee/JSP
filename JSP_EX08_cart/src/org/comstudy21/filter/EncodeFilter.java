package org.comstudy21.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import sun.misc.ObjectInputFilter.Config;

public class EncodeFilter implements Filter {
	ServletContext context;
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		
		//request filter
		context.log("request filter");		
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		req.setAttribute("prefix", "/WEB-INF/views");
		req.setAttribute("suffix", ".jsp");
		String ctxPath = request.getContextPath();
		String reqURI = request.getRequestURI();
		int beginIdx = ctxPath.length()+1;
		int endIdx = reqURI.lastIndexOf(".");
		String path = reqURI.substring(beginIdx,endIdx);
		req.setAttribute("path", path);
		
		chain.doFilter(req, resp);
		//response filter
		context.log("response filter");
		
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		context = config.getServletContext();

	}
//	@Override
//	public boolean test(){
//		return null;
//	}

}
