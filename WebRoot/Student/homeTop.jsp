<%@ page contentType="text/html; charset=utf-8" language="java"
	import="java.sql.*" errorPage=""%>
<%
String toppath = request.getContextPath();
String topbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+toppath+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" type="text/css" href="../header_s.css"/>
</head>

<body>
	<div id="head">
		<div id="nav">
			<ul>
			    <li class="lich"><a  class="ah" href="home.jsp">课程注册系统</a>&nbsp;&nbsp;&nbsp;</li>
				<li class="licss"><a class="acss_2" href="home.jsp">主页</a>&nbsp;</li>
				<li class="licss"><a class="acss_2" href="courses.jsp">课表</a>&nbsp;</li>
				<li class="licss"><a class="acss_2" href="register.jsp">选课</a>&nbsp;</li>
				<li class="licss"><a class="acss_2" href="grades.jsp">成绩</a>&nbsp;</li>
			</ul>
		</div>
		<div>
		</div>
	</div>

</body>
</html>