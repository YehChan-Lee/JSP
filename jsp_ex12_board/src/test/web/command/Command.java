package test.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import test.web.model.BoardDao;

public interface Command {
	BoardDao dao = BoardDao.getInstance();
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}