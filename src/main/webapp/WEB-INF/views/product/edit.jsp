<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<c:url value="/products/list" var="list_url" />

<c:set var="update_action" value="/products/save"/>
<c:set var="comandName" value="product"/>

<spring:message code="product.page.title" var="page_title"/>
<spring:message code="product.add.panel.title" var="add_panel_title"/>
<spring:message code="product.edit.panel.title" var="edit_panel_title"/>
<spring:message code="total.settings" var="total_settings"/>
<spring:message code="label.id" var="label_id"/>
<spring:message code="label.image" var="label_image"/>
<spring:message code="label.enabled" var="label_enabled"/>
<spring:message code="label.categories" var="label_categories"/>
<spring:message code="label.options" var="label_options"/>
<spring:message code="label.price" var="label_price"/>
<spring:message code="label.quantity" var="label_quantity"/>
<spring:message code="label.manufacturer" var="label_manufacturer"/>
<spring:message code="label.createDate" var="label_createDate"/>
<spring:message code="label.modifyDate" var="label_modifyDate"/>
<spring:message code="label.attributes" var="label_attributes"/>
<spring:message code="label.value" var="label_value"/>
<spring:message code="label.minimumQuantity" var="label_minimumQuantity"/>
<spring:message code="label.rating" var="label_rating"/>
<spring:message code="label.subtractStock" var="label_subtractStock"/>
<spring:message code="label.enable" var="label_enable"/>
<spring:message code="label.enableDate" var="label_enableDate"/>
<spring:message code="err.name" var="err_name"/>
<spring:message code="label.name" var="label_name"/>
<spring:message code="err.description" var="err_description"/>
<spring:message code="label.description" var="label_description"/>
<spring:message code="label.empty.field" var="label_empty_field"/>
<spring:message code="btn.cancel" var="btn_cancel"/>
<spring:message code="btn.save" var="btn_save"/>

<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="/css/custom.css" >

        <title>${page_title}</title>
    </head>

   <%-- <header>
        <%@ include file="../authorize.jsp"%>
    </header>

    <%@ include file="../nav.jsp"%>--%>
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
                                <c:when test="${product.id == null}">
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
                                    <c:forEach items="${languages}" var="lang">
                                        <li role="presentation"><a href="#${lang.name}" aria-controls="${lang.name}" role="tab" data-toggle="tab">${lang.name}</a></li>
                                    </c:forEach>
                                    <li role="presentation"><a href="#categories" aria-controls="categories" role="tab" data-toggle="tab">
                                            ${label_categories}
                                    </a></li>
                                    <li role="presentation"><a href="#options" aria-controls="options" role="tab" data-toggle="tab">
                                        ${label_options}
                                    </a></li>
                                    <li role="presentation"><a href="#attributes" aria-controls="attributes" role="tab" data-toggle="tab">
                                        ${label_attributes}
                                    </a></li>
                                </ul>

                                <!-- Tab panes -->
                                <div class="tab-content">
                                    <div role="tabpanel" class="tab-pane active" id="main">

                                        <div class="form-group">
                                            <form:label path="id" class="col-sm-2 control-label">
                                                ${label_id}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <c:choose>
                                                    <c:when test="${product.id != null}">
                                                        <p class="form-control-static">${product.id}</p>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <p class="form-control-static">${label_empty_field}</p>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <form:hidden path="id"/>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="manufacturer.id" class="col-sm-2 control-label">
                                                ${label_manufacturer}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:select path="manufacturer.id" class="form-control">
                                                    <c:forEach items="${manufacturers}" var="m">
                                                        <c:forEach items="${m.descriptions}" var="d">
                                                            <c:if test="${d.language.code eq locale}">
                                                                <form:option value="${m.id}">${d.name}</form:option>
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:forEach>
                                                </form:select>
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="price" class="col-sm-2 control-label">
                                                ${label_price}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="price" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="quantity" class="col-sm-2 control-label">
                                                ${label_quantity}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="quantity" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="minimumQuantity" class="col-sm-2 control-label">
                                                ${label_minimumQuantity}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="minimumQuantity" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="rating" class="col-sm-2 control-label">
                                                ${label_rating}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="rating" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="subtractStock" class="col-sm-2 control-label">
                                                ${label_subtractStock}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:checkbox path="subtractStock" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="enable" class="col-sm-2 control-label">
                                                ${label_enable}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:checkbox path="enable" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="enableDate" class="col-sm-2 control-label">
                                                ${label_enableDate}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input type="datetime-local" path="enableDate" class="form-control" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="createDate" class="col-sm-2 control-label">
                                                ${label_createDate}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="createDate" class="form-control" readonly="true" />
                                            </div>
                                        </div>

                                        <div class="form-group">
                                            <form:label path="modifyDate" class="col-sm-2 control-label">
                                                ${label_modifyDate}
                                            </form:label>
                                            <div class="col-sm-10">
                                                <form:input path="modifyDate" class="form-control" readonly="true" />
                                            </div>
                                        </div>

                                    </div>


                                    <c:forEach items="${languages}" var="lang">
                                        <div role="tabpanel" class="tab-pane" id="${lang.name}">
                                            <c:forEach items="${product.descriptions}" var="d" varStatus="status">
                                                <c:if test="${d.language.code eq lang.code}">
                                                    <div class="form-group">
                                                        <form:hidden path="descriptions[${status.index}].language.code" class="form-control" />
                                                    </div>
                                                    <div class="form-group">
                                                        <form:errors path="descriptions[${status.index}].name">
                                                            <p class="text-danger col-sm-offset-2 col-sm-10">
                                                                ${err_name}
                                                            </p>
                                                        </form:errors>
                                                        <form:label path="descriptions[${status.index}].name" class="col-sm-2 control-label">
                                                            ${label_name}
                                                        </form:label>
                                                        <div class="col-sm-10">
                                                            <form:input path="descriptions[${status.index}].name" class="form-control"/>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <form:errors path="descriptions[${status.index}].description">
                                                            <p class="text-danger col-sm-offset-2 col-sm-10">
                                                                ${err_description}
                                                            </p>
                                                        </form:errors>
                                                        <form:label path="descriptions[${status.index}].description" class="col-sm-2 control-label">
                                                            ${label_description}
                                                        </form:label>
                                                        <div class="col-sm-10">
                                                            <form:textarea path="descriptions[${status.index}].description" class="form-control"/>
                                                        </div>
                                                    </div>
                                                </c:if>
                                            </c:forEach>
                                        </div>
                                    </c:forEach>

                                    <div role="tabpanel" class="tab-pane" id="categories">

                                        <br />

                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <select class="form-control" id="select_category">
                                                        <c:forEach items="${categories_list}" var="c">
                                                            <c:forEach items="${c.descriptions}" var="d">
                                                                <c:if test="${d.language.code eq locale}">
                                                                    <option value="${c.id}">${d.name}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                    </select>
                                                    <span class="input-group-btn">
                                                         <button class="btn btn-primary" type="button" onclick="addCategory()" <c:if test="${empty categories_list}">disabled</c:if>>
                                                             &nbsp;
                                                             <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                             &nbsp;
                                                         </button>
                                                    </span>
                                                </div><!-- /input-group -->
                                            </div><!-- /.col-lg-6 -->
                                        </div><!-- /.row -->

                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>
                                                            ${label_name}
                                                    </th>
                                                    <th>

                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody id="categories_table_body">


                                                <c:forEach items="${product.categories}" var="c" varStatus="ci">
                                                    <c:forEach items="${c.descriptions}" var="d" varStatus="di">
                                                        <c:if test="${d.language.code eq locale}">
                                                            <tr class="category" id="category_${ci.index}">
                                                                <td>
                                                                    <form:hidden path="categories[${ci.index}].id" />
                                                                    <p>${d.name}</p>
                                                                </td>
                                                                <td>
                                                                    <button class="btn btn-danger" type="button" onclick="delCategory(${ci.index})" >
                                                                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                                    </button>
                                                                </td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>


                                    <div role="tabpanel" class="tab-pane" id="options">
                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>
                                                            ${label_name}
                                                    </th>
                                                    <th>
                                                            ${label_price}
                                                    </th>
                                                    <th>
                                                            ${label_quantity}
                                                    </th>
                                                    <th>
                                                        <button class="btn btn-primary" type="button" onclick="addOption()">
                                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                        </button>
                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody id="options_table_body">
                                                <c:forEach items="${product.options}" varStatus="status">
                                                    <tr class="option" id="option_${status.index}">
                                                        <td>
                                                            <form:input path="options[${status.index}].name" class="form-control"/>
                                                        </td>
                                                        <td>
                                                            <form:input path="options[${status.index}].price" class="form-control"/>
                                                        </td>
                                                        <td>
                                                            <form:input path="options[${status.index}].quantity" class="form-control"/>
                                                        </td>
                                                        <td>
                                                            <button class="btn btn-danger" type="button" onclick="delOption(${status.index})" >
                                                                <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>

                                    <div role="tabpanel" class="tab-pane" id="attributes">

                                        <br />

                                        <div class="row">
                                            <div class="col-lg-6">
                                                <div class="input-group">
                                                    <select class="form-control" id="select_attribute">
                                                        <c:forEach items="${attributes_list}" var="c">
                                                            <c:forEach items="${c.descriptions}" var="d">
                                                                <c:if test="${d.language.code eq locale}">
                                                                    <option value="${c.id}">${d.name}</option>
                                                                </c:if>
                                                            </c:forEach>
                                                        </c:forEach>
                                                    </select>
                                                    <span class="input-group-btn">
                                                         <button class="btn btn-primary" type="button" onclick="addAttribute()" <c:if test="${empty attributes_list}">disabled</c:if>>
                                                             &nbsp;
                                                             <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>
                                                             &nbsp;
                                                         </button>
                                                    </span>
                                                </div><!-- /input-group -->
                                            </div><!-- /.col-lg-6 -->
                                        </div><!-- /.row -->

                                        <div class="table-responsive">
                                            <table class="table">
                                                <thead>
                                                <tr>
                                                    <th>
                                                            ${label_name}
                                                    </th>
                                                    <th>
                                                            ${label_value}
                                                    </th>
                                                    <th>

                                                    </th>
                                                </tr>
                                                </thead>
                                                <tbody id="attributes_table_body">
                                                <c:forEach items="${product.attributes}" var="c" varStatus="ci">
                                                    <c:forEach items="${c.attribute.descriptions}" var="d" varStatus="di">
                                                        <c:if test="${d.language.code eq locale}">
                                                            <tr class="attribute" id="attribute_${ci.index}">
                                                                <td>
                                                                    <form:hidden path="attributes[${ci.index}].attribute.id" />
                                                                    <p class="form-control-static">${d.name}</p>
                                                                </td>
                                                                <td>
                                                                    <form:input path="attributes[${ci.index}].value" class="form-control"/>
                                                                </td>
                                                                <td>
                                                                    <button class="btn btn-danger" type="button" onclick="delAttribute(${ci.index})" >
                                                                        <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                                                    </button>
                                                                </td>
                                                            </tr>
                                                        </c:if>
                                                    </c:forEach>
                                                </c:forEach>
                                                </tbody>
                                            </table>
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
    <script src="/js/productOptions.js"></script>
    <script src="/js/custom.js"></script>
    </body>
</html>