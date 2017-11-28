<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //记录用户上次访问该页面的时间
    Cookie[] cookies = request.getCookies();
    Cookie timeCookie = null;
    Cookie JSessionId = null;
    if(cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String cookieName = cookie.getName();
            if (cookieName.equals("time")) {
               timeCookie = cookie;
            }
            if(cookieName.equals("JSESSIONID")){
                JSessionId = cookie;
            }
        }
    }
    if(timeCookie != null){
        String value = timeCookie.getValue();
        response.getWriter().print("用户上次访问该网页的时间是： " + value);
    }else {
        response.getWriter().print("用户第一次访问该网页");
    }
    timeCookie = new Cookie("time",(new Date()).toString());

    timeCookie.setMaxAge(999999);

    response.addCookie(timeCookie);
%>
<br>
<br>
<%
    if(JSessionId != null){
        String value = JSessionId.getValue();
        response.getWriter().print("JSESSIONID： " + value);
    }

%>
</body>
</html>
