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

    <title><spring:message code="category.edit.page.title" /></title>
</head>
<header>
    <sec:authorize access="isAuthenticated()">
        <sec:authentication property="principal.username"/>
        <a href="/logout" ><spring:message code="label.logout"/></a>
    </sec:authorize>
</header>
<%@ include file="../nav.jsp"%>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-12">
            <c:if test="${!empty error}">
                <div class="alert alert-danger alert-dismissible" role="alert">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <spring:message code="${error}" />
                </div>
            </c:if>
        </div>
    </div>
    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <spring:message code="category.edit.panel.title" />
                </div>
                <div class="panel-body">
                    <form:form method="post" action="/categories/update" commandName="category" class="form-horizontal">
                        <div class="form-group">
                            <form:label path="id" class="col-sm-2 control-label">
                                <spring:message code="category.label.id" />
                            </form:label>
                            <div class="col-sm-10">
                                <div class="col-sm-10">
                                    <p class="form-control-static">${id}</p>
                                </div>
                                <form:hidden path="id"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <form:label path="nameUk" class="col-sm-2 control-label">
                                <spring:message code="category.label.nameUk" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="nameUk" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="nameRu" class="col-sm-2 control-label">
                                <spring:message code="category.label.nameRu" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="nameRu" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="descriptionUk" class="col-sm-2 control-label">
                                <spring:message code="category.label.descriptionUk" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:textarea id="descriptionUk" path="descriptionUk" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="descriptionRu" class="col-sm-2 control-label">
                                <spring:message code="category.label.descriptionRu" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:textarea id="descriptionRu" path="descriptionRu" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <form:label path="imageFilePath" class="col-sm-2 control-label">
                                <spring:message code="category.label.imageFilePath" />
                            </form:label>
                            <div class="col-sm-10">
                                <form:input path="imageFilePath" class="form-control"/>
                                <input type="file" name="file" />
                                <img src="${category.imageFilePath}" alt="${id}" class="img-responsive img-thumbnail" width="250px" height="250px">
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

                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-10">

                                <a href="<c:url value="/categories/list" />" class="btn btn-danger">
                                    <spring:message code="btn.cancel" />
                                </a>
                                <button type="submit" class="btn btn-primary">
                                    <spring:message code="btn.save" />
                                </button>
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

<%--<script src="//cdn.ckeditor.com/4.5.11/standard/ckeditor.js"></script>
<script>
    CKEDITOR.replace( 'descriptionUk' );
    CKEDITOR.replace( 'descriptionRu' );
</script>--%>

<script src="/js/custom.js"></script>
</body>
</html>