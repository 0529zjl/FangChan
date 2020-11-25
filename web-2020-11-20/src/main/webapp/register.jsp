<%--
  Created by IntelliJ IDEA.
  User: 大眼萌
  Date: 2020/11/21 0021
  Time: 16:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="static/js/jquery-1.7.2.min.js"></script>
</head>
<body>
    <h1>账号注册</h1>
    <div>
        身份证明：<input id="cardId" type="text" /><br/>
        用户名：<input id="name" type="text" /><br/>
        密码：<input id="password" type="password" /><br/>
        确认密码：<input id="password2" type="password" /><br/>
        <div>
            <input id="btn1" type="button" value="注册" />
            <input id="btn2" type="button" value="返回" />
        </div>
    </div>
</body>
<script>
    $(function () {
        $("#btn1").click(function () {
            var password  = $("#password").val();
            var password1 = $("#password2").val();
            var carId = $("#carId").val();
            var name = $("#name").val();
            var cardId = $("#cardId").val();
            if (password == password1){
                $.getJSON("check/"+cardId+"/"+name+"/"+password+".do",function (result) {
                    if(result > 0){
                        alert("注册成功");
                        location.href="login.jsp";
                    }
                });
            }
        });

        $("#btn2").click(function () {
            location.href="login.jsp";
        });
    });
</script>
</html>
