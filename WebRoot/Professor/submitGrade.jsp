<%@page import="bean.DbManager"%>
<%@page import="bean.StudentGrade"%>
<%@page import="bean.Teach"%>
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
<title>提交成绩</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/table.css" />
<link rel="stylesheet" type="text/css" href="<%=path%>/button.css" />

<script type="text/javascript" src="script.js"></script>
</head>

<body>
	<%@ include file="homeTop.jsp"%>
	<%@ include file="/msg.jsp"%>

	<%!ArrayList<Teach> teachs = null;
	ArrayList<StudentGrade> students = null;
	DbManager dbManager = new DbManager();
	int proId;
	int selectedCouId;%>
	
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
		teachs = dbManager.queryLastTeach(proId);
		if (teachs != null)
		{
			String selectId = request.getParameter("selectId");
			if (selectId != null)
			{
				selectedCouId = Integer.parseInt(selectId);
				students = dbManager.queryALLStudents(selectedCouId, teachs
						.get(0).getPro_id());
			} else
			{
				selectedCouId = teachs.get(0).getCouOffer_id();
				students = dbManager.queryALLStudents(selectedCouId, teachs
						.get(0).getPro_id());
			}
		}
	%>
	<form
		action="<%=path%>/servlet/SubmitGrade?couId=<%=selectedCouId%>&proId=<%=proId%>"
		method="post" onsubmit="return checkInput()">
		<table align="center" width="35%" border="1px" class="hovertable">
			<tr>
				<th><div align="center">课程</div></th>
				<th><div align="center">学生</div></th>
			</tr>
			<tr>
				<td width="30%">
					<table>
						<%
							if (teachs != null)
							{
								for (Teach teach : teachs)
								{
						%>
						<tr onclick="">
							<td><%=teach.getCouOffer_id()%></td>
							<td><a
								href="submitGrade.jsp?selectId=<%=teach.getCouOffer_id()%>"><%=teach.getTitle()%></a>
							</td>
						</tr>
						<%
							}
							}
						%>
					</table></td>
				<td width="70%">

					<table id="ingrade">
						<tr>
							<th><div align="center">ID</div></th>
							<th><div align="center">姓名</div></th>
							<th><div align="center">成绩</div></th>
						</tr>

						<%
							if (students != null)
							{
								for (StudentGrade sGrade : students)
								{
						%>
						<tr onclick="">
							<td><%=sGrade.getId()%></td>
							<td><%=sGrade.getName()%></td>
							<td><input name="<%=sGrade.getId()%>" type="text"
								value="<%=sGrade.getGrade()%>" /></td>
						</tr>
						<%
							}
							}
						%>
					</table></td>
			</tr>
			<tr>
			
				<td colspan="2"><div align="center"><input  type="submit" class="button blue"
					value="提交" /></div>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>