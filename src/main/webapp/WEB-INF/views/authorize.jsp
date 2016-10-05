<sec:authorize access="isAuthenticated()">
    <sec:authentication property="principal.username"/>
    <a href="/logout" ><spring:message code="label.logout"/></a>
</sec:authorize>