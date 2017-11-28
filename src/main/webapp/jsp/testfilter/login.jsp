<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2017/11/26 0026
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/jsp/testfilter/hello.jsp" method="post">
    用户名：<input type="text" name="username"/>
    密码：<input type="text" name="password"/>
    <input type="submit"/>
</form>
</body>
</html>
