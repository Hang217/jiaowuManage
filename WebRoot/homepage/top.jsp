<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="WebPath" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'top.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

</head>

<body background="images/bg.png">
	<br />
	<div>
		<table width="100%">
			<tr>
				<td width="165px"></td>
				<td><font face="SimSun" color="#6495ED" size="26">学校教务管理系统</font></td>
				 <td align="right" valign="bottom" style="padding-right: 30px">
					<font face="SimSun" color="#6495ED" style="text-decoration: none"
					size="5"> 欢迎您! &nbsp;${user.name } </font> 
					<a class="cur"  href="javascript:" onclick="toLoginOut()">退出</a> 
				</td> 
			</tr>
		</table>
	</div>
	<script  type="text/javascript">
		function toLoginOut(){
			window.top.location.href = '${WebPath}/admin/logout.action';
		}
	</script>
</body>
</html>

