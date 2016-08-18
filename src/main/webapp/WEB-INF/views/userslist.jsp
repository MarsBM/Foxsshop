<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><spring:message code="label.title.home" /></title>
    <link href="/css/main.css" type="text/css" rel="stylesheet">
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
${test}
<a href="/users/add-user">Add user</a>
<table>
    <tr>
        <th>
            login
        </th>
        <th>
            firstName
        </th>
        <th>
            lastName
        </th>
        <th>
            email
        </th>
        <th>
            isEnabled
        </th>
        <th>
            createDate
        </th>
        <th>
            userRole
        </th>
        <th colspan="2">

        </th>
    </tr>
    <c:forEach items="${users}" var="u">
            <tr>
                <td>
                    ${u.login}
                </td>
                <td>
                    ${u.firstName}
                </td>
                <td>
                    ${u.lastName}
                </td>
                <td>
                    ${u.email}
                </td>
                <td>
                    ${u.enabled}
                </td>
                <td>
                    ${u.createDate}
                </td>
                <td>
                    ${u.userRole.name}
                </td>
                <td>
                    <a href="/users/delete/${u.login}">Delete</a>
                </td>
                <td>
                    <a href="/users/edit/${u.login}">Edit</a>
                </td>
            </tr>
    </c:forEach>
</table>

</body>
</html>