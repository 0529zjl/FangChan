<%--
  Created by IntelliJ IDEA.
  User: 大眼萌
  Date: 2020/11/20 0020
  Time: 15:52
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
    请输入身份证号码:<input id="cardId" type="text" name="cardId"/><br/>
    请输入密码:<input type="password" id="password" name="password"/><br/>
    <input id="btn1" type="button" value="登录"/>
    <a href="register.jsp">注册</a>
</div>
</body>
<script type="text/javascript">
    $(function () {
        $("#btn1").click(function () {
            var cardId = $("#cardId").val();
            var password = $("#password").val();
            $.getJSON("login/" + cardId + "/" + password + ".do",function (user) {
                if (user != null) {
                    location.href = "index01.jsp";
                } else {
                    alert("该账户不存在，请先注册");
                }
            });
        });
    });
</script>
</html>
</script>