<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>订单详情</h2>
    <table cellpadding="10" cellspacing="0" border="1">
        <tr>
            <td>顾客姓名：</td>
            <td><%=session.getAttribute("username")%></td>
        </tr>
        <tr>
            <td>地址：</td>
            <td><%=session.getAttribute("address")%></td>
        </tr>
        <tr>
            <td>付款类型：</td>
            <td><%=session.getAttribute("paytype")%></td>
        </tr>
        <tr>
            <td>订货</td>
            <td>
                <%
                    String[] books = (String [])session.getAttribute("books");
                    for(String book: books){
                %>
                        <%=book%>
                <br>
                <%
                    }
                %>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="加入购物车"/></td>
        </tr>
    </table>
</body>
</html>
