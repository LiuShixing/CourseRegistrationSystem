<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>添加教师</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />

<script type="text/javascript" src="javascript/add_pro.js"></script>
</head>

<body>
	<%@ include file="../homeTop.jsp"%>
   <%@ include file="/msg.jsp"%>

<br/>
<br/>
<br/>
	<form action="<%=path%>/servlet/AddPro" method="post"
		onsubmit="return add_pro()">
		<table align="center" width="30%">
			<tr>
				<td width="20%">姓名：</td>
				<td width="80%"><input type="text" name="name" id="name" />
				</td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input style="width:40px" type="text" name="year" id="year" />年
					<input style="width:20px" type="text" name="month" id="month" />月
					<input style="width:20px" type="text" name="date" id="date" />日</td>
			</tr>
			<tr>
				<td>社会保障号码：</td>
				<td><input type="text" name="number" id="number" />
				</td>
			</tr>
			<tr>
				<td>身份：</td>
				<td><input type="text" name="status" id="status" />
				</td>
			</tr>
			<tr>
				<td>院系：</td>
				<td><input type="text" name="department" id="department" />
				</td>
			</tr>
			<tr>
				<td><input class="button blue" type="submit" value="添加" />
				</td>
				<td><a href="professorInfo.jsp" class="a_class button blue">取消</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>