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
</head>
<header>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
        <a href="/logout" ><spring:message code="label.logout"/></a>
    </sec:authorize>
</header>
<%@ include file="../nav.jsp"%>
<body>
<div class="container-fluid">
    <div class="row">
        <%@ include file="../alerts.jsp"%>
    </div>
    <div class="row">
        <div class="col-lg-12">

        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <spring:message code="category.add.panel.title" />
                </div>
                <div class="panel-body">
                    <form:form action="add" commandName="category" method="post" class="form-horizontal" enctype="multipart/form-data">

                        <div class="form-group">
                            <form:errors path="nameUk">
                                <p class="text-danger col-sm-offset-2 col-sm-10">
                                    <spring:message code="category.err.nameUk" />
                                </p>
                            </form:errors>
                            <form:label path="nameUk" class="col-sm-2 control-label">
                                <spring:message code="category.label.nameUk" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="nameUk" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:errors path="nameRu">
                                <p class="text-danger col-sm-offset-2 col-sm-10">
                                    <spring:message code="category.err.nameRu" />
                                </p>
                            </form:errors>
                            <form:label path="nameRu" class="col-sm-2 control-label">
                                <spring:message code="category.label.nameRu" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="nameRu" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:errors path="descriptionUk">
                                <p class="text-danger col-sm-offset-2 col-sm-10">
                                    <spring:message code="category.err.descriptionUk" />
                                </p>
                            </form:errors>
                            <form:label path="descriptionUk" class="col-sm-2 control-label">
                                <spring:message code="category.label.descriptionUk" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:textarea id="descriptionUk" path="descriptionUk" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:errors path="descriptionRu">
                                <p class="text-danger col-sm-offset-2 col-sm-10">
                                    <spring:message code="category.err.descriptionRu" />
                                </p>
                            </form:errors>
                            <form:label path="descriptionRu" class="col-sm-2 control-label">
                                <spring:message code="category.label.descriptionRu" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:textarea id="descriptionRu" path="descriptionRu" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:errors path="imageFilePath">
                                <p class="text-danger col-sm-offset-2 col-sm-10">
                                    <spring:message code="category.err.imageFilePath" />
                                </p>
                            </form:errors>
                            <form:label path="imageFilePath" class="col-sm-2 control-label">
                                <spring:message code="category.label.imageFilePath" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:hidden path="imageFilePath" class="form-control"/>
                                <input type="file" name="file"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="enabled" class="col-sm-2 control-label">
                                <spring:message code="category.label.enabled" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:checkbox path="enabled" class="checkbox" />
                            </div>
                        </div>
                        <hr />
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">
                                <button type="submit" id="add" data-loading-text="<spring:message code="btn.add" />" class="btn btn-primary btn-lg" autocomplete="off">
                                    <spring:message code="btn.add" />
                                </button>
                                &nbsp;
                                <spring:message code="label.or" />
                                &nbsp;

                                <a href="<c:url value="/categories/list" />" class="btn btn-danger btn-sm">
                                    <spring:message code="btn.cancel" />
                                </a>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>






<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="/js/custom.js"></script>
</body>
</html>