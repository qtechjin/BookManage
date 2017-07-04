<%@ page contentType="text/html;charset=utf-8" language="java" %>
<%@ page import="com.xiaomi.example.pojo.User" %>
<%@ page import="com.xiaomi.example.dal.dao.impl.BookDAOImpl" %>
<%@ page import="com.xiaomi.example.dal.dataobject.BookDO" %>
<html>
<title>测试</title>
<style>
    .table-c table{border-right: 1px solid #F00; border-bottom: 1px solid #F00}
    .table-c table td{border-left: 1px solid #F00; border-top: 1px solid #F00}
</style>
<body>
<h2>Hello World!</h2>

    <a href="servlet/user">user</a>
    <a href="servlet/book">book</a>
    <a href="servlet/order">order</a>
    <br>
    <form name="userinfo" method="post" action="login">
        <div class="table-c">
        <table cellpadding="0" cellspacing="0">
            <tr>
                <td><p align="center">用户名</p></td>
                <td><input type="text" name="username" value= "..."></td>
            </tr>
            <tr>
                <td><p align="center">密　码</p></td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td colspan="2">
                <p align="center"><input type="submit" name="Submit" value="登录">
                <input name="reset" type="reset" value="取消"></p>
                </td>
            </tr>
        </table>
        </div>
    </form>
    <a href="login">login</a>
</body>
</html>
