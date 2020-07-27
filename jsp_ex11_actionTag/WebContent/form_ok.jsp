<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<p>환영합니다.</p>
	<%
	request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("userName");
		if (name.length() == 0) {
			//입력 값이 없다면 form.jsp를 다시 보여준다.
			String msg = "성명을 입력하고 로그인을 재시도 하세요";
	%>
	<jsp:forward page="form.jsp">
		<jsp:param value="<%=msg %>" name="msg"></jsp:param>
	</jsp:forward>
	<%
		}
	%>
	Hello
	<%=name%>
</body>
</html>