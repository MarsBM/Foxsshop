<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><spring:message code="label.title" /></title>
</head>
<body>
<c:if test="${not empty param.error}">
    <p> <spring:message code="label.loginerror" />
        : ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
    </p>
</c:if>

<form method="post" action="<c:url value="/check" />">
    <table>
        <tr>
            <td align="right"><spring:message code="label.login" /></td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td align="right"><spring:message code="label.password" /></td>
            <td><input type="password" name="password" /></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="<spring:message code="label.login"/>" />
            </td>
        </tr>
    </table>
</form>
</body>
</html>