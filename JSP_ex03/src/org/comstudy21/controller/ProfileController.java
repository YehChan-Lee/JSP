package org.comstudy21.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.comstudy21.dto.Person;

public class ProfileController extends HttpServlet {
	private Person person = new Person("김길동","대전",28);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ProfileController ... doget");
		
		String path = "/WEB-INF/jsp/profile.jsp";		
		req.setAttribute("person",person);
		RequestDispatcher test = req.getRequestDispatcher(path);
		test.forward(req, resp);
	}
}
