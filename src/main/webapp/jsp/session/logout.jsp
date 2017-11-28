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
<br><br>
<%
    Object username = session.getAttribute("username");
    if(username == null){
        username = "";
    }

%>
  bey: <%=username%>

<%
    session.invalidate();
%>
<br><br>
<a href="login.jsp" >重新登录</a>
<br><br>
<br><br>

</form>
</body>
</html>
