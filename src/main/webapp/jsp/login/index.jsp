<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2017/11/20 0020
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    // 若可以获取到请求参数 loginName, 则打印出欢迎信息。把登录信息存储到 Cookie 中，并设置 Cookie 的最大时效为 30S
    Cookie[] cookies = request.getCookies();
    String name = request.getParameter("name");
    if(name != null && !name.trim().equals("")){
        response.getWriter().print("Hello "+name);
        Cookie cookie = new Cookie("name",name);
        cookie.setMaxAge(30);
        response.addCookie(cookie);
    }else {
        if(cookies != null && cookies.length > 0){
            //从 Cookie 中读取用户信息，若存在则打印欢迎信息
            boolean flag = false;
            for(Cookie cookie : cookies){
                String cookieName = cookie.getName();
                if(cookieName.equals("name")){
                    String value = cookie.getValue();
                    response.getWriter().print("Hello "+value);
                    flag = true;
                }
            }
            //若没有对应的Cookie则重定向到login界面
            if(flag==false){
                response.sendRedirect("login.jsp");
            }
        }
    }
%>
</body>
</html>
