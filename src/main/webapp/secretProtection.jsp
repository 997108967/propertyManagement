<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<form action="secretProtection" method="post">
		<select name="securityQuestion">
		<option value="你老师的姓名？">你老师的姓名？</option>
		<option value="你父亲的姓名？">你父亲的姓名？</option>
		<option value="你同桌的姓名？">你同桌的姓名？</option>
	</select>
	<input type="text" name="answer">
	<input type="submit" value="确定"><br>
	${confidentialInsuranceError}
	</form>
</body>
</html>