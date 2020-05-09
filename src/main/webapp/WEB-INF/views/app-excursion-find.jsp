<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <link href='<c:url value="css/excursions.css"/>' rel="stylesheet" type="text/css">
    <title>Join the footprints - Find excursions</title>
</head>
<body>

    <jsp:include page="/WEB-INF/views/fragment/main-navbar-app.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col-lg-2 col-md-4">
                <jsp:include page="/WEB-INF/views/fragment/app-navbar.jsp"/>
            </div>

            <div class="col-lg-10 col-md-8">
                <form:form class="form-inline d-flex" modelAttribute="excursionFound" method="post">
                    <div class="form-row">
                        <div class="form-group">
                            Destination:<br>
                            <form:select path="countries" multiple="true">
                                <form:option value="" label="--Available countries--"/>
                                <form:options items="${availableCountries}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </div>
                        <div class="form-group">
                            Departure from:<br>
                            <form:input class="form-control" path="dateOfDeparture" type="date" format="yyyy-MM-dd"/>
                        </div>
                        <div class="form-group">
                            Return before:<br>
                            <form:input class="form-control" path="dateOfArrival" type="date" format="yyyy-MM-dd"/>
                        </div>
                        <div class="form-group">
                            Number of members:<br>
                            <form:input class="form-control" path="maxMembers" type="number"
                                        placeholder="Number of members"/>
                        </div>
                    </div>
                    <div class="form-row">
                        <div class="form-group">
                            Expense:<br>
                            <form:input class="form-control" path="minExpense" type="number" placeholder="from"/>
                            <form:input class="form-control" path="maxExpense" type="number" placeholder="to"/>
                        </div>
                        <div class="form-group">
                            Categories:<br>
                            <form:select path="categories" multiple="true" cssClass="form-control">
                                <form:option value="" label="--Select caterogies--"/>
                                <form:options items="${categoryItems}" itemValue="id"
                                              itemLabel="name"/>
                            </form:select>
                        </div>
                    </div>

                    <button id="searchButton" type="submit" class="btn btn-primary">
                        <svg class="bi bi-search" width="1em" height="1em" viewBox="0 0 16 16" fill="currentColor"
                             xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd"
                                  d="M10.442 10.442a1 1 0 011.415 0l3.85 3.85a1 1 0 01-1.414 1.415l-3.85-3.85a1 1 0 010-1.415z"
                                  clip-rule="evenodd"/>
                            <path fill-rule="evenodd"
                                  d="M6.5 12a5.5 5.5 0 100-11 5.5 5.5 0 000 11zM13 6.5a6.5 6.5 0 11-13 0 6.5 6.5 0 0113 0z"
                                  clip-rule="evenodd"/>
                        </svg>
                        Search
                    </button>
                </form:form>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-2 col-md-4"></div>
            <div class="col-lg-10 col-md-8">
                <div class="details exc-content">
                    <c:choose>
                        <c:when test="${hideDefaultExcursions == true}">
                        <h2 class="dashboard-content-title">
                            <span>Excursions found:</span> ${foundedExcursions.size()}
                        </h2>
                        <div class="container bg-light">
                            <div class="row exc-main-list justify-content-center">
                                <c:choose>
                                    <c:when test="${foundedExcursions == null or foundedExcursions.size() == 0}">
                                        <p>We are sorry, we haven't found an excursions with such parameters</p>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="excursion" items="${foundedExcursions}">
                                            <div class="customDiv col-lg-12 img-source img-default">
                                                <p class="exc-top-inf">
                                                    <c:forEach var="country" items="${excursion.countries}">
                                                        <span><c:out value="${country.name}"/></span>
                                                        <c:if test="${excursion.countries.size() > 1}">
                                                            <span> - </span>
                                                        </c:if>
                                                    </c:forEach>
                                                </p>
                                                <p class="exc-top-inf">
                                                    <c:out value="${excursion.dateOfDeparture}"/>
                                                    <span>  -  </span>
                                                    <c:out value="${excursion.dateOfArrival}"/>
                                                </p>
                                                <p class="exc-info-item">Expense: <c:out value="${excursion.expense}"/>
                                                    zł</p>

                                                <button class="mt-3 mr-3 pl-1 pr-1 showExcursionDetailsButton"
                                                        data-id="${excursion.id}">Details
                                                </button>
                                            </div>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>
                            </div>
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
                                    <li class="page-item"><a class="page-link"
                                                             href="${contextPath}/list?pageNo=${pageNo-1}&pageSize=4">${pageNo+1}</a>
                                    </li>
                                </c:forEach>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        </c:when>
                        <c:otherwise>
                        <div class="customDiv col-lg-12 text-left img-source">

                            <c:forEach var="excursion" items="${allExcursions}">
                                <div class="img-default">
                                <p class="exc-top-inf">
                                <c:forEach var="country" items="${excursion.countries}">
                                    <span><c:out value="${country.name}"/></span>
                                    <c:if test="${excursion.countries.size() > 1}">
                                        <span> - </span>
                                    </c:if>
                                </c:forEach>
                                </p>
                                <p class="exc-top-inf">
                                    <c:out value="${excursion.dateOfDeparture}"/>
                                    <span>  -  </span>
                                    <c:out value="${excursion.dateOfArrival}"/>
                                </p>
                                <p class="exc-info-item">Expense: <c:out value="${excursion.expense}"/> zł</p>

                                <button class="mt-3 mr-3 pl-1 pr-1 showExcursionDetailsButton" data-id="${excursion.id}">
                                    Details
                                </button>

                                </div>
                            </c:forEach>
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
                                    <li class="page-item"><a class="page-link"
                                                             href="${contextPath}/list?pageNo=${pageNo-1}&pageSize=4">${pageNo+1}</a>
                                    </li>
                                </c:forEach>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>

    <jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>
</html>
