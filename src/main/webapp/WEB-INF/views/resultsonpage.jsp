<div class="form-group">
    <div class="input-group">
        <div class="input-group-addon"><span class="glyphicon glyphicon-align-justify"></span></div>
        <select class="form-control" id="number">
            <option value="2"
                    <c:if test="${resultsOnPage == 2}">
                        selected
                    </c:if>>
                2
            </option>

            <option value="10"
                    <c:if test="${resultsOnPage == 10}">
                        selected
                    </c:if>>
                10
            </option>

            <option value="25"
                    <c:if test="${resultsOnPage == 25}">
                        selected
                    </c:if>>
                25
            </option>

            <option value="50"
                    <c:if test="${resultsOnPage == 50}">
                        selected
                    </c:if>>
                50
            </option>

            <option value="100"
                    <c:if test="${resultsOnPage == 100}">
                        selected
                    </c:if>>
                100
            </option>
        </select>
    </div>
</div>