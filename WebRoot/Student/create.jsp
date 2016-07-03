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
<title>创建课表</title>

<link rel="stylesheet" type="text/css" href="<%=path%>/table.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />

<script type="text/javascript" src="script.js"></script>
</head>

<body>
	<%@ include file="homeTop.jsp"%>
	<%@ include file="/msg.jsp"%>

	<%!DbManager dbManager = new DbManager();
	ArrayList<Teach> courses = null;
	int stuId;%>
	<%
		stuId = Integer.parseInt(session.getAttribute("user").toString());
		courses = dbManager.queryCurrALLTeach();
	%>
	<table id="table" class="hovertable" align="center" width="55%"
		border="1">
		<tr>
			<th colspan="7"><div align="center">所有课程</div></th>
		</tr>
		<tr>
			<th width="6%"><div align="center">课程编号</div></th>
			<th width="6%"><div align="center">课程名称</div></th>
			<th width="8%"><div align="center">教师编号</div></th>
			<th width="8%"><div align="center">教师姓名</div></th>
			<th width="8%"><div align="center">上课时间</div></th>
			<th width="8%"><div align="center">已选人数</div></th>
			<th width="6%"><div align="center">操作</div></th>
		</tr>
		<%
			if (courses != null)
			{
				for (Teach t : courses)
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
			<td><%=t.getProName()%></td>
			<td><%=times%></td>
			<td><%=t.getStudent_count()%></td>
			<td><a onclick="return checkStudentCount(<%=t.getStudent_count()%>)"
				href="<%=path%>/servlet/StuAddCou?couId=<%=t.getCouOffer_id()%>
				&proId=<%=t.getPro_id()%>&stuId=<%=stuId%>
				&year=<%=t.getYear() %> &semester=<%=t.getSemester() %>&from=create">选课</a>
			</td>
		</tr>
		<%
			}
			}
		%>
	</table>
	<script type="text/javascript" src="<%=path%>/table_mouse_over.js"></script>

</body>
</html>