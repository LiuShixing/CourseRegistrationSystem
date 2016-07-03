<%@page import="bean.Take"%>
<%@page import="bean.TimeSlot"%>
<%@page import="bean.Teach"%>
<%@page import="java.util.ArrayList"%>
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
<title>删除课表</title>

<link rel="stylesheet" type="text/css" href="<%=path%>/table.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />
</head>

<body>
	<%@ include file="homeTop.jsp"%>
	<%@ include file="/msg.jsp"%>

	<%!DbManager dbManager = new DbManager();
	ArrayList<Take> courses = null;
	ArrayList<Teach> available = null;
	int stuId;%>
	<%
		stuId = Integer.parseInt(session.getAttribute("user").toString());
		courses = dbManager.queryCurrALLTakes(stuId);
		available = dbManager.queryCurrALLTeach();
	%>
	<table id="table" class="hovertable" align="center" width="55%"
		border="1">
		<tr>
			<th colspan="5"><div align="center">课程表</div>
			</th>
		</tr>
		<tr>
			<th width="6%"><div align="center">课程编号</div>
			</th>
			<th width="6%"><div align="center">课程名称</div>
			</th>
			<th width="8%"><div align="center">教师编号</div>
			</th>
			<th width="8%"><div align="center">教师姓名</div>
			</th>
			<th width="8%"><div align="center">上课时间</div>
			</th>
			<th width="8%"><div align="center">类型</div></th>
			
		</tr>
		<%
			if (courses != null)
			{
				for (Take t : courses)
				{
					String start_endWeek = "" + t.getStartweek() + "-"
							+ t.getEndweek() + "周  ";
					ArrayList<TimeSlot> timeSlots = t.getTimeSlot();
					String times = start_endWeek;
					for (int time = 0; time < timeSlots.size(); time++)
					{
						times += "周" + timeSlots.get(time).getDay() + " "
								+ timeSlots.get(time).getStart_time() + "-"
								+ timeSlots.get(time).getEnd_time() + "节\n";
					}
		%>
		<tr class="change_color">
			<td><%=t.getCouOffer_id()%></td>
			<td><%=t.getTitle()%></td>
			<td><%=t.getPro_id()%></td>
			<td><%=t.getProfessorName()%></td>
			<td><%=times%></td>
			<td><%=t.getType() %></td>
		</tr>
		<%
			}
			} else
			{
		%>

		<%
			}
		%>
	</table>
	<br />
	<br />
	<br />
	<div align="center">
		<a onclick="return confirm('确认删除？')"
			href="<%=path%>/servlet/StuDeleteAllCou?stuId=<%=stuId%>"
			class="button blue">删除课表</a>

	</div>

	<script type="text/javascript" src="<%=path%>/table_mouse_over.js"></script>

</body>
</html>