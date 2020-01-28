<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: akash
  Date: 15/10/18
  Time: 10:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<form:errors path="userDTO"/>
<%--<form method="post" action="/studentMultiple/submitForm">
    <label>Username</label>
    <input name="username" type="text">
    <label>Age</label>
    <input name="age" type="text">
    <label>Email</label>
    <input name="Email" type="text">
    <label>Password</label>
    <input name="password" type="password">
    <input type="submit">
</form>--%>
<form method="post" action="/submittform.html">
    <label>username</label>
    <input name="UserName" type="text">
    <label>LastName</label>
    <input name="LastName" type="text">
    <input type="submit">
</form>
<h1>${heading}</h1>
</body>
</html>
