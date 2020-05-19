<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/styles/main.css" />" type="text/css"
    rel="stylesheet" />
<title>编辑教师</title>
<base href="<c:url value="/" />" />
</head>
<body>
    <div class="main">
        <h2 class="title">
            <span>编辑教师</span>
        </h2>
        <form:form action="tea/editSave" modelAttribute="entity">
         
            <fieldset>
                <legend>教师</legend>
                 
           
                <tr>
                   
                    <td><input type="hidden" name="id" value="${entity.id}"></td><br>
                    <td>教师名称：<input type="text" name="name" value="${entity.name}"></td><br>
                    <td>登录名：<input type="text" name="loginname" value="${entity.loginname}"></td><br>
                    <td>密码：<input type="password" name="password" value="${entity.password}"></td><br>
                    <%-- <td>${entity.type}</td> --%>
                  
                </tr>
    

            
           
            <input type="submit" value="保存" class="btn out">
            </fieldset>
        </form:form>
        <p style="color: red">${message}</p>
        <form:errors path="*"></form:errors>
        <p>
            <a href="tea/list" class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>