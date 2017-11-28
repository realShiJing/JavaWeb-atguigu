<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Shopping Page</h2>
<form action="<%=request.getContextPath()%>/processStep1" method="post">
    <table cellpadding="10" cellspacing="0" border="1">
        <tr>
            <td>书籍</td>
            <td>购买</td>
        </tr>
        <tr>
            <td>Java</td>
            <td><input type="checkbox" name="book" value="Java"/></td>
        </tr>
        <tr>
            <td>Oracle</td>
            <td><input type="checkbox" name="book" value="Oracle"/></td>
        </tr>
        <tr>
            <td>Spring</td>
            <td><input type="checkbox" name="book" value="Spring"/></td>
        </tr>
        <tr>
            <td>MySql</td>
            <td><input type="checkbox" name="book" value="MySql"/></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="加入购物车"/></td>
        </tr>
    </table>
</form>
</body>
</html>
