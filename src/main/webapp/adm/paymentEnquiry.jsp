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
						<td>水费</td>
						<td>电费</td>
						<td>燃器费</td>
						<td>物业费</td>
					</tr>
					<c:forEach items="${users}" var="user" varStatus="s">
						<tr class="row${s.index%2+1}">
							<td>${user.username}</td>
							<td>${user.waterRates}</td>
							<td>${user.powerRates}</td>
							<td>${user.burnerCost}</td>
							<td>${user.propertyFee}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
		<%@ include file="footer.jsp"%>
	</div>
</body>
</html>