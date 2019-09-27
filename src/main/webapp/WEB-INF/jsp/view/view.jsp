<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>View user</title>
</head>
<body>

<h2>View user</h2>
<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
<p>
    <tt>You are logged in as: <sec:authentication property="principal.username" /></tt>
</p>
<p>
    <a href="<c:url value="/admin/list" />">Back to list users</a>
</p>
<table border="0" width="300" cellpadding="5">
    <tbody>
    <tr>
        <td>Nickname</td>
        <td>${user.username}</td>
    </tr>
    <tr>
        <td>First name</td>
        <td>${user.firstName}</td>
    </tr>
    <tr>
        <td>Last name</td>
        <td>${user.lastName}</td>
    </tr>
    <tr>
        <td>Email</td>
        <td>${user.email}</td>
    </tr>
    <tr>
        <td>Address</td>
        <td>${user.address}</td>
    </tr>
    <tr>
        <td>Phone number</td>
        <td>${user.phoneNumber}</td>
    </tr>
    <tr>
        <td>Birth date</td>
        <td>
            <fmt:formatDate value="${user.birthDate}" type="date" dateStyle="medium"/>
        </td>
    </tr>
    <tr>
        <td>User role</td>
        <td>
            ${user.role}
        </td>
    </tr>
    </tbody>
</table>
</form>
</body>
</html>