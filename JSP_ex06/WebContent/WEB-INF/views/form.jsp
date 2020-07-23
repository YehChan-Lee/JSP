<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#field{
		width: 290px;
	}
</style>
</head>
<body>
	<h1>사람 정보 입력</h1>
	<hr />
	<fieldset id="field">
		<legend>정보 입력</legend>
		<form id="input_form" action="input">
			<label for="name">이름 : </label><input type="text" id="name" name="name" /> <br />
			<label for="addr">주소 : </label><input type="text"id="addr" name="addr" /> <br />
			<label for="age">나이 : </label><input type="text" id="age" name="age" />
			<input type="submit" name="input" value="입력" />
		</form>
	</fieldset>
</body>
</html>