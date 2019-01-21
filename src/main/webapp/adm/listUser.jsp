<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="entity.*,java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>listUsers</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<%@ include file="header.jsp"%>
			<div id="content">
				<p id="whereami"></p>
				<h1>用户列表</h1>
				<table class="table">
					<tr class="table_header">
						<td>用户名</td>
						<td>住址</td>
						<td>身份证号</td>
						<td>手机号</td>
						<td>修改</td>
						<td>删除</td>
					</tr>
					<c:forEach items="${users}" var="user" varStatus="s">
						<tr class="row${s.index%2+1}">
							<td>${user.username}</td>
							<td>${user.address}</td>
							<td>${user.idNumber}</td>
							<td>${user.phoneNumber}</td>
							<td><a href="userData?username=${user.username}">修改</a>&nbsp;</td>
							<td><a href="delete?id=${user.id}" onclick="return confirm('确定删除${u.username}吗？');">删除</a>&nbsp;</td>
						</tr>
					</c:forEach>
				</table>
				<p>
					<input type="button" class="button" value="添加用户"
						onclick="location='toaddUser.do'" />
				</p>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>