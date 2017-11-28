<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    <a href="/myAction/listAllStudent.action">SpringMvc</a>
    <a href="/listAllStudent">Servlet</a>
    <br>
    <table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>密码</th>
        <th>删除</th>
    </tr>
        <c:forEach items="${list}" var="user">
        <tr>
            <td> ${user.id}</td>
            <td> ${user.user_name}</td>
            <td> ${user.age}</td>
            <td> ${user.password}</td>
            <td><a href="/deleteServlet?id=${user.id}">Delete</a></td>
        </tr>
        </c:forEach>
    </table>

</body>
</html>
