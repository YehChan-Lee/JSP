<%@page import="org.comstudy21.model.Product"%>
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

<h2>상품 목록</h2>
<hr>
<%
ArrayList<Product> pList = new ArrayList<Product>();
if(request.getAttribute("pList") != null) {	
	pList = (ArrayList<Product>)request.getAttribute("pList");
	for(int i=0; i<pList.size(); i++) {
		Product p = pList.get(i);
%>
	<p>
	<%=p.getIdx()%> | 
	<a href="<%=request.getContextPath()%>/shop/detail.do?idx=<%=p.getIdx()%>">
	<%=p.getTitle() %></a> | 
	<%=p.getPrice()%> | 
	<a href="<%=request.getContextPath()%>/shop/cart.do?idx=<%=p.getIdx()%>">
	장바구니</a>
	</p>
<%
	} // end of for
} else {
	out.println("<h2>상품이 없습니다.</h2>");
}
%>
<hr>
<a href="<%=request.getContextPath()%>/shop/home.do">HOME</a>
</body>
</html>