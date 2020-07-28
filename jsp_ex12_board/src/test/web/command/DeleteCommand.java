package test.web.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.model.BoardTO;

public class DeleteCommand implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("DeleteCommand 호출");
		int num = Integer.parseInt(request.getParameter("num"));
		PrintWriter out = response.getWriter();
		
		BoardTO dto = dao.selectOne(num);
		String pw = dto.getPasswd();
		String inputPw = request.getParameter("pw");
		if(pw.equals(inputPw)){
			request.setAttribute("check", true);
			dao.delete(num);
		}else{
			out.println("비밀번호가 틀렸습니다.");
			request.setAttribute("select",dto);
			request.setAttribute("check", false);
		}
	}

}
