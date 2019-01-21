<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
body {
	overflow: hidden;
}

#login div {
	border: 1px solid red;
	height: 100px;
	width: 100px;
	border-radius: 100%;
	overflow: hidden;
	float: left;
	
}

a {
	display: block;
	text-decoration: none;
	margin: 0 auto;
	text-align: center;
	line-height: 100px;
}
#login{
	width:306px;
	margin: 0 auto;
}
</style>
</head>
<body style="font-size: 10px;">
	<div id="login">
		<div>
			<a href="repair.jsp">物业报修</a>
		</div>
		<div>
			<a href="onlinePayment.jsp">网上缴费</a>
		</div>
		<div>
			<a href="changePassword.jsp">密码修改</a>
		</div>
	</div>

</body>
</html>