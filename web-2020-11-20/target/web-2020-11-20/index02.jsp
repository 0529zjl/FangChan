<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 大眼萌
  Date: 2020/11/21 0021
  Time: 17:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
</head>
<body>
    <h2>房产信息查询</h2>
    <div>
        <div>
            查询类型：<select id="type">
            <option value="1">用户名</option>
            <option value="2">身份证</option>
        </select>
            <input id="content" type="text" />
            <input id="btn1" type="button" value="查找" />
        </div>
        <div>
            <table border="1px">
                <tr>
                    <td>序号</td>
                    <td>项目名称</td>
                    <td>产权人</td>
                    <td>身份证号</td>
                    <td>房屋类型</td>
                    <td>使用面积</td>
                    <td>建造时间</td>
                </tr>
                <c:forEach items="${pageList.list}" var="page">
                    <tr>
                        <td>${page.id}</td>
                        <td>${page.projectname}</td>
                        <td>${page.user.name}</td>
                        <td>${page.cardid}</td>
                        <td>${page.housetype}</td>
                        <td>${page.area}</td>
                        <td>${page.buildtime}</td>
                    </tr>
                </c:forEach>
            </table>
            <c:if test="${not pageList.isFirstPage}">
                <a href="list.do?pageNum=${pageList.firstPage}">首页</a>
            </c:if>
            <c:if test="${pageList.hasPreviousPage}">
                <a href="list.do?pageNum=${pageList.prePage}">上一页</a>
            </c:if>
            <c:forEach items="${pageList.navigatepageNums}" var="i">
                <c:if test="${i==pageList.pageNum}">
                    <a href="list.do?pageNum=${i}">[${i}]</a>
                </c:if>
                <c:if test="${i!=pageList.pageNum}">
                    <a href="list.do?pageNum=${i}">${i}</a>
                </c:if>
            </c:forEach>
            <c:if test="${pageList.hasNextPage}">
                <a href="list.do?pageNum=${pageList.nextPage}">下一页</a>
            </c:if>
            <c:if test="${not pageList.isLastPage}">
                <a href="list.do?pageNum=${pageList.lastPage}">末页</a>
            </c:if>
            <span>共${pageList.pages}页,${pageList.total}条记录 到第</span>
            <input id="pageNum" type="text" />页<input type="button" onclick="page()" value="确认" />
        </div>
    </div>
</body>
<script>
    $(function () {
        $("#btn1").click(function () {
            var type = $("#type").val();
            var content = $("#content").val();
            location.href="list.do?type="+type+"&content="+content;
        });
    });
</script>
</html>
