<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
	window.onload = function(){
		var form = document.forms[0];
		form.onsubmit = function(){
			event.preventDefault();
			
			if(this.title.value==""){
				alert("제목은 필수 입력입니다.");
				this.title.focus();
				return;
			}
			if(this.author.value==""){
				alert("작성자는 필수 입력입니다.");
				this.author.focus();
				return;
			}			
			this.submit();
		}
	}
</script>
</head>
<body>
	<form method="post" action="<%=request.getContextPath()%>/board?action=write.do">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td>작성자</td>
				<td><input type="text" name="author" value="홍길동" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email"  size="30" maxlength="200" value="hong@hong.com"/></td>
			</tr>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="65" maxlength="500" value="write by hong"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea name="content" id="" cols="65" rows="10" maxlength="4000">홍길동 다녀간다.</textarea></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="passwd" value="12345" /></td>
			</tr>
			<tr>
				<td><a href="javascript:FormSubmit()"></a></td>
			</tr>
		</table>
	<input type="submit" value="쓰기" />
	</form>
</body>
</html>