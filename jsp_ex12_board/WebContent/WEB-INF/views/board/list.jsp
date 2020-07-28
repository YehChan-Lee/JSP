<%@page import="java.sql.Timestamp"%>
<%@page import="test.web.model.BoardTO"%>
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
<h2>글 목록</h2>
<hr />
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>이메일</th>
			<th>날짜</th>
		</tr>
		<tr>
			<%
			request.setCharacterEncoding("utf-8");
				if (request.getAttribute("list") != null) {
					ArrayList<BoardTO> list = (ArrayList<BoardTO>)request.getAttribute("list");
					for (int i = 0; i < list.size(); i++) {
						BoardTO data = list.get(i);
						String num =""+ data.getNum();
						String title = data.getTitle();
						String author = data.getAuthor();
						String email = data.getEmail();
						Timestamp writeday = data.getWriteday();
			%>
			<tr>
				<td><%=num %></td>
				<td><a href="<%=request.getContextPath()%>/board?action=detail.ui&num=<%=data.getNum()%>"><%=title %></a></td>
				<td><%=author %></td>
				<td><%=email %></td>
				<td><%=writeday %></td>
			</tr>

			<%
				} //end for
			}
			%>
		</tr>
	</table>
	<a href="<%=request.getContextPath()%>/board?action=write.ui">글쓰기</a>
</body>
</html>