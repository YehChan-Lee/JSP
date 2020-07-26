<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
fieldset {
	width: 300px;
}

</style>
</head>
<body>
	<h1>로그인</h1>
	<hr />
	<fieldset>
	<legend>로그인</legend>
		<form action="check.do">			
			<label for="id">ID : </label><input type="text" name="id" value="test" /><br /> 
			<label for="pw">PW : </label><input type="password" name="pw" /><br />
			<input type="submit" name="login" value="로그인" />
		</form>
		<form action="signin.do">
			<input type="submit" name="signin" value="회원가입" />
		</form>
	</fieldset>

</body>
</html>