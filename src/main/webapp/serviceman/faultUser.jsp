<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>故障用户</title>
</head>
<body>
	<table>
		<tr>
			<td>用户名</td>
			<td>联系方式</td>
			<td>故障信息</td>
			<td>接单</td>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.phoneNumber}</td>
				<td>${user.fault}</td>
				<td>
					<a href="receipt?username=${user.username}&phoneNumber=${user.phoneNumber}&fault=${user.fault}">确定</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>