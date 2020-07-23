<%@page import="org.comstudy21.dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Connection conn = JdbcUtil.getConnection();
out.println("conn => " + conn);

// JNDI를 사용 하면 tomcat이 구동 되어야 한다.
//SaramDao.test_selectAll();

//SaramDto dto = new SaramDto(0,"choi","choi@c.com","010-6666-6666");
//SaramDao.test_insert(dto);
%>

</body>
</html>