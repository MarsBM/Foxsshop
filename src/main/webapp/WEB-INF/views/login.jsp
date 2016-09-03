<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/custom.css" >

    <title><spring:message code="login.page.title" /></title>

</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title"><spring:message code="login.form.title" /></h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-md-12">
                                <c:if test="${not empty param.error}">
                                    <div class="alert alert-danger">
                                        <strong>
                                            <spring:message code="login.form.error.title" />
                                            :
                                        </strong>
                                            ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                                    </div>
                                </c:if>
                            </div>
                        </div>
                        <form role="form" method="post" action="/check">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" id="username" placeholder="<spring:message code="login.form.login" />" name="username" type="text" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" id="password" placeholder="<spring:message code="login.form.password" />" name="password" type="password" value="">
                                </div>
                                <button type="submit" class="btn btn-lg btn-primary btn-block"><spring:message code="login.form.submit"/></button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>