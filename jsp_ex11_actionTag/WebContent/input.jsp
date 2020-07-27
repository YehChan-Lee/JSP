<%@page import="org.comstudy21.bean.Bean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.comstudy21.bean.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="bean.jsp" method="post">
	<h1>회원정보 등록폼</h1>
	<hr />
	사용자 이름 : <input type="text" name="name" />
	사용자 나이 : <input type="text" name="age" />
	사용자 키 : <input type="text" name="height" />
	<input type="submit" value="전송하기" />
	</form>
</body>
</html>