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
<form:form method="post" action="add" commandName="user">
    <table>
        <tr>
            <td>
                <form:label path="login">
                    <spring:message code="user.login" />
                </form:label>
            </td>
            <td>
                <form:input path="login" required="true"/>
            </td>
            <span>
                <c:choose>
                    <c:when test="${!empty login_is_used}">
                        <spring:message code="${login_is_used}"/>
                    </c:when>
                    <c:otherwise>
                        <form:errors path="login" ><spring:message code="err.login"/></form:errors>
                    </c:otherwise>
                </c:choose>
            </span>
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
            <span>
                <form:errors path="firstName" ><spring:message code="err.firstName"/></form:errors>
            </span>
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
            <span>
                <form:errors path="lastName" ><spring:message code="err.lastName"/></form:errors>
            </span>
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
            <span>
                <form:errors path="email" ><spring:message code="err.email"/></form:errors>
            </span>
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
            <span>
                <form:errors path="userRole" >
                    <spring:message code="err.userRole"/>
                </form:errors>
            </span>
        </tr>

        <tr>
            <td>
                <form:label path="password">
                    <spring:message code="user.password" />
                </form:label>
            </td>
            <td>
                <form:input path="password" required="true"/>
            </td>
            <span>
                <form:errors path="password" ><spring:message code="err.password"/></form:errors>
            </span>
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