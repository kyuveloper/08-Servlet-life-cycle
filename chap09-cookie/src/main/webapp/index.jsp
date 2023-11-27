<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Cookie!" %>
</h1>
<br/>
    <h1>Cookie Handling</h1>
    <form action="cookie" method="post">
        이름 : <input type="text" name="firstName"/>
        성 : <input type="text" name="lastName"/>
        <input type="submit" value="전송"/>
    </form>
</body>
</html>