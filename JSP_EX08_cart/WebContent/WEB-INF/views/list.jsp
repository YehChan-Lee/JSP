<%@page import="org.comstudy21.model.Dto"%>
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
	<h2>자동차 목록</h2>
	<hr />
	<%
		if (request.getAttribute("LIST") != null) {
			ArrayList<Dto> list = (ArrayList<Dto>) request.getAttribute("LIST");
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
			<td><a href="detail.do?no=<%=dto.getNo()%>"><%=dto.getName()%></a></td>
			<td><%=dto.getCompany()%></td>
			<td><%=dto.getYear()%></td>
		</tr>
		<%
			}
		%>		
	</table>
	<form action="cart.do">
		<input type="submit" value="장바구니로 가기" />
	</form>
	<%
		} else {
			out.println("<h3>내용이 없습니다!</h3>");
		}
	%>
</body>
</html>