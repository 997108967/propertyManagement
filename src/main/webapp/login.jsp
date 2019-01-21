

<%@page contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>用户登录</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
<style type="text/css">
#content{
	height:215px;
}
#login div{
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<div id="wrap">
		<div id="top_content">
			<%@ include file="header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<div id="login">
					<div>
						<a href="userLogin.jsp">用户登录</a>
					</div>
					<div>
						<a href="serviceman/login.jsp">管理员登录</a>
					</div>
					<div>
						<a href="adm/login.jsp">维修人员登录</a>
					</div>
				</div>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>