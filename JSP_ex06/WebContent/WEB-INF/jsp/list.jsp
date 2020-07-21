<%@page import="java.sql.Connection"%>
<%@page import="org.comstudy21.dto.Person"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>List 페이지</h1>
	<hr />
	<%
		ArrayList<Person> arr = (ArrayList<Person>)request.getAttribute("P_list");
		out.println("<table border='1'>");
		for(int i=0;i<arr.size();i++){
			out.println("<tr>");
			out.println("<td>"+arr.get(i).getUserName() +"</td>");
			out.println("<td>"+arr.get(i).getUserAddr()+"</td>");
			out.println("<td>"+arr.get(i).getAge() +"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
	%>
</body>
</html>