package org.comstudy21.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.model.Dao;

public interface Command {
	Resolve Action(HttpServletRequest request, HttpServletResponse response) throws IOException;
	Dao dao = Dao.getInstance();
}
