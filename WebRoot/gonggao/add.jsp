<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<link href="<c:url value="/styles/main.css" />" type="text/css" rel="stylesheet" />
<title>添加公告</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>添加公告</span></h2>
        <form action="addSave" method="post" >
        <fieldset>
            <legend>公告</legend>
            <p>
                <label for="name">公告名称：</label>
                <input type="text" name="name">
            </p>
            <p>
                <label for="content">公告内容：</label>
                <input type="text" name="content">
            </p>
              <p>
                <label for="date">公告时间：</label>
                 <input type="date" name="date">
            </p>
            <p>
              <input type="submit" value="保存" class="btn out">
            </p>
        </fieldset>
        </form>
        <p style="color: red">${message}</p>
        <form:errors path="*"></form:errors>
        <p>
            <a href="<c:url value="/admin/getGonggao" />"  class="abtn out">返回列表</a>
        </p>
    </div>
</body>
</html>
