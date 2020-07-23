package org.comstudy21.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dbcp.JdbcUtil;
import org.comstudy21.model.Dto;

public class DetailCmd implements Command {

	@Override
	public Resolve Action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		int no = Integer.parseInt((String)request.getParameter("no"));
		System.out.println("no >>>>> " + no);
		dao.setConnection(JdbcUtil.getConnection());
		Dto dto = dao.selectOne(no);
		
		request.setAttribute("DTO", dto);	
		return new Resolve(false,"detail");
	}

}
