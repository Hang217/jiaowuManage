<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
#we{ margin:0 auto; width:700px; height:50px; }
</style>
  </head>
  
  <body>
  <br>
      <div id="we"><h1>欢迎，用户：${user.name},登录学校教务管理系统</h1></div> <br>
       <div style="width: 900px; margin: auto;">
					<table class="table table-bordered">
						<tr>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">操作系统版本：</td>
							<td width="23%"><%=System.getProperty("os.name") %>&nbsp;&nbsp;<%=System.getProperty("os.version") %></td>

						</tr>
						<tr>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">操作系统类型：</td>
							<td width="23%"><%=System.getProperty("os.arch") %></td>

						</tr>
						<tr>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">JDK版本：</td>
							<td width="23%"><%=System.getProperty("java.version") %></td>

						</tr>
						<tr>
							<td width="10%" align="right" nowrap="nowrap" bgcolor="#f1f1f1">作者：</td>
							<td width="23%"><a href="#" target="_blank"><font color="blue">余长权</font></a></td>

						</tr>
					</table>



				</div>
       
  </body>
</html>
