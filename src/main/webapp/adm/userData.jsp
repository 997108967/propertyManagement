<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改资料</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<%@ include file="header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>用户资料</h1>
				<form action="updateUserData" method="post"> 
					用户名：<input type="text" value="${user.username}" name="username" readonly="readonly"><br>
					密码：<input type="text" value="${user.password}" name="password"><br>
					地址：<input type="text" value="${user.address}" name="address"><br>
					电话号码：<input type="text" value="${user.phoneNumber}" name="phoneNumber"><br>
					<input type="submit" value="修改">
				</form>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>