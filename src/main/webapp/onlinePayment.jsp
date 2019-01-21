<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:15px;">
	<form action="onlinePayment" method="post">
		缴费类型：<select name="payType">
		<option value="waterRates">水费</option>
		<option value="powerRates">电费</option>
		<option value="burnerCost">燃气费</option>
		<option value="propertyFee">物业费</option>
		</select>
		<br>
		请输入金额：<input type="text" name="money">
		<input type="submit" value="确定充值">
	</form>
	<div><a href="balanceInquiry">余额查询</a></div>
</body>
</html>