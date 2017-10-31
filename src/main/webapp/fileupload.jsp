<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<h2>文件上传实例</h2>


<form action="/myAction/fileUpload.action" method="post" enctype="multipart/form-data">
    <p>选择文件:</p>
    <input type="file" name="file">
    <input type="submit" value="提交">
</form>
</body>
</html>
