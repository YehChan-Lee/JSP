<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>EL 데이터 확인</h3>
<hr />
<p>request 메세지 : ${requestScope.req_msg }</p>
<p>session 메세지 : ${sessionScope.ses_msg }</p>
</body>
</html>