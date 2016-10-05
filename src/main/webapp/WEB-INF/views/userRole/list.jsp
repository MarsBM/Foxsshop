<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url value="/" var="home_url" />
<c:url value="/roles/edit" var="edit_btn"/>
<c:url value="/roles/delete" var="delete_btn"/>

<c:set value="3" var="list_empty_colspan" />

<spring:message code="role.page.title" var="page_title"/>
<spring:message code="breadcrumb.home" var="breadcrumb_home"/>
<spring:message code="sort.by.name.asc" var="sort_by_name_asc"/>
<spring:message code="sort.by.name.desc" var="sort_by_name_desc"/>
<spring:message code="label.permission" var="label_permission"/>
<spring:message code="label.name" var="label_name"/>
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
                                        ${label_name}
                                    </th>
                                    <th id="name">
                                        ${label_permission}
                                    </th>
                                    <th>
                                        <a href="${edit_btn}" class="btn btn-primary">
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                        </a>
                                    </th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${empty userRoles}">
                                    <tr>
                                        <td class="text-center" colspan="${list_empty_colspan}">
                                            ${label_list_empty}
                                        </td>
                                    </tr>
                                </c:if>
                                <c:forEach items="${userRoles}" var="r">

                                    <tr id="${r.id}">
                                        <td class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                            ${r.name}
                                        </td>
                                        <td class="col-xs-5 col-sm-5 col-md-5 col-lg-5">
                                            ${r.permission}
                                        </td>
                                        <td class="col-xs-2 col-sm-2 col-md-2 col-lg-2">
                                            <a href="${edit_btn}?id=${r.id}" class="btn btn-primary">
                                                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                            </a>
                                            <a href="${delete_btn}?id=${r.id}" class="btn btn-danger" onclick="return confirm('${text_confirm_delete}')">
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