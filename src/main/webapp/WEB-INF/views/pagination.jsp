<nav aria-label="Page navigation">
    <ul class="pagination pull-right">
        <li <c:if test="${currentPage == 1}"> class="disabled" </c:if>
                <c:if test="${currentPage != 1}"> onclick="goToPage(${1})" </c:if>>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>
        <li <c:if test="${currentPage == 1}"> class="disabled" </c:if>
                <c:if test="${currentPage != 1}"> onclick="goToPage(${currentPage - 1})" </c:if>>
            <a href="#" aria-label="Previous">
                <span aria-hidden="true">&lsaquo;</span>
            </a>
        </li>

        <c:choose>
            <c:when test="${pages < 10}">
                <c:forEach begin="1" end="${pages}" step="1" var="page">
                    <li onclick="goToPage(${page})" <c:if test="${currentPage == page}"> class="active" </c:if> >
                        <a href="#">
                                ${page}
                            <c:if test="${currentPage == page}">
                                <span class="sr-only">(current)</span>
                            </c:if>
                        </a>
                    </li>
                </c:forEach>
            </c:when>

            <c:when test="${currentPage < (pages - 9)}">
                <c:forEach begin="${currentPage}" end="${currentPage + 9}" step="1" var="page">
                    <li onclick="goToPage(${page})" <c:if test="${currentPage == page}"> class="active" </c:if> >
                        <a href="#">
                                ${page}
                            <c:if test="${currentPage == page}">
                                <span class="sr-only">(current)</span>
                            </c:if>
                        </a>
                    </li>
                </c:forEach>
            </c:when>

            <c:otherwise>
                <c:forEach begin="${pages - 9}" end="${pages}" step="1" var="page">
                    <li onclick="goToPage(${page})" <c:if test="${currentPage == page}"> class="active" </c:if> >
                        <a href="#">
                                ${page}
                            <c:if test="${currentPage == page}">
                                <span class="sr-only">(current)</span>
                            </c:if>
                        </a>
                    </li>
                </c:forEach>
            </c:otherwise>
        </c:choose>

        <li <c:if test="${currentPage == pages}"> class="disabled" </c:if>
                <c:if test="${currentPage != pages}"> onclick="goToPage(${currentPage + 1})" </c:if>>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&rsaquo;</span>
            </a>
        </li>
        <li <c:if test="${currentPage == pages}"> class="disabled" </c:if>
                <c:if test="${currentPage != pages}"> onclick="goToPage(${pages})" </c:if>>
            <a href="#" aria-label="Next">
                <span aria-hidden="true">&raquo;</span>
            </a>
        </li>

    </ul>
</nav>