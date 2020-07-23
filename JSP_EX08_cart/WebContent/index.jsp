<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>중고차 쇼핑몰</h1>
	<hr />
	<ul>
		<li><a href="car/list.do">자동차 목록</a></li>
		<li><a href="car/cart.do">장바구니</a></li>
	</ul>
	<hr />
	<form action="car/input.do" method = "post">
	차종 : <input type="text" name="name" />
	 <input type="submit" value="전송하기" />
	</form>
</body>
</html>