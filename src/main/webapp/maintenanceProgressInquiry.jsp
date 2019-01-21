<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body style="font-size:30px;">
	<table>
		<tr>
			<td>用户名</td>
			<td>报修内容</td>
			<td>修理进度</td>
		</tr>
		<tr>
			<td>
				${user.username }
			</td>
			<td>
				<c:choose>
					<c:when test="${empty user.fault}">
						无
					</c:when>
					<c:otherwise>
						${user.fault}
					</c:otherwise>
				</c:choose>
			</td>
			<td>
				<c:choose>
					<c:when test="${empty user.repair}">
						无
					</c:when>
					<c:otherwise>
						${user.repair}
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</table>
</body>
</html>