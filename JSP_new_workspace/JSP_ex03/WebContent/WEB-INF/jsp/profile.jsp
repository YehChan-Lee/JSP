<%@page import="org.comstudy21.dto.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>Profile Page ...</h1>
	<%
	Person person = (Person)request.getAttribute("person");
	String userName = person.getUserName();
	String userAddr = person.getUserAddr();
	int age = person.getAge();
	%>
	사용자 이름 : <%=userName %><br />
	사용자 주소 : <%=userAddr %> <br />
	사용자 나이 : <%=age %>
</body>
</html>