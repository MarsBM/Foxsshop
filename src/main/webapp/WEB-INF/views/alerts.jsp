<div class="col-xs-12 col-sm-12 col-md-6 col-lg-4" id="alerts">
    <c:if test="${!empty error}">
        <div class="alert alert-danger alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <spring:message code="${error}" />
        </div>
    </c:if>
    <c:if test="${!empty success}">
        <div class="alert alert-success alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <spring:message code="${success}" />
        </div>
    </c:if>
    <c:if test="${!empty info}">
        <div class="alert alert-info alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <spring:message code="${info}" />
        </div>
    </c:if>
    <c:if test="${!empty warning}">
        <div class="alert alert-warning alert-dismissible" role="alert">
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            <spring:message code="${warning}" />
        </div>
    </c:if>
</div>