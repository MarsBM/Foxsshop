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
</head>
<body>
    <div class="container-fluid">

        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <p id="currentDir">${currentDir}</p>
                    <button onclick="up('${rootDir}')">
                        <span class="glyphicon glyphicon-home" aria-hidden="true"></span>
                    </button>
                    <button onclick="up('${currentDir}')">
                        <span class="glyphicon glyphicon-level-up" aria-hidden="true"></span>
                    </button>
                    <form action=" <c:url value="/upload"/>" accept="png/jpg" enctype="multipart/form-data" method="post">
                        <input type="file" name="file"/>
                        <button type="submit">Upload</button>
                    </form>

                </div>
            </div>
            <div class="panel-body">
                <div class="row">
                        <c:forEach items="${files}" var="f">
                            <div class="col-xs-6 col-sm-4 col-md-3 col-lg-2">
                                <c:choose>
                                    <c:when test="${f.file == true}">
                                        <div class="panel panel-default">
                                            <div class="panel-heading" style="overflow: hidden">
                                                <h3 class="panel-title">${f.name}</h3>
                                            </div>
                                            <div class="panel-body" style="height: 180px">
                                                <img class="img-responsive center-block" style="max-height: 150px; max-width: 100%" src="${currentDir}/${f.name}" alt="${f.name}">
                                            </div>
                                            <div class="panel-footer">
                                                <a class="btn" href="/download?name=${currentDir}/${f.name}">
                                                    <span class="glyphicon glyphicon-download-alt" aria-hidden="true"></span>
                                                </a>
                                                <button class="btn" onclick="del('${currentDir}/${f.name}')">
                                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                                </button>
                                                <button class="btn" onclick="">
                                                    <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
                                                </button>
                                            </div>
                                        </div>
                                    </c:when>
                                    <c:when test="${f.directory == true}">
                                        <div class="panel panel-default">
                                            <div class="panel-heading" style="overflow: hidden">
                                                <h3 class="panel-title">
                                                    ${f.name}
                                                </h3>
                                            </div>
                                            <div class="panel-body" style="height: 180px">
                                                <span class="glyphicon glyphicon-folder-open" aria-hidden="true"></span>
                                            </div>
                                            <div class="panel-footer">
                                                <button class="btn" onclick="del('${currentDir}/${f.name}')">
                                                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                                                </button>
                                                <button class="btn" onclick="goto('${f.name}', '${currentDir}')">
                                                    <span class="glyphicon glyphicon-check" aria-hidden="true"></span>
                                                </button>
                                            </div>
                                        </div>
                                    </c:when>
                                </c:choose>
                            </div>
                        </c:forEach>

                </div>
            </div>
        </div>
    </div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="/js/custom.js"></script>

</body>
</html>