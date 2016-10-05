<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/">ControlPanel<span class="sr-only">(current)</span></a></li>
                <li><a href="<c:url value="/users/list" />">Users</a></li>
                <li><a href="<c:url value="/roles/list" />">UserRoles</a></li>
                <li><a href="<c:url value="/categories/list" />">Categories</a></li>
                <li><a href="<c:url value="/products/list" />">Products</a></li>
                <li><a href="<c:url value="/files" />">filemanager</a></li>
            </ul>
            <c:if test="${languages != null}">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                            ${activeLang} <span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <c:forEach items="${languages}" var="l">
                                <li>
                                    <a href="?lang=${l.code}">
                                            ${l.name}
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </c:if>
        </div>
    </div>
</nav>
