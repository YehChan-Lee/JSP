<%@page import="org.comstudy21.model.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>상세보기</h2>
<%
if(request.getAttribute("product") != null) {
	Product p = (Product)request.getAttribute("product");
	out.println(p);
}
%>
<a href="<%=request.getContextPath()%>/shop/home.do">HOME</a>
<a href="<%=request.getContextPath()%>/shop/list.do">상품목록</a>

</body>
</html>