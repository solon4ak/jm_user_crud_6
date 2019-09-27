<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit user</title>
</head>
<body>
<h2>Edit user</h2>
<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
<p>
    <tt>You are logged in as: <sec:authentication property="principal.username" /></tt>
</p>
<%--@elvariable id="userForm" type="ru.solon4ak.controller.AdminController.UserForm"--%>
<form:form modelAttribute="userForm" method="post">
    <table cellspacing="3">
        <tbody>
        <tr>
            <td><form:label path="nickName">Nickname</form:label></td>
            <td><form:input path="nickName" disabled="true"/></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password"/></td>
        </tr>
        <tr>
            <td><form:label path="firstName">First name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><form:label path="email">Email</form:label></td>
            <td><form:input path="email"/></td>
        </tr>
        <tr>
            <td><form:label path="address">Address</form:label></td>
            <td><form:input path="address"/></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber">Phone number</form:label></td>
            <td><form:input path="phoneNumber"/></td>
        </tr>
        <tr>
            <td><form:label path="birthDate">Birth date (21.10.1991)</form:label></td>
            <td><form:input path="birthDate"/></td>
        </tr>
        <tr>
            <td><form:label path="role">User role</form:label></td>
            <td>
                <form:select path="role" items="${roles}" size="1"/>
            </td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Submit"/></td>
        </tr>
        </tbody>
    </table>

</form:form>

</body>
</html>