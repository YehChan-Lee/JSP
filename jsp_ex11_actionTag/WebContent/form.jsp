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
request.setCharacterEncoding("UTF-8");
	if(request.getParameter("msg") != null){
		String msg = request.getParameter("msg");
		out.println("<p>"+ msg +"</p>");
	}
%>

<p>성명 입력 : </p>
<form action="form_ok.jsp" method="get">
	Name : <input type="text" name="userName" />
	<input type="submit" value="전송하기" />
</form>

</body>
</html>