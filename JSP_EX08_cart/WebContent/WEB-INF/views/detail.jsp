<%@page import="org.comstudy21.model.Dto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
ul {
	list-style: none;
	padding: 0;
}

form {
	float: left;
}
</style>
</head>
<body>
	<h1>상세보기 페이지</h1>
	<hr />
	<%
		int value = 0;
		if (request.getAttribute("DTO") != null) {
			Dto dto = (Dto) request.getAttribute("DTO");
	%>
	<ul>
		<li>번호 : <%=dto.getNo()%></li>
		<li>차종 : <%=dto.getName()%></li>
		<li>제조사 : <%=dto.getCompany()%></li>
		<li>연식 : <%=dto.getYear()%></li>
	</ul>
	<form action="cart.do">		
	<% session.setAttribute("cart.dto", dto); %>
		<input type="submit" value="장바구니 담기" name="담기"/>		
	</form>	
	<%
		} else {
			out.println("<h3>내용이 없습니다!</h3>");
		}
	%>
	<form action="list.do">
		<input type="submit" value="목록으로 가기" />
	</form>

</body>
</html>