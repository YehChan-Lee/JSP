package test.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.command.DeleteCommand;
import test.web.command.DetailCommand;
import test.web.command.ListCommand;
import test.web.command.WriteCommand;

@WebServlet(description = "board front controller", urlPatterns = { "/board" })
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("FrontController 호출");
		String action = request.getParameter("action");
		String viewName = "/WEB-INF/views/board/list.jsp";

		try {
			if ("list".equals(action)) {
				ListCommand command = new ListCommand();
				command.execute(request, response);
				viewName = "/WEB-INF/views/board/list.jsp";
			}else if("write.ui".equals(action)){
				viewName = "/WEB-INF/views/board/write.jsp";
			}else if("write.do".equals(action)){
				WriteCommand command = new WriteCommand();
				command.execute(request, response);
				response.sendRedirect("board?action=list");
				return;
			}else if("detail.ui".equals(action)){				
				DetailCommand command = new DetailCommand();
				command.execute(request, response);
				viewName = "/WEB-INF/views/board/detail.jsp";
			}else if("delete.do".equals(action)){				
				DeleteCommand command = new DeleteCommand();
				command.execute(request, response);
				if((boolean)request.getAttribute("check")){
					response.sendRedirect("board?action=list");
					return;
				}else{
					viewName = "/WEB-INF/views/board/detail.jsp";
					request.setAttribute("failpw", "비밀번호가 틀림");
				}
				
				
			}
			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
