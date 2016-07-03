
<%@page import="bean.TimeSlot"%>
<%@page import="bean.CourseOffering"%>
<%@page import="bean.DbManager"%>
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
<title>选课页面</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/table.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />
</head>

<body>
	<%@ include file="homeTop.jsp"%>
	<%@ include file="/msg.jsp"%>

	<%!ArrayList<CourseOffering> course = null;
	DbManager dbManager = new DbManager();
	int proId;%>
	
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
	
	
	<%
		proId = Integer.parseInt(session.getAttribute("user").toString());
		course = dbManager.queryEligibleCourse(proId);
	%>

	<table align="center" width="55%">
		<tr>
			<td width="55%"></td>
			<td width="15%"><a href="selectCource.jsp"
				class="a_class button blue">所有课程</a>
			</td>
			<td width="15%"><a href="selected.jsp"
				class="a_class button blue">已选课程</a>
			</td>
		</tr>
	</table>
	<table id="table" class="hovertable" align="center" width="55%"
		border="1">
		<tr>
			<th colspan="8"><div align="center">所有课程</div></th>
		</tr>
		<tr>
			<th width="6%"><div align="center">id</div></th>
			<th width="6%"><div align="center">课程</div></th>
			<th width="4%"><div align="center">院系</div></th>
			<th width="8%"><div align="center">起始周</div></th>
			<th width="8%"><div align="center">上课时间</div></th>
			<th width="6%"><div align="center">操作</div></th>
		</tr>
		<%
			for (int i = 0; i < course.size(); i++)
			{
				CourseOffering cou = course.get(i);
				String start_endWeek = "" + cou.getStart_week() + "-"
						+ cou.getEnd_week();
				ArrayList<TimeSlot> timeSlots = cou.getTimeSlots();
				String times = "";
				for (int t = 0; t < timeSlots.size(); t++)
				{
					times += "周" + timeSlots.get(t).getDay() + ": "
							+ timeSlots.get(t).getStart_time() + "-"
							+ timeSlots.get(t).getEnd_time() + "节;  ";

				}
		%>
		<tr class="change_color">
			<td><%=cou.getId()%></td>
			<td><%=cou.getTitle()%></td>
			<td><%=cou.getDept_name()%></td>
			<td><%=start_endWeek%></td>
			<td><%=times%></td>
			<td><a
				href="<%=path%>/servlet/ProAddCou?couId=<%=cou.getId()%>
				&proId=<%=proId%>&year=<%=cou.getYear()%>&semester=<%=cou.getSemester()%>">选课</a>
			</td>
		</tr>
		<%
			}
		%>
	</table>
	<script type="text/javascript" src="<%=path%>/table_mouse_over.js"></script>
</body>
</html>