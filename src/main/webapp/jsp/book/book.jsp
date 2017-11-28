<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BookDeatil Page</title>
</head>
<body>
<br>
<br>
Book: <%= request.getParameter("book")
%>
<%
    //通过request获取books页面的请求数据
    String book = request.getParameter("book");
    //获取浏览器一次会话的所有cookie
    Cookie[] cookies = request.getCookies();
    //用于存放匹配“Nchu_”前缀的cookie
    List<Cookie> nchuCookies = new ArrayList<Cookie>();
    //要删除的cookie
    Cookie tempCookie = null;
    if(cookies.length > 0 && cookies != null){
        for(Cookie coo : cookies){
            String cookieName = coo.getName();
            //获取匹配"Nchu_"的cookie
            if(cookieName.startsWith("Nchu_")){
                nchuCookies.add(coo);
                if(coo.getValue().equals(book)){
                    tempCookie = coo;
                }
            }
        }
    }
    //如果匹配的cookie的数量大于等于五，判断tempCookie是否为空，若为空删除第一个，如不为空当前删除
    if(nchuCookies.size() >= 5 && tempCookie == null){
            tempCookie = nchuCookies.get(0);
    }
    //有相同的cookie都要把这个cookie删除
    if(tempCookie != null ){
        tempCookie.setMaxAge(0);
        response.addCookie(tempCookie);
    }
    //将books页面传过来的值放入Cookie中
    Cookie cookie = new Cookie("Nchu_"+book,book);
    response.addCookie(cookie);

%>
<br>
<a href="books.jsp">Return</a>
</body>
</html>
