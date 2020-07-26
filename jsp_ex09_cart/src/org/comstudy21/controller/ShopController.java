package org.comstudy21.controller;

import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.comstudy21.dbcp.JdbcUtil;
import org.comstudy21.model.Product;
import org.comstudy21.model.ShopDao;

public class ShopController implements Controller {
	public static ShopDao shopDao = new ShopDao();
	ArrayList<Product> pList = new ArrayList<Product>();
	ArrayList<Product> cartList =  new ArrayList<Product>();
	private HttpSession session = null;
	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		String path = mkPath(req, resp);
		String viewName = "shop/list";		
		session = req.getSession();				
		
		if ("list".equals(path)) {
			if(pList.size() == 0){
				shopDao.setConnection(JdbcUtil.getConnection());
				pList = shopDao.selectAll();
				
			}		
			req.setAttribute("pList", pList);
			viewName = "shop/list";
		} else if ("home".equals(path)) {
			viewName = "home";
		} else if ("cart".equals(path)) {
			// 장바구니 기능 - session의 List에 저장한다.			
			if (req.getParameter("idx") != null) {
				int idx = Integer.parseInt(req.getParameter("idx"));
				shopDao.setConnection(JdbcUtil.getConnection());
				Product p = shopDao.selectByIdx(new Product(idx, null, 0));				
				if (session.getAttribute("id") != null) {// 로그인을 했다는 의미이므로 해당 계정의 장바구니에 데이터 추가 DB가 없을시에는 만들어서 추가해준다.
					shopDao.setConnection(JdbcUtil.getConnection());
					shopDao.addCart((String)session.getAttribute("id"), p);
					cartList = shopDao.CartList((String)session.getAttribute("id"));
					session.setAttribute("cartList", cartList);
				} else {
					shopDao.setConnection(JdbcUtil.getConnection());
					cartList = shopDao.CartList((String)session.getAttribute("id"));
					session.setAttribute("cartList", cartList);
				}
			}else{
				shopDao.setConnection(JdbcUtil.getConnection());
				cartList = shopDao.CartList((String)session.getAttribute("id"));
				session.setAttribute("cartList", cartList);
			}
			viewName = "shop/cart";
		} else if ("cart_remove".equals(path)) {
			int idx = Integer.parseInt(req.getParameter("idx"));
			shopDao.setConnection(JdbcUtil.getConnection());
			shopDao.delete(new Product(idx, null, 0),(String)session.getAttribute("id"));
			shopDao.setConnection(JdbcUtil.getConnection());
			cartList = shopDao.CartList((String)session.getAttribute("id"));
			session.setAttribute("cartList", cartList);
			viewName = "shop/cart";
		} else if ("detail".equals(path)) {
			if (req.getParameter("idx") != null) {
				int idx = Integer.parseInt(req.getParameter("idx"));
				shopDao.setConnection(JdbcUtil.getConnection());
				Product p = shopDao.selectByIdx(new Product(idx, null, 0));
				req.setAttribute("product", p);
			}
			viewName = "shop/detail";
		}

		return new ModelAndView(viewName);
	}
}
