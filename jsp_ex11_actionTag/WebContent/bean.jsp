<%@page import="java.util.ArrayList"%>
<%@page import="org.comstudy21.bean.Dao"%>
<%@page import="org.comstudy21.bean.Bean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:useBean id="m" class="org.comstudy21.bean.Bean"/>
<jsp:setProperty property="*" name="m" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	 입력된 사용자 이름은 ?
	<jsp:getProperty property="name" name="m" />
	입니다. 입력된 사용자 나이는 ?
	<jsp:getProperty property="age" name="m" />
	입니다. 입력된 사용자 키는 ?
	<jsp:getProperty property="height" name="m" />
	입니다.
</body>
</html>