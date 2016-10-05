<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url value="/" var="home_url" />
<c:url value="/products/edit" var="edit_btn"/>
<c:url value="/products/delete" var="delete_btn"/>

<c:set value="4" var="list_empty_colspan" />

<spring:message code="product.page.title" var="page_title"/>
<spring:message code="breadcrumb.home" var="breadcrumb_home"/>
<spring:message code="sort.by.name.asc" var="sort_by_name_asc"/>
<spring:message code="sort.by.name.desc" var="sort_by_name_desc"/>
<spring:message code="label.image" var="label_image"/>
<spring:message code="label.name" var="label_name"/>
<spring:message code="label.category" var="label_category"/>
<spring:message code="label.list.empty" var="label_list_empty"/>
<spring:message code="text.confirm.delete" var="text_confirm_delete"/>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="/css/custom.css">

        <title>${page_title}</title>
    </head>

    <header>
        <%@ include file="../authorize.jsp"%>
    </header>
    <%@ include file="../nav.jsp"%>
    <body>

    <div class="container-fluid">

        <ol class="breadcrumb">
            <li><a href="${home_url}">${breadcrumb_home}</a></li>
            <li class="active">${page_title}</li>
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
                                            <option value="nameAsc"
                                                    <c:if test="${sortBy eq 'nameAsc'}">
                                                        selected
                                                    </c:if>>
                                                ${sort_by_name_asc}
                                            </option>
                                            <option value="nameDesc"
                                                    <c:if test="${sortBy eq 'nameDesc'}">
                                                        selected
                                                    </c:if>>
                                                ${sort_by_name_desc}
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
                                       ${label_image}
                                    </th>
                                    <th id="name">
                                        ${label_name}
                                    </th>
                                    <th id="category">
                                        ${label_category}
                                    </th>
                                    <th>
                                        <a href="${edit_btn}" class="btn btn-primary">
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        </a>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${empty products}">
                                    <tr>
                                        <td class="text-center" colspan="${list_empty_colspan}">
                                            ${label_list_empty}
                                        </td>
                                    </tr>
                                </c:if>
                                <c:forEach items="${products}" var="p">

                                    <tr id="${p.id}">
                                        <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                            <%--<img class="img-responsive center-block" style="max-height: 150px; max-width: 100%" src="${p.imageFilePath}" alt="${c.imageFilePath}">--%>
                                        </td>
                                        <td class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                                            <c:forEach items="${p.descriptions}" var="d" varStatus="i">
                                                <c:if test="${d.language.code eq locale}">
                                                    <p class="text-left">${d.name}</p>
                                                </c:if>
                                            </c:forEach>
                                        </td>
                                        <td class="col-xs-8 col-sm-8 col-md-8 col-lg-8">
                                            <c:forEach items="${p.categories}" var="с">
                                                <c:forEach items="${с.descriptions}" var="d">
                                                    <c:if test="${d.language.code eq locale}">
                                                        <p class="text-left">${d.name}</p>
                                                    </c:if>
                                                </c:forEach>
                                            </c:forEach>
                                        </td>
                                        <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                            <a href="${edit_btn}?id=${p.id}" class="btn btn-primary">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </a>
                                            <a href="${delete_btn}?id=${p.id}" class="btn btn-danger" onclick="return confirm('${text_confirm_delete}')">
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

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/custom.js"></script>

    </body>
</html>