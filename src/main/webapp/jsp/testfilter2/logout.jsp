<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.getSession().removeAttribute(application.getInitParameter("sessionKey"));
    response.sendRedirect(request.getContextPath()+"/jsp/testfilter2/list.jsp");
%>

</body>
</html>
