<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>填写个人信息</h2>
<form action="<%=request.getContextPath()%>/processStep2" method="post">
    <table cellpadding="10" cellspacing="0" border="1">
        <tr>
            <td colspan="2">基本信息</td>
        </tr>
        <tr>
            <td>姓名：</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>寄送地址：</td>
            <td><input type="text" name="address"/></td>
        </tr>
        <tr>
            <td>付款类型</td>
            <td>
                支付宝：<input  type="radio" name="paytype"value="alipay"/>
                微信支付：<input  type="radio" name="paytype"value="wechatpay"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="提交订单"/></td>
        </tr>
    </table>
</form>
</body>
</html>
