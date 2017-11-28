<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2017/11/19 0019
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Customer Page</title>
</head>
<body>
<form action="update.do" method="post">
<h4 align="center"><font color="red"> ${message}</font></h4>
  <%--隐藏域在页面之间传递数据--%>
    <input type="hidden" name="id" value="${id}"/>
    <table border="1" cellpadding="10" cellspacing="0"  align="center">
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name"value="${name}"/></td>
        </tr>
        <tr>
            <td>CustomePhone:</td>
            <td><input type="text" name="phone" value="${phone}"/></td>
        </tr>
        <tr>
            <td>CustomerAddress:</td>
            <td ><input type="text" name="address" value="${address}"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center" ><input type="submit" value="修改" /></td>
        </tr>
    </table>
</form>
</body>
</html>
