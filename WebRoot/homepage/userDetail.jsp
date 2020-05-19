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
#jz{ margin:0 auto; width:320px; height:50px; }
</style>
  </head>
  
  <body>
   
       <div id="jz"><h1>用户信息</h1></div>
     <table border="1" width="100%" class="tab">
            <tr>
                <th><input type="checkbox" id="chbAll"></th>
                <th>用户编号</th>
                <th>用户姓名</th>
                <th>用户类别</th>
                
            </tr>
            <c:forEach var="user" items="${user}" varStatus="status">
                <tr>
                    <th><input type="checkbox" name="id" value="${user.id}"></th>
                    <td>${user.id}</td>
                    <td>${user.name}</td>
                   
                   <c:if test="${user.usertype==1}">
                     <td>管理员</td>
                   </c:if>
                      <c:if test="${user.usertype==2}"> 
                     <td>学生</td> 
                    </c:if> 
                      <c:if test="${user.usertype==3}"> 
                      <td>教师</td> 
                   </c:if> 
                </tr>
            </c:forEach>
        </table>
  </body>
</html>
