<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Users List</title>
</head>
<body>
<h2>Users list</h2>
<%--<p>--%>
<%--    <a href="<c:url value="/logout" />">Logout</a>--%>
<%--</p>--%>
<form action="/logout" method="post">
    <input value="Logout" type="submit">
</form>
<p>
    <tt>You are logged in as: <sec:authentication property="principal.username" /></tt>
</p>
<c:choose>
    <c:when test="${fn:length(users) == 0}">
        <p>
            <i>There are no users in the DB</i>
        </p>
    </c:when>
    <c:otherwise>
        <table border="0" cellspacing="3" cellpadding="5">
            <thead>
            <tr>
                <th>Id</th>
                <th>Username</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Email</th>
                <th>Address</th>
                <th>Phone number</th>
                <th>Birth date</th>
                <th>Role</th>
                <th>Action</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                        <%--                    <td><fmt:formatDate type="both" dateStyle="medium" value="${user.dateCreated}"/></td>--%>
                        <%--                    <td><fmt:formatDate type="both" dateStyle="medium" value="${user.lastUpdate}"/></td>--%>
                    <td><c:out value="${user.username}"/></td>
                    <td><c:out value="${user.firstName}"/></td>
                    <td><c:out value="${user.lastName}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.address}"/></td>
                    <td><c:out value="${user.phoneNumber}"/></td>
                    <td><fmt:formatDate value="${user.birthDate}" pattern="dd-MMM-yyyy"/></td>
                    <td><c:out value="${user.role}"/></td>
                    <td>
                        <a href="<c:url value="view/${user.id}" />">
                            View
                        </a>
                        /
                        <a href="<c:url value="edit/${user.id}" />">
                            Edit
                        </a>
                        /
                        <a href="<c:url value="delete/${user.id}" />">
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>
<p>
    <a href="<c:url value="/admin/add" />">Add user</a>
</p>

</body>
</html>