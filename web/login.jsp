<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>欢迎登录</title>
</head>
<body>
<form name="LoginForm" method="post" action="/user/login">
    <table>
        <%--<tr>--%>
        <%--<td>用户名：</td>--%>
        <%--<td><input type="text" name="username"></td>--%>
        <%--</tr>--%>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="username"></td>
        </tr>
        <tr>
            <td>密码：</td>
            <td><input type="password" name="password"></td>
        </tr>
        <tr>
        <td>验证码：</td>
        <td><input type="text" name="validateCode" placeholder="验证码"></td>
        <td><a href="#" onclick="loadImage();">
        <img src="getValidateCode" id="validateImg" height="32" alt="验证码">
        </a></td>
        </tr>
        <tr>
            <td><input type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
</html>

<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.js"></script>
<script type="text/javascript">
        function loadImage() {
            $("#validateImg").attr("src", 'getValidateCode');
        }
</script>