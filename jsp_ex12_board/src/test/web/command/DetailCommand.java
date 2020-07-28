package test.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.model.BoardTO;

public class DetailCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DetailCommand 호출");
		int no = Integer.parseInt(request.getParameter("num"));
		
		BoardTO dto = dao.selectOne(no);
		request.setAttribute("select", dto);		
	}

}
