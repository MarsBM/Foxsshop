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
</head>
<header>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
        <a href="/logout" ><spring:message code="label.logout"/></a>
    </sec:authorize>
</header>
<body>
    <p>
        <a href="/users/list">Users</a>
    </p>

    <%--<form:form method="post" action="add" commandName="user">
        <table>
            <tr>
                <td><form:label path="firstName">
                        <spring:message code="user.firstName" />
                    </form:label>
                </td>
                <td>
                    <form:input path="firstName" title="firstName"/>
                </td>
            </tr>
            <tr>
                <td><form:label path="email">
                    <spring:message code="user.email" />
                </form:label>
                </td>
                <td>
                    <form:input path="email" title="email"/>
                </td>
            </tr>

            <tr>
                <td>
                    <input class="btn" type="submit" value="<spring:message code="user.submit"/>" />
                </td>
                <td>
                    <a href="/">Cancel</a>
                </td>
            </tr>
        </table>
    </form:form>--%>
</body>
</html>