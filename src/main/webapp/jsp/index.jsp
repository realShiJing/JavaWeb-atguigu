<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: root
  Date: 2017/11/18 0018
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.8.3.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                <!--获取删除记录的名字-->
                var content = $(this).parent().parent().find("td:eq(1)").text();
                <!--确定：继续执行，取消：停止-->
                var flag = confirm("确定要删除"+content+"的信息吗？");
                return flag;
            })
        })

    </script>
</head>
<body>
<form action="query.do" method="post">
    <table border="1" cellpadding="10" cellspacing="0"  align="center">
        <tr>
            <td>CustomerName:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>CustomePhone:</td>
            <td><input type="text" name="phone"/></td>
        </tr>
        <tr>
            <td>CustomerAddress:</td>
            <td ><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td colspan="2" align="center" ><input type="submit" value="查询" /></td>
        </tr>
        <tr>
            <td colspan="2" align="center" ><a href="addCustomer.jsp" >CreateCustomer</a></td>
        </tr>
    </table>
<br>
<br>
<br>
<br>
<br>
    <c:if test="${customers!= null&&customers.size()>0}">
        <table border="1" cellpadding="10" cellspacing="0"  align="center">
            <tr>
               <th>ID</th>
               <th>Name</th>
               <th>Phone</th>
               <th>Address</th>
                <th>UPDATE/DElETE</th>
            </tr>

            <c:forEach items="${customers}"  var="customer">
                <tr>
                    <td>${customer.id}</td>
                    <td>${customer.name}</td>
                    <td>${customer.phone}</td>
                    <td>${customer.address}</td>
                    <td><a href="edit.do?id=${customer.id}">UPDATE</a>
                        <a href="delete.do?id=${customer.id} " class="delete" >DElETE</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</form>

</body>
</html>
