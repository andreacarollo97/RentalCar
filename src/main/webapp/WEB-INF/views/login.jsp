<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<%@include file="header.jsp"%>
<div class="contact-box">
    <h1>Login</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" class="input-field" placeholder="Username"  name="username" required>
        <input type="password" class="input-field" placeholder="Password"  name="password" required>
        <button type="submit" class="btn">Login</button>
    </form>
</div>
</body>
</html>