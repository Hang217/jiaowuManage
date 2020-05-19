<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-md-2">
    <ul class="nav nav-pills nav-stacked">
    <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                  
                   <c:if test="${user.usertype==1}">
                    <li>
                       <a href="admin/getUserDetail?id=${user.id }" target="right"><i class="fa fa-desktop "></i>用户：${user.name}</a>
                    </li>
                    <li>
                        <a href="stu/list" target="right"><i class="fa fa-desktop "></i>学生管理 </a>
                    </li>

                    <li>
                        <a href="tea/list"  target="right"><i class="fa fa-table "></i>教师管理</a>
                    </li>
                    <li>
                        <a href="cou/list"  target="right"><i class="fa fa-edit "></i>课程管理</a>
                    </li>
                    <li>
                        <a  href="cla/list"  target="right"><i class="fa fa-qrcode "></i>班级管理</a>
                    </li>
                    <li>
                        <a  href="admin/logout"  target="right"><i class="fa fa-qrcode "></i>注销</a>
                    </li>
                    </c:if>
                    
                    <c:if test="${user.usertype==3}">
                    <li>
                       <a href="tea/getTeaDetail?id=${user.id}" target="right"><i class="fa fa-desktop "></i>用户：${user.name}</a>
                    </li>
                    <li>
                        <a href="homepage/test2.jsp" target="right"><i class="fa fa-desktop "></i>查看课表 </a>
                        <a href="tea/test2.jsp" target="right"><i class="fa fa-desktop "></i>查看课表 </a>
                    </li>

                    <li>
                        <a href="tea/getMyStu"  target="right"><i class="fa fa-table "></i>学生管理</a>
                    </li>
                   
                    <li>
                        <a href="homepage/test.jsp"  target="right"><i class="fa fa-bar-chart-o"></i>修改密码</a>
                    </li>
                    <li>
                        <a  href="admin/logout"  target="right"><i class="fa fa-qrcode "></i>注销</a>
                    </li>
                    </c:if>
                    
                    <c:if test="${user.usertype==2}">
                    <li>
                       <a href="stu/getStuDetail?id=${user.id }" target="right"><i class="fa fa-desktop "></i>用户：${user.name}</a>
                    </li>
                    <li>
                        <a href="stu/getStuCourse" target="right"><i class="fa fa-desktop "></i>查看课表 </a>
                    </li>

                    <li>
                        <a href="homepage/test3.jsp"  target="right"><i class="fa fa-table "></i>成绩查询</a>
<!--                         <a href="homepage/test3.jsp"  target="right"><i class="fa fa-table "></i>成绩查询</a> -->
                    </li>
                    <li>
                        <a  href="stu/getXuXiu"  target="right"><i class="fa fa-qrcode "></i>选课</a>
                    </li>
                    <li>
                        <a href="homepage/test.jsp"  target="right"><i class="fa fa-bar-chart-o"></i>修改密码</a>
                    </li>
                    <li>
                        <a  href="admin/logout"  target="right"><i class="fa fa-qrcode "></i>注销</a>
                    </li>
                    </c:if>
                </ul>
             </div>

        </nav>
</ul>
</div>