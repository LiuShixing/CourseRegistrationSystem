<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%
String toppath = request.getContextPath();
String topbasePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+toppath+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>

<link rel="stylesheet" type="text/css" href="<%=toppath%>/header_p.css"/>
</head>

<body>
	<div id="head">
		<div id="nav">
			<ul>
			    <li class="lich"><a  class="ah" href="<%=toppath%>/Professor/home.jsp">课程注册系统</a>&nbsp;&nbsp;&nbsp;</li>
				<li class="licss"><a class="acss_2" href="<%=toppath%>/Professor/home.jsp">首页</a>&nbsp;</li>
				<li class="licss"><a class="acss_2" href="<%=toppath%>/Professor/selectCource.jsp">选课</a>&nbsp;</li>
				<li class="licss"><a class="acss_4" href="<%=toppath%>/Professor/submitGrade.jsp">提交成绩</a>&nbsp;</li>
			</ul>
		</div>
		<div>
		</div>
	</div>

</body>
</html>


 
