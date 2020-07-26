<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashSet"%>
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

<h2>장바구니</h2>
<hr />
<%
if(session.getAttribute("cartList") != null) {
	ArrayList<Product> cartList = (ArrayList<Product>)session.getAttribute("cartList");
	if(cartList.size()>0){
	for(Product product : cartList){
		Product p = product;
		out.println("<p>"+p+"[<a href="+request.getContextPath()+"/shop/cart_remove.do?idx="+p.getIdx()+">카트에서 제거</a>]</p>");
	}
	}else{
		out.println("<h2>상품이 없습니다.</h2>");
	}
%>
	
<%
} else {
	out.println("<h2>상품이 없습니다.</h2>");
}
%>
<a href="<%=request.getContextPath()%>/shop/home.do">HOME</a>
<a href="<%=request.getContextPath()%>/shop/list.do">상품목록</a>

</body>
</html>