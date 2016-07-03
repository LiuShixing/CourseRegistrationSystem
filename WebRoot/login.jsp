<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户登录</title>
<style type="text/css">
body {
	background-color: #ffffff;
	text-align:center;
}

.form_body{
background-color: #f0ffff;
margin:0 auto; width:250px; height:100px; border:1px solid #a0ffff;
margin-top:200px;
}
.login_font{
font-family:'微软雅黑';
font-size:20px;
}
</style>
</head>
<body>
	<%
		String errInfo = (String) request.getParameter("errInfo");
		if (errInfo != null)
		{
			if (errInfo.equals("errUserName"))
			{
				out.print("<center>用户名或密码错误！请重新输入。。。</center>");
			}
			else if(errInfo.equals("ErrUserNameFormat"))
			{
			out.print("<center>用户名格式错误！请重新输入。。。</center>");
			} 
		}
	%>


	<div class="form_body">
	    <div class="login_font">用户登录</div>
		<form method="post" action="servlet/Login">
			<table>
				<tr>
					<td>账号：</td>
					<td><input type="text" name="userName" />
					</td>
				</tr>
				<tr>
					<td>密码：</td>
					<td><input type="password" name="password" />
					</td>
				</tr>
				<tr>
					<td colspan="2"><input id="submit" type="submit" value="登录" />
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>
