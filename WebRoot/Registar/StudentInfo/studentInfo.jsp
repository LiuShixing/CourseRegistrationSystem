
<%@page import="bean.StudentInfo"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:useBean id="dbManager" class="bean.DbManager" scope="page"></jsp:useBean>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="<%=path%>/table.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />
<title>管理学生信息</title>

<script type="text/javascript" src="javascript/delect_pro.js"></script>
<script type="text/javascript" src="javascript/query.js"></script>
</head>

<body>
	<%@ include file="../homeTop.jsp"%>
	<%@ include file="/msg.jsp"%>
	<%!ArrayList<StudentInfo> stuInfos = null;%>
	<%
			stuInfos = dbManager.queryALLStudentInfo();
	%>


	<table align="center" width="55%">
		<tr>
			<td width="55%"></td>
			<td width="15%"><a href="add.jsp" class="a_class button blue">添加</a>
			</td>
			<td width="15%"><a href="edit.jsp" class="a_class button blue">编辑</a>
			</td>
			<td width="15%"><a href="delete.jsp" class="a_class button blue">删除</a>
			</td>
		</tr>
	</table>

	<table id="table" class="hovertable" align="center" width="55%"
		border="1">
		<tr>
			<th colspan="8"><div align="center">学生信息</div>
			</th>
		</tr>
		<tr>
			<th width="6%"><div align="center">id</div>
			</th>
			<th width="6%"><div align="center">姓名</div>
			</th>
			<th width="4%"><div align="center">身份</div>
			</th>
			<th width="8%"><div align="center">毕业日期</div>
			</th>
			<th width="8%"><div align="center">生日</div>
			</th>
			<th width="10%"><div align="center">社会安全号码</div>
			</th>
			<th width="6%" colspan="2"><div align="center">操作</div>
			</th>
		</tr>
		<%
			for (int i = 0; i < stuInfos.size(); i++)
			{
				StudentInfo info = stuInfos.get(i);
		%>
		<tr class="change_color">
			<td><%=info.getId()%></td>
			<td><%=info.getName()%></td>
			<td><%=info.getStatus()%></td>
			<td><%=info.getGraduationDate()%></td>
			<td><%=info.getBirthday()%></td>
			<td><%=info.getSocialNumber()%></td>
			<td><a href="edit.jsp?id=<%=info.getId()%>">编辑</a>
			</td>
			<td><a href="delete.jsp?id=<%=info.getId()%>">删除</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<script type="text/javascript" src="<%=path%>/table_mouse_over.js"></script>
</body>

</html>