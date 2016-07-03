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
<title>选课</title>

<link rel="stylesheet" type="text/css" href="<%=path%>/table.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />
</head>

<body>
	<%@ include file="homeTop.jsp"%>

	<%
		String reg = (String) this.getServletContext().getAttribute("reg");
		if (reg != null) {
	%>
	<script type="text/javascript" language="javascript">
		alert('课程注册已关闭');
		window.location.href="home.jsp";
	</script>
	<%
		} 
	%>

	<br />
	<br />
	<br />
	<table align="center" width="35%">
		<tr>
			<td width="15%"><a href="create.jsp" class="a_class button blue">创建课表</a>
			</td>
			<td width="15%"><a href="update.jsp" class="a_class button blue">更新课表</a>
			</td>
			<td width="15%"><a href="delete.jsp" class="a_class button blue">删除课表</a>
			</td>
		</tr>
	</table>

</body>
</html>