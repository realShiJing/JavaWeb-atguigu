<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
SessionId:<%=session.getId()%>
<br><br>
IsNew:<%=session.isNew()%>
<br><br>
CreateTime:
<%
    long createTimeMills = session.getCreationTime();
    Date createTime = new Date(createTimeMills);
%>
<%=createTime%>
<br><br>
lastTime:<%
    long lastAccessedTime = session.getLastAccessedTime();
    Date lastTime = new Date(lastAccessedTime);
%>
<%=lastTime%>
<br><br>
SessionMaxInactiveInterval:<%=session.getMaxInactiveInterval()%>
<%
    Object username = session.getAttribute("username");
    if(username==null){
        username = "";
    }

%>
<br><br>
<form action="<%=response.encodeURL("hello.jsp")%>" method="post">
    UserName:<input type="text" name="username" value="<%=username%>"/>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
