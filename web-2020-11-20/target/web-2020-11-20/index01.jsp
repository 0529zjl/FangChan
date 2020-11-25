<%--
  Created by IntelliJ IDEA.
  User: 大眼萌
  Date: 2020/11/21 0021
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
</head>
<body>
    <h1>房产信息查询系统</h1>
    <div>
        <div>
            <span>用户名：${user.name}</span>
            <a href="login.jsp">退出</a>
        </div>
        <div>
            <a id="a" href="list.do" target="iframe">房产信息查询</a>
            <div>
                <iframe id="iframe" width="600px" height="400px" hidden="hidden" name="iframe"></iframe>
                <h1 id="content">欢迎使用房产信息查询系统</h1>
            </div>
        </div>
    </div>
</body>
<script>
    $(function () {
        $("#a").click(function () {
            $("#iframe").show();
            $("#content").hide();
        });
    });
</script>
</html>
