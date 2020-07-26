<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	fieldset{
		width : 220px;
	}
</style>
</head>
<body>
	<h2>회원가입</h2>
	<hr />
	<fieldset>
		<legend>회원가입</legend>
		<form action="login/sign.do">
		<label for="id">ID : </label><input type="text" name="id" /><br /> 
		<label for="pw">PW : </label><input type="password" name="pw" /><br />		
		<input type="submit" value="회원가입"/>
		</form>
	</fieldset>
</body>
</html>