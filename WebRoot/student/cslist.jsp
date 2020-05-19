<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<c:url value="/styles/main.css"/>"  type="text/css" rel="stylesheet" />
<%-- <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/styles/bootstrap/css/bootstrap.min.css"> --%>
	<!-- 引入JQuery  bootstrap.js--> 
<%-- 	<script src="${pageContext.request.contextPath}/styles/bootstrap/js/jquery-1.10.2.js"></script> --%>
<%-- 	<script src="${pageContext.request.contextPath}/styles/bootstrap/js/bootstrap.min.js"></script> --%>
<title>查看课程</title>
</head>
<body>
    <div class="main">
        <h2 class="title"><span>课表查看</span> </h2>
		<form class="form-search" action="${pageContext.request.contextPath}/cou/getCouByName" method="post">
			<input type="text" placeholder="请输入课程.."
				class="input-medium search-query" name="couName">
			<button type="submit" class="btn">Search</button>
		</form>

		<form action="<c:url value="/cou/deletes?pageNO=${pageNO}"/>" method="post">
        <table border="1" width="100%" class="tab">
            <tr>
                <th>课程名称</th>
                <th>课程类别</th>
                <th>代课老师</th>
            </tr>
            <c:forEach var="entity" items="${ctlist}" varStatus="status">
                <tr>
                    <td>${entity.name}</td>
                    <td>
                      <c:if test="${entity.type==1}">
                                                   选修课
                      </c:if>
                      <c:if test="${entity.type==0}">
                                                    必修课
                      </c:if>
                    </td>
                    <td>${entity.tname}</td>
                    
                </tr>
            </c:forEach>
            
            <c:forEach var="entity" items="${coulist}" varStatus="status">
                <tr>
                    <td>${entity.couName}</td>
                    <td>
                      <c:if test="${entity.type==1}">
                                                   选修课
                      </c:if>
                      <c:if test="${entity.type==0}">
                                                    必修课
                      </c:if>
                    </td>
                    <td>${entity.teaName}</td>
                    
                </tr>
            </c:forEach>
        </table>
        <script type="text/javascript" src="<c:url value="/scripts/jquery-1.10.2.min.js"/>" ></script>
    </form>
    </div>
</body>
</html>
