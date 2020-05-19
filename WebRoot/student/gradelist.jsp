<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/styles/main.css"/>"  type="text/css" rel="stylesheet" />
<title>成绩查询</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>成绩查询结果</span></h2>
        <form action="#" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th>学生姓名</th>
                <th>住址</th>
                <th>代课老师</th>
                <th>课程名称</th>
                <th>期末成绩</th>
                <th>平均成绩</th>
                <th>平时成绩</th>
            </tr>
            <c:forEach var="entity" items="${listMap}" varStatus="status">
                <tr>
                    <td>${entity.stuName}</td>
                    <td>${entity.address}</td>
                    <td>${entity.teaName}</td>
                    <td>${entity.couName}</td>
                    <td>${entity.pgrade}</td>
                    <td>${entity.kgrade}</td>
                    <td>${entity.zgrade}</td>
                   
                    
                </tr>
            </c:forEach>
        </table>
        <script type="text/javascript" src="<c:url value="/scripts/jquery-1.10.2.min.js"/>" ></script>
    </form>
    </div>
</body>
</html>
