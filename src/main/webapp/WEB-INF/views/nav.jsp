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
                <li><a href="/roles/list">UserRoles</a></li>
                <li><a href="<c:url value="/categories/list" />">Categories</a></li>
                <li><a href="<c:url value="/files" />">filemanager</a></li>
            </ul>
        </div>
    </div>
</nav>
