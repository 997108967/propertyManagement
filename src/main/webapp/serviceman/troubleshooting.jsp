<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>维修故障</title>
</head>
<body>
	<table>
		<tr>
			<td>用户名</td>
			<td>联系方式</td>
			<td>故障信息</td>
			<td>提交</td>
		</tr>
		<c:forEach items="${servicemans}" var="serviceman">
			<tr>
				<td>${serviceman.username}</td>
				<td>${serviceman.userPhone}</td>
				<td>${serviceman.project}</td>
				<td>
					<a href="maintenanceCompleted?username=${serviceman.username}">维修完成</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>