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
<c:url value="/roles/update" var="update" />
<form:form method="post" action="${update}" commandName="role">
    <table>
        <tr>
            <td>
                <form:label path="id">
                    <spring:message code="role.id" />
                </form:label>
            </td>
            <td>
                    ${role.id}
                <form:hidden path="id"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="name">
                    <spring:message code="role.name" />
                </form:label>
            </td>
            <td>
                <form:input path="name"/>
            </td>
        </tr>

        <tr>
            <td>
                <form:label path="permission">
                    <spring:message code="role.permission" />
                </form:label>
            </td>
            <td>
                <form:input path="permission"/>
            </td>
        </tr>

        <tr>
            <td>
                <input type="submit" value="<spring:message code="role.submit"/>" />
            </td>
            <td>
                <a href="/roles/list">Cancel</a>
            </td>
        </tr>
    </table>
</form:form>



</body>
</html>