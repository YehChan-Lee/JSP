<%@page import="test.web.model.BoardTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<style>
p, pre {
	display: inline;
}
</style>
<body>
	<%
		if (request.getAttribute("select") != null) {
			BoardTO dto = (BoardTO) request.getAttribute("select");
	%>
	<h2><%=dto.getTitle()%></h2>
	작성자 :
	<p><%=dto.getAuthor()%></p>
	<br /> 이메일 :
	<p><%=dto.getEmail()%></p>
	<hr />
	내용 :
	<pre><%=dto.getContent()%></pre>
	<br />
	<a href="<%=request.getContextPath()%>/board?action=list">목록으로</a>
	<br />
	<form method="post"
		action="<%=request.getContextPath()%>/board?action=delete.do&num=<%=dto.getNum()%>">
		비밀번호 : <input type="password" name="pw" id="pw" /> <input
			type="submit" value="삭제" />
	</form>

	<%
		} else {
			out.print("작성된 글이 없습니다.");
		}
	%>
	<%
		if(request.getAttribute("failpw") != null){
			out.println("<p>"+ request.getAttribute("failpw")+ "</p>");
		}
	%>

</body>
</html>