<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <title><spring:message code="label.title.home" /></title>
    <link href="/css/custom.css" type="text/css" rel="stylesheet">
</head>
<header>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
        <a href="/logout" ><spring:message code="label.logout"/></a>
    </sec:authorize>
</header>
<body>
<p>
    <a href="/controlpanel">Home</a>
</p>
<a href="/roles/new">Add role</a>
<table>
    <tr>
        <th>
            id
        </th>
        <th>
            name
        </th>
        <th>
            permission
        </th>
        <th colspan="2">

        </th>
    </tr>
    <c:forEach items="${roles}" var="role">
        <tr>
            <td>
                    ${role.id}
            </td>
            <td>
                    ${role.name}
            </td>
            <td>
                    ${role.permission}
            </td>
            <td>
                <a href="/roles/delete/${role.id}">Delete</a>
            </td>
            <td>
                <a href="/roles/edit/${role.id}">Edit</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>