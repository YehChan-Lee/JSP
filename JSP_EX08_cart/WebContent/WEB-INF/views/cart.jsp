<%@page import="org.comstudy21.model.Dto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	form{
		float : left;
	}
</style>
</head>
<body>
	<h2>장바구니</h2>
	<hr />
	<%
		if (request.getAttribute("CARTLIST") != null) {
			ArrayList<Dto> list = (ArrayList<Dto>) request.getAttribute("CARTLIST");
	%>
	<table border="1" width="550">
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>COMPANY</th>
			<th>YEAR</th>
		</tr>
		<%
			for (Dto dto : list) {
		%>
		<tr>
			<td><%=dto.getNo()%></td>
			<td><%=dto.getName()%></td>
			<td><%=dto.getCompany()%></td>
			<td><%=dto.getYear()%></td>
		</tr>
		<%
			}
		%>
	</table>
	<form action="list.do">
		<input type="submit" value="목록으로 가기" />
	</form>
	<form action="cart.do">
		삭제 할 번호 : <input type="text" name="number" id="number"/>
		<input type="submit" value="장바구니에서 삭제" name="삭제" />
	</form>
	<%
		} else {
			out.println("<h3>내용이 없습니다!</h3>");
		}
	%>
</body>
</html>