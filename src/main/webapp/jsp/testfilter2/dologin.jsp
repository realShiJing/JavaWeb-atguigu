<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2017/11/27 0027
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 <%
     String name = request.getParameter("name");
     session.setAttribute(application.getInitParameter("sessionKey"),name);
 %>
<%--
 ${param.name}
 ${pageContext.session.setAttribute()}
--%>
<a href="list.jsp">Return</a>


</body>
</html>
