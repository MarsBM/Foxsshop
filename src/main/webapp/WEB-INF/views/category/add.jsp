<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/custom.css" >

    <title><spring:message code="category.add.page.title" /></title>

    <%--URL`s--%>
    <c:url value="/logout" var="logout" />
    <c:url value="/categories/list" var="list_url" />
    <c:set var="add_action" value="/categories/add"/>
    <c:set var="comandName" value="category"/>
    <%----%>
</head>

<header>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
        <a href="${logout}" ><spring:message code="label.logout"/></a>
    </sec:authorize>
</header>
<%@ include file="../nav.jsp"%>
<body>
<form:form method="post" action="${add_action}" commandName="${comandName}" class="form-horizontal">
    <div class="container">

        <div class="row">
            <%@ include file="../alerts.jsp"%>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">

                    <div class="panel-heading">
                        <spring:message code="category.add.panel.title" />
                    </div>

                    <div class="panel-body">
                        <div>
                            <!-- Nav tabs -->
                            <ul class="nav nav-tabs" role="tablist">
                                <li role="presentation" class="active"><a href="#main" aria-controls="main" role="tab" data-toggle="tab">
                                    <spring:message code="total.settings" />
                                </a></li>
                                <c:forEach items="${languages}" var="lang">
                                    <li role="presentation"><a href="#${lang.name}" aria-controls="${lang.name}" role="tab" data-toggle="tab">${lang.name}</a></li>
                                </c:forEach>
                            </ul>

                            <!-- Tab panes -->
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane active" id="main">

                                    <form:hidden path="id"/>
                                    <div class="form-group">
                                        <form:label path="imageFilePath" class="col-sm-2 control-label">
                                            <spring:message code="category.label.imageFilePath" />
                                        </form:label>
                                        <div class="col-sm-10">
                                            <form:input path="imageFilePath" class="form-control"/>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <form:label path="enabled" class="col-sm-2 control-label">
                                            <spring:message code="category.label.enabled" />
                                        </form:label>
                                        <div class="col-sm-10">
                                            <form:checkbox path="enabled" class="checkbox"/>
                                        </div>
                                    </div>

                                </div>

                                <c:forEach items="${languages}" var="lang">
                                    <div role="tabpanel" class="tab-pane" id="${lang.name}">
                                        <c:forEach items="${category.descriptions}" var="d" varStatus="status">
                                            <c:if test="${d.language.code eq lang.code}">
                                                <div class="form-group">
                                                    <form:hidden path="descriptions[${status.index}].language.code" class="form-control" />
                                                </div>
                                                <div class="form-group">
                                                    <form:errors path="descriptions[${status.index}].name">
                                                        <p class="text-danger col-sm-offset-2 col-sm-10">
                                                            <spring:message code="category.err.name" />
                                                        </p>
                                                    </form:errors>
                                                    <form:label path="descriptions[${status.index}].name" class="col-sm-2 control-label">
                                                        <spring:message code="category.label.name" />
                                                    </form:label>
                                                    <div class="col-sm-10">
                                                        <form:textarea path="descriptions[${status.index}].name" class="form-control"/>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <form:errors path="descriptions[${status.index}].description">
                                                        <p class="text-danger col-sm-offset-2 col-sm-10">
                                                            <spring:message code="category.err.description" />
                                                        </p>
                                                    </form:errors>
                                                    <form:label path="descriptions[${status.index}].description" class="col-sm-2 control-label">
                                                        <spring:message code="category.label.description" />
                                                    </form:label>
                                                    <div class="col-sm-10">
                                                        <form:textarea path="descriptions[${status.index}].description" class="form-control"/>
                                                    </div>
                                                </div>
                                            </c:if>
                                        </c:forEach>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div><%--.panel-body--%>

                    <div class="panel-footer">
                        <a href="${list_url}" class="btn btn-danger">
                            <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
                            <spring:message code="btn.cancel" />
                        </a>
                        <button type="submit" id="add" data-loading-text="<spring:message code="btn.add" />" class="btn btn-primary" autocomplete="off">
                            <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
                            <spring:message code="btn.add" />
                        </button>
                    </div>

                </div><%--.panel--%>
            </div>
        </div>
    </div> <%--.container--%>
    <%----%>
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-lg">Large modal</button>

    <div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <%@ include file="../filemanager.jsp"%>
            </div>
        </div>
    </div>
    <%----%>
</form:form>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/custom.js"></script>
</body>
</html>