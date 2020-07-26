package org.comstudy21.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.comstudy21.dbcp.JdbcUtil;

public class LoginController implements Controller {

	@Override
	public ModelAndView service(HttpServletRequest req, HttpServletResponse resp) {
		String path = mkPath(req, resp);
		String viewName = "login/loginHome";
		HttpSession session =  req.getSession();

		if ("check".equals(path)) {
			String id = (String) req.getParameter("id");
			String pw = (String) req.getParameter("pw");
			System.out.println(id + pw);
			ShopController.shopDao.setConnection(JdbcUtil.getConnection());
			if (ShopController.shopDao.checkAccount(id, pw)) {
				session.setAttribute("id", id);
				return new ModelAndView(true, "shop/home");
			} else {
				viewName = "login/loginHome";
			}
		} else if ("loginHome".equals(path)) {
			viewName = "login/loginHome";
		} else if ("signin".equals(path)) {
			viewName = "login/signin";
		}else if ("sign".equals(path)) {
			String id = (String)req.getParameter("id");
			String pw = (String)req.getParameter("pw");
			ShopController.shopDao.setConnection(JdbcUtil.getConnection());
			ShopController.shopDao.addAccount(id, pw);
			ShopController.shopDao.makeCart(id);
			return new ModelAndView(true, "login/loginHome");
		}
		return new ModelAndView(viewName);
	}

}
