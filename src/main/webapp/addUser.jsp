<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
	<head>
		<title>add User</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<style type="text/css">
			#check{
				display:none;
			}
			#idCard{
				display:none;
			}
			#phoneNumber2{
				display:none;
			}
			#usernameException{
				display:none;
			}
			#addressException{
				display:none;
			}
		</style>
		<script type="text/javascript">
			//检查住址
			function checkAddress(){
				var address = document.getElementsByName("address")[0];
				var reg = (/^[\u4E00-\u9FA5A-Za-z\d\-\_]{5,60}$/);
				if(reg.test(address.value)){
					addressException.style.display = "none";
					return true;
				}else{
					addressException.style.display = "inline";
					return false;
				}
				
			}
			//检查姓名
			function checkUsername(){
				var username = document.getElementsByName("username")[0];
				var reg = /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/;
				if(reg.test(username.value)){
					usernameException.style.display = "none";
					return true;
				}else{
					usernameException.style.display = "inline";
					return false;
				}
				
			}
			//核查密码
			function checkPassword(){
				var pass1 = document.getElementsByName("password")[0];
				var pass2 = document.getElementsByName("password2")[0];
				var tips = document.getElementById("check");
				if(pass1.value!=pass2.value){
					tips.style.display = "inline";
					return false;
				}else{
					tips.style.display = "none";
					return true;
				}
			}
			//检查身份证
			function checkId(){
				var expression = /^\d{18}$/;
				var id = document.getElementsByName("id")[0];
				if(!expression.test(id.value)){
					idCard.style.display = "inline";
					return false;
				}else{
					idCard.style.display = "none";
					return true;
				}
			}
			//检查手机号
			function phoneNumber3(){
				var expression = /^1[34578]\d{9}$/;
				var phoneNumber = document.getElementsByName("phoneNumber")[0];
				if(!expression.test(phoneNumber.value)){
					phoneNumber2.style.display = "inline";
					return false;
				}else{
					phoneNumber2.style.display = "none";
					return true;
				}
			}
			//判断信息是否合法（合法则可以提交）
			function checkAll(){
				var password = checkPassword();
				var id = checkId();
				var phoneNumber = phoneNumber3();
				var address = checkAddress();
				var username = checkUsername();
				if(phoneNumber&&username&&password&&id&&address){
					return true;
				}else{
					return false;
				}
			}
		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<%@ include file="header.jsp" %>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						添加用户:
					</h1>
					<form action="add" method="post" onsubmit="return checkAll()">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" onblur="checkUsername()"/>
									<span id="usernameException">请输入正确的用户名</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									确认密码:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password2" onblur="checkPassword()"/>
									<span id="check">两次输入的密码不一致！</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									住址:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="address" onblur="checkAddress()"/>
									<span id="addressException">地址输入有误！请重新输入</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									身份证号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="id" onblur="checkId()"/>
									<span id="idCard">输入有误！</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									手机号:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="phoneNumber" onblur="phoneNumber3()"/>
									<span id="phoneNumber2">输入有误！</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密保:
								</td>
								<td valign="middle" align="left">
									<select name="secretProtection">
										<option value="teacher">你老师的姓名？</option>
										<option value="father">你父亲的姓名？</option>
										<option value="deskmate">你同桌的姓名？</option>
									</select>
								</td>
								<td>
									<input type="text" class="inputgri" name="secretProtectionValue" >
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value="确认" />
						</p>
					</form>
				</div>
			</div>
			<%@ include file="footer.jsp" %>
		</div>
	</body>
</html>