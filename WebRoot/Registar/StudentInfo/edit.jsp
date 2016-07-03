<%@page import="bean.StudentInfo"%>
<%@page import="bean.ProfessorInfo"%>
<%@page import="bean.DbManager"%>
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
<title>编辑学生</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />
<script type="text/javascript" src="javascript/add_pro.js"></script>
<script type="text/javascript" src="javascript/on_show_info.js"></script>
</head>

<body>
	<%@ include file="../homeTop.jsp"%>
	<%@ include file="/msg.jsp"%>

	<br />
	<br />
	<br />

	<%!String id = "";
	DbManager dbManager = new DbManager();
	StudentInfo info = null;%>
	<%
		id = request.getParameter("id");
		if (id == null || id.equals(" ") || id.equals(""))
		{
	%>
	<table align="center" width="30%">
		<tr>
			<td>学生ID:<input type="text" id="update_id" name="update_id" /><input
				class="button blue" type="button" value="显示信息"
				onclick="edit_show_info()" /></td>
		</tr>
	</table>
	<br />
	<br />

	<%
		} else
		{

			info = dbManager.queryStudentInfo(Integer.parseInt(id.trim()));
			if (info != null)
			{
				String birth = info.getBirthday();
				String[] bd = birth.split("\\.");

				String gday = info.getGraduationDate();
				String[] gd = gday.split("\\.");
	%>

	<form action="<%=path%>/servlet/EditStu" method="post"
		onsubmit="return add_stu()">
		<table align="center" width="30%">
			<tr>
				<td>学生ID:<input type="text" id="update_id" name="update_id"
					id="update_id" value="<%=id%> " /><input class="button blue"
					type="button" value="显示信息" onclick="edit_show_info()" />
				</td>
			</tr>
		</table>
		<br /> <br />

		<table align="center" width="30%">
			<tr>
				<td width="20%">姓名：</td>
				<td width="80%"><input type="text" name="name" id="name"
					value="<%=info.getName()%>" />
				</td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input style="width:40px" type="text" name="year" id="year"
					value="<%=bd[0]%>" />年 <input style="width:20px" type="text"
					name="month" id="month" value="<%=bd[1]%>" />月 <input
					style="width:20px" type="text" name="date" id="date"
					value="<%=bd[2]%>" />日</td>
			</tr>
			<tr>
				<td>社会保障号码：</td>
				<td><input type="text" name="number" id="number"
					value="<%=info.getSocialNumber()%>" />
				</td>
			</tr>
			<tr>
				<td>身份：</td>
				<td><input type="text" name="status" id="status"
					value="<%=info.getStatus()%>" />
				</td>
			</tr>
			<tr>
				<td>毕业日期：</td>
				<td><input style="width:40px" type="text" name="grayear"
					id="grayear" value="<%=gd[0]%>" />年 <input style="width:20px"
					type="text" name="gramonth" id="gramonth" value="<%=gd[1]%>" />月
					<input style="width:20px" type="text" name="gradate" id="gradate"
					value="<%=gd[2]%>" />日</td>
			</tr>
			<tr>
				<td><input class="button blue" type="submit" value="保存" />
				</td>
				<td><a href="studentInfo.jsp" class="a_class button blue">取消</a>
				</td>
			</tr>
		</table>
	</form>
	<%
		} else
			{
	%>
	<table align="center" width="30%">
		<tr>
			<td>学生ID:<input type="text" id="update_id" name="update_id"
				value="<%=id%> " /><input class="button blue" type="button"
				value="显示信息" onclick="edit_show_info()" />
			</td>
		</tr>
	</table>
	<br />
	<br />
	<div align="center">没有该学生</div>
	<%
		}
		}
	%>
</body>
</html>
