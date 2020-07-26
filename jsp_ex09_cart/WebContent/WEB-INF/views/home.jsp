<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>중고 자동차 쇼핑몰</h1>
<hr>
<ul>
	<li><a href="<%=request.getContextPath() %>/shop/list.do">상품 목록</a></li>
	<li><a href="<%=request.getContextPath() %>/shop/cart.do">장바구니</a></li>
	<li><a href="<%=request.getContextPath() %>/bbs/list.do">고객센터</a>
	<li><a href="<%=request.getContextPath() %>/bbs/board.do">커뮤니티</a>
	<li><a href="<%=request.getContextPath() %>/login/loginHome.do">로그인페이지</a>
</ul>

</body>
</html>