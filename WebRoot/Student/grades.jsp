<%@page import="bean.DbManager"%>
<%@page import="bean.Take"%>
<%@page import="java.util.ArrayList"%>
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
<title>成绩</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/table.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />
</head>

<body>
	<%@ include file="homeTop.jsp"%>

	<%!ArrayList<Take> courses = null;
	DbManager dbManager = new DbManager();%>
	<%
		courses = dbManager.queryBeforeALLTakes(Integer.parseInt(session
				.getAttribute("user").toString()));
		if (courses == null)
		{
	%>
	没有历史成绩
	<%
		} else
		{
	%>
	<table id="table" class="hovertable" align="center" width="55%"
		border="1">
		<tr>
			<th colspan="8"><div align="center">课程成绩</div></th>
		</tr>
		<tr>
			<th width="6%"><div align="center">学年</div></th>
			<th width="6%"><div align="center">学期</div></th>
			<th width="4%"><div align="center">课程</div></th>
			<th width="8%"><div align="center">成绩</div></th>
		</tr>

		<%
			for (Take t : courses)
				{
		%>
		<tr>
			<td><%=t.getYear()%></td>
			<td><%=t.getSemester()%></td>
			<td><%=t.getTitle()%></td>
			<td><%=t.getGrade() %></td>
		</tr>
		<%
			}
		%>

	</table>
	<%
		}
	%>
</body>
</html>