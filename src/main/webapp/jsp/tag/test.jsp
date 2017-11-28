<%@ page import="yang.mybatis.domain.Customer" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--导入标签库描述文件--%>
<%@taglib uri="http://mycompany.com" prefix="" %>
<%@ taglib prefix="nchu" uri="http://mycompany.com" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--<nchu:hello value="${param.name}" count="10">
        HelloWorld
    </nchu:hello>--%>
<%
    List<Customer> customers = new ArrayList<Customer>();

    customers.add(new Customer(1, "Yang","13112233445","Shanghai"));
    customers.add(new Customer(2, "Zhang","13543214243","Beijiing"));
    customers.add(new Customer(3, "XIe","13343242342","HeNan"));
    customers.add(new Customer(4, "Liu","13334234334","ZhengZhou"));
    customers.add(new Customer(5, "Xiong","13342343243","ShanDong"));

    request.setAttribute("customers", customers);

%>
    <nchu:forEach items="${customers}" var="customer">
        账号：${customer.id}
        <br>
        姓名：${customer.name}
        <br>
        电话：${customer.phone}
        <br>
        地址：${customer.address}
        <br><br>
    </nchu:forEach>
</body>
</html>
