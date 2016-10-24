<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>欢迎光临</title>
</head>
<body>
<center>
<table>
    <tr><td><a href="register.jsp">注册</a></td></tr>
    <tr><td><a href="login.jsp">登录</a></td></tr>
</table>
</center>
</body>
</html>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">
    //    function loadImage() {
    //        $("#validateImg").attr("src", 'getValidateCode');
    //    }

    $(document).ready(function () {
        var baseUrl='<%=basePath%>';

        $("#login").click(function () {
            if (document.LoginForm.user_id.value == "") {
                alert("账号不能为空!");
                document.LoginForm.user_id.focus();
            } else if (document.LoginForm.password.value == "") {
                alert("密码不能为空!");
                document.LoginForm.password.focus();
            } else {
                var saveData = {user_id:"1",password:"0"};
                $.ajax({
                    url: baseUrl+'login',
                    type: 'POST',
                    //dataType: 'json',
                    aync:false,
                    contentType:"application/json",  //发送至服务器的类型
                    data: {user_id:"1",password:"0"},
                    success:function(result){
                        //debugger;
                        console.log(result);
                    }
                });
            }
        });

    });
</script>