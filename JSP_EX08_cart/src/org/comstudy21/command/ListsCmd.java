package org.comstudy21.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dbcp.JdbcUtil;
import org.comstudy21.model.Dto;

public class ListsCmd implements Command {

	@Override
	public Resolve Action(HttpServletRequest request, HttpServletResponse response) {
		dao.setConnection(JdbcUtil.getConnection());
		ArrayList<Dto> list = dao.selectAll();
		request.setAttribute("LIST", list);		
		
		return new Resolve(false,"list");
	}

}
