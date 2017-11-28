<%@ page import="java.util.Date" %>
<%@ page import="yang.mybatis.servlet.token.TokenProcessor" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--<%
    String tokenValue = new Date().getTime()+"";
    session.setAttribute("token",tokenValue);
%>--%>
<form action="<%=request.getContextPath()%>/tokenServlet" method="post">
    <input  type="hidden"  name="TOKEN_KEY" value=<%=TokenProcessor.getInstance().saveToken(request)%> />
    Username:<input  type="text" name="username"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
