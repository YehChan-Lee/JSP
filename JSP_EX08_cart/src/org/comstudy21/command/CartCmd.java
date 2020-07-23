package org.comstudy21.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.comstudy21.dbcp.JdbcUtil;
import org.comstudy21.model.Dto;

public class CartCmd implements Command {

	@Override
	public Resolve Action(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("담기") == null && request.getParameter("number") == null){
			dao.setConnection(JdbcUtil.getConnection());
			ArrayList<Dto> list = dao.loadCart();
			request.setAttribute("CARTLIST", list);
			return new Resolve(false,"cart");
		}		
		if(request.getParameter("number") != null){
			dao.setConnection(JdbcUtil.getConnection());
			int number = Integer.parseInt((String)request.getParameter("number"));			
			dao.cartDelete(number);
			dao.setConnection(JdbcUtil.getConnection());
			ArrayList<Dto> list = dao.loadCart();
			request.setAttribute("CARTLIST", list);
			return new Resolve(false,"cart");
		}		
		HttpSession session = request.getSession();
		Dto dto = (Dto)session.getAttribute("cart.dto");
		dao.setConnection(JdbcUtil.getConnection());
		dao.addcart(dto);		
		ArrayList<Dto> list = dao.loadCart();
		request.setAttribute("CARTLIST", list);
		return new Resolve(false,"cart");
	}

}
