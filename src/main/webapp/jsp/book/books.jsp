<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books Page</title>
</head>
<body>
<%
    //从Cookie中湖区浏览记录
    Cookie[] cookies = request.getCookies();
    if(cookies != null && cookies.length >0 ){
        for(Cookie cookie : cookies){
            if(cookie.getName().startsWith("Nchu_")){
                response.getWriter().println(""+cookie.getValue());
            }
        }
    }

%>
<br>
<br>
<a href="book.jsp?book=JavaWeb">JavaWeb</a><br><br>
<a href="book.jsp?book=Java">Java</a><br><br>
<a href="book.jsp?book=Orcle">Orcle</a><br><br>
<a href="book.jsp?book=Mysql">Mysql</a><br><br>
<a href="book.jsp?book=Ajax">Ajax</a><br><br>
<a href="book.jsp?book=Spring">Spring</a><br><br>
</body>
</html>
