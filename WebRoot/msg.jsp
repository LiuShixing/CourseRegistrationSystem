
<%
	String msg = (String) request.getParameter("msg");
	if (msg != null) {
%>
<script type="text/javascript" language="javascript">
		alert('<%=msg%>');
</script>
<%
	}
%>