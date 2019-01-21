<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<form action="changePassword" method="post">
		旧密码:<input type="text" name="oldPassword">${passwordError}<br>
		新密码:<input type="text" name="newPassword"><br>
		<input type="submit" value="确定">
	</form>
	<a href="secretProtection.jsp">使用密保修改</a>
</body>
</html>