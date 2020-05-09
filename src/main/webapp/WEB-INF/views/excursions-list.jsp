<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<html>
<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <link href='<c:url value="css/style.css"/>' rel="stylesheet" type="text/css">
    <title>Join the footprints - Excursions</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragment/main-navbar.jsp"/>

<%--<section class="details exc-content">--%>
    <div class="container bg-light">
        <div class="row exc-main-list justify-content-center">
            <div class="customDiv col-lg-5 col-offset-1 text-left img-source">
                <h1>Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>
            <div class="customDiv col-lg-5 text-left img-source">
                <h1>Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>
            <div class="customDiv col-lg-5 text-left img-source">
                <h1>Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>
            <div class="customDiv col-lg-5 text-left img-source">
                <h1>Lorem ipsum dolor sit amet</h1>
                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem.  Aliquam erat volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.
                </p>
            </div>

            <nav aria-label="Page navigation">
                <ul class="pagination">
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                            <span class="sr-only">Previous</span>
                        </a>
                    </li>
                    <c:forEach var="pageNo" items="${pagesNumber}">
                        <li class="page-item"><a class="page-link" href="${contextPath}/list?pageNo=${pageNo-1}&pageSize=4">${pageNo+1}</a></li>
                    </c:forEach>
                    <li class="page-item">
                        <a class="page-link" href="#" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                            <span class="sr-only">Next</span>
                        </a>
                    </li>
                </ul>
            </nav>
        </div>
    </div>

<%--</section>--%>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>
</html>




<%--<jsp:include page="/WEB-INF/views/fragment/main-navbar.jsp"/>--%>

<%--<section class="padding-small details">--%>
<%--    <div class="container bg-light">--%>
<%--        <div class="row">--%>
<%--            <c:forEach var="excursion" items="${allExcursions}" varStatus="count">--%>
<%--                <div class="col text-left img-source exc-item">--%>
<%--                    <h3>--%>
<%--                        <c:forEach var="country" items="${excursion.countries}">--%>
<%--                            <span><c:out value="${country.name}"/></span>--%>
<%--                            <c:if test="${excursion.countries.size() > 1}">--%>
<%--                                <span> - </span>--%>
<%--                            </c:if>--%>
<%--                        </c:forEach>--%>
<%--                    </h3>--%>
<%--                    <p>--%>
<%--                        <c:out value="${excursion.dateOfDeparture}"/>--%>
<%--                        <span>  -  </span>--%>
<%--                        <c:out value="${excursion.dateOfArrival}"/>--%>
<%--                    </p>--%>

<%--                    <div class="d-flex align-items-end">--%>
<%--                        <p class="item-end">Koszt</p>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                <div class="col text-center pr-4 pl-4 mr-4 ml-4 img-source">--%>
<%--                    <h1>Lorem ipsum dolor sit amet</h1>--%>
<%--                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat--%>
<%--                        volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--                <div class="col text-center img-source">--%>
<%--                    <h1>Lorem ipsum dolor sit amet</h1>--%>
<%--                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam at porttitor sem. Aliquam erat--%>
<%--                        volutpat. Donec placerat nisl magna, et faucibus arcu condimentum sed.--%>
<%--                    </p>--%>
<%--                </div>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>

<%--    </div>--%>
<%--</section>--%>

<%--<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>--%>

<%--</body>--%>
<%--</html>--%>
