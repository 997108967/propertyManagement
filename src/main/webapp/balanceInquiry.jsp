<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<table border="1px">
		<tr>
			<td>水费</td>
			<td>电费</td>
			<td>燃气费</td>
			<td>物业费</td>
		</tr>
		<tr>
			<td>${user.waterRates}</td>
			<td>${user.powerRates}</td>
			<td>${user.burnerCost}</td>
			<td>${user.propertyFee}</td>
		</tr>
	</table>
</body>
</html>