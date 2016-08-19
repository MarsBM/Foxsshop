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
<c:url value="/users/update" var="update" />
<form:form method="post" action="${update}" commandName="user">
    <table>
        <tr>
            <td>
                <form:label path="login">
                    <spring:message code="user.login" />
                </form:label>
            </td>
            <td>
                ${user.login}
                <form:hidden path="login"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="createDate">
                    <spring:message code="user.createDate" />
                </form:label>
            </td>
            <td>
                ${user.createDate}
                <form:hidden path="createDate"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="password">
                    <spring:message code="user.password" />
                </form:label>
            </td>
            <td>
                <form:password path="password"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="enabled">
                    <spring:message code="user.enabled" />
                </form:label>
            </td>
            <td>
                <form:checkbox path="enabled" />
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="firstName">
                    <spring:message code="user.firstName" />
                </form:label>
            </td>
            <td>
                <form:input path="firstName"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="lastName">
                    <spring:message code="user.lastName" />
                </form:label>
            </td>
            <td>
                <form:input path="lastName"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="email">
                    <spring:message code="user.email" />
                </form:label>
            </td>
            <td>
                <form:input path="email"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="userRole">
                    <spring:message code="user.userRole" />
                </form:label>
            </td>
            <td>
                <form:select path="userRole.id">
                    <c:forEach items="${roles}" var="role">
                        <form:option value="${role.id}" label="${role.name}"/>
                    </c:forEach>
                </form:select>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="<spring:message code="user.submit"/>" />
            </td>
            <td>
                <a href="/users/list">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>



</body>
</html>