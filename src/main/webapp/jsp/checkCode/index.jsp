<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${MessageIfo}
<form action="<%=request.getContextPath()%>/checkCodeServlet" method="post">
    Username:<input  type="text" name="username"/>
    <br><br>
    验证码：<input  type="text"  name="checkCode"/>
    <br><br>
    <img src="<%=request.getContextPath()%>/validateColorServlet">
    <br><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
