<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url value="/roles/list" var="list_url" />

<c:set var="update_action" value="/roles/save"/>
<c:set var="comandName" value="role"/>

<spring:message code="role.page.title" var="page_title"/>
<spring:message code="role.add.panel.title" var="add_panel_title"/>
<spring:message code="role.edit.panel.title" var="edit_panel_title"/>
<spring:message code="total.settings" var="total_settings"/>
<spring:message code="label.id" var="label_id"/>
<spring:message code="label.name" var="label_name"/>
<spring:message code="label.permission" var="label_permission"/>
<spring:message code="err.name" var="err_name"/>
<spring:message code="err.permission" var="err_permission"/>
<spring:message code="btn.cancel" var="btn_cancel"/>
<spring:message code="btn.save" var="btn_save"/>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="/css/custom.css" >

        <title>${page_title}</title>
    </head>

    <header>
        <%@ include file="../authorize.jsp"%>
    </header>

    <%@ include file="../nav.jsp"%>
    <body>
        <form:form method="post" action="${update_action}" commandName="${comandName}" class="form-horizontal">
        <div class="container">

            <div class="row">
                <%@ include file="../alerts.jsp"%>
            </div>

            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <c:choose>
                                <c:when test="${role.id == null}">
                                    ${add_panel_title}
                                </c:when>
                                <c:otherwise>
                                    ${edit_panel_title}
                                </c:otherwise>
                            </c:choose>
                        </div>

                        <div class="panel-body">
                            <div>
                                <!-- Nav tabs -->
                                <ul class="nav nav-tabs" role="tablist">
                                    <li role="presentation" class="active"><a href="#main" aria-controls="main" role="tab" data-toggle="tab">
                                        ${total_settings}
                                    </a></li>
                                </ul>

                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="main">

                                        <c:if test="${role.id != null}">
                                            <div class="form-group">
                                                <form:label path="id" class="col-sm-2 control-label">
                                                    ${label_id}
                                                </form:label>
                                                <div class="col-sm-10">
                                                    <div class="col-sm-10">
                                                        <p class="form-control-static">${role.id}</p>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:if>
                                        <form:hidden path="id"/>

                                        <div class="form-group">
                                            <form:errors path="name">
                                                <p class="text-danger col-sm-offset-2 col-sm-10">
                                                    ${err_name}
                                                </p>
                                            </form:errors>
                                            <form:label path="name" class="col-sm-2 control-label">
                                                ${label_name}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="name" class="form-control"/>
                                            </div>
                                        </div>


                                        <div class="form-group">
                                            <form:errors path="permission">
                                                <p class="text-danger col-sm-offset-2 col-sm-10">
                                                    ${err_permission}
                                                </p>
                                            </form:errors>
                                            <form:label path="permission" class="col-sm-2 control-label">
                                                ${label_permission}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="permission" class="form-control"/>
                                            </div>
                                        </div>

                                    </div>

                                </div>
                            </div>
                        </div><%--.panel-body--%>

                        <div class="panel-footer">
                            <a href="${list_url}" class="btn btn-danger">
                                <span class="glyphicon glyphicon-share-alt" aria-hidden="true"></span>
                                ${btn_cancel}
                            </a>
                            <button type="submit" id="add" data-loading-text="${btn_save}" class="btn btn-primary" autocomplete="off" onclick="$(this).button('loading')">
                                <span class="glyphicon glyphicon-floppy-disk" aria-hidden="true"></span>
                                ${btn_save}
                            </button>
                        </div>

                    </div><%--.panel--%>
                </div>
            </div>
        </div> <%--.container--%>
    </form:form>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/custom.js"></script>
    </body>
</html>