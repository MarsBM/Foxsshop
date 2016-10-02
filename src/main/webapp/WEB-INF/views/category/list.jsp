<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/custom.css">

    <title><spring:message code="category.page.title" /></title>

    <%--URL`s--%>
    <c:url value="/logout" var="logout" />
    <c:url value="/" var="home_url" />
    <c:url value="/categories/new" var="new_btn"/>
    <c:url value="/categories/edit" var="edit_btn"/>
    <c:url value="/categories/delete" var="delete_btn"/>
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
<c:forEach items="${list}" var="l">
    <p>
        <c:if test="${l.directory == true}">
            ${l.name} (dir)
        </c:if>
    </p>
</c:forEach>

<div class="container-fluid">

    <ol class="breadcrumb">
        <li><a href=" <c:url value="${home_url}" />"><spring:message code="breadcrumb.home" /></a></li>
        <li class="active"><spring:message code="category.page.title" /></li>
    </ol>

    <div class="row">
        <%@ include file="../alerts.jsp"%>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="row">

                        <div class="col-md-4">
                            <%@ include file="../search.jsp"%>
                        </div>
                        <div class="col-md-2 pull-right">
                            <%@ include file="../resultsonpage.jsp"%>
                        </div>

                        <div class="col-md-2 pull-right">
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-addon"><span class="glyphicon glyphicon-sort"></span></div>
                                    <select class="form-control" id="sortBy">
                                        <option value="nameUkAsc"
                                                <c:if test="${sortBy eq 'nameUkAsc'}">
                                                    selected
                                                </c:if>>
                                            <spring:message code="sort.by.nameUk.asc" />
                                        </option>
                                        <option value="nameUkDesc"
                                                <c:if test="${sortBy eq 'nameUkDesc'}">
                                                    selected
                                                </c:if>>
                                            <spring:message code="sort.by.nameUk.desc" />
                                        </option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="table-responsive" id="body">
                        <table class="table table-striped table-bordered table-hover">
                            <thead>
                            <tr>
                                <th id="image">
                                    <spring:message code="category.image" />
                                </th>
                                <th id="nameUk">
                                    <spring:message code="category.name" />
                                </th>
                                <th>
                                    <a href="${new_btn}" class="btn btn-primary">
                                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                    </a>
                                </th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:if test="${empty categories}">
                                <tr>
                                    <td class="text-center" colspan="3">
                                        <spring:message code="category.list.empty" />
                                    </td>
                                </tr>
                            </c:if>
                            <c:forEach items="${categories}" var="c">

                                <tr id="${c.id}">
                                    <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                        <img class="img-responsive center-block" style="max-height: 150px; max-width: 100%" src="${c.imageFilePath}" alt="${c.imageFilePath}">
                                    </td>
                                    <td class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                                        <c:forEach items="${c.descriptions}" var="d" varStatus="i">
                                            <p class="text-left">${d.name}</p>
                                        </c:forEach>
                                    </td>
                                    <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">

                                        <a href="${edit_btn}/${c.id}" class="btn btn-primary">
                                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                        </a>
                                        <a href="${delete_btn}/${c.id}" class="btn btn-danger">
                                            <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                        </a>

                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                        <c:if test="${pages > 1}">
                            <%@ include file="../pagination.jsp"%>
                        </c:if>

                    </div>
                </div>
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