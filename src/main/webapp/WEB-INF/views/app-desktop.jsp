<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <link href='<c:url value="css/excursions.css"/>' rel="stylesheet" type="text/css">
    <title>Join the footprints - Desktop</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragment/main-navbar-app.jsp"/>

<section class="container">
    <div class="row">
        <div class="col-lg-2 col-md-4">
            <jsp:include page="/WEB-INF/views/fragment/app-navbar.jsp"/>
        </div>
        <div class="m-4 p-4 width-medium col-lg-8 col-md-6">
            <div class="dashboard-header m-4">
                <div class="dashboard-menu">
                    <div class="menu-item border-dashed">
                        <i class="far fa-plus-square icon-plus-square"></i>
                        <span class="title">
                            <a href="${contextPath}/app/excursion/add">Add excursion</a>
                        </span>
                    </div>
                </div>
            </div>
            <div class="m-4 p-4 border-dashed">
                <h2 class="dashboard-content-title">
                    <span>Upcoming excursion:</span> ${excursion.title}
                </h2>
                <c:choose>
                    <c:when test="${excursion == null}">
                        <p>You want to start your adventure - add your first trip and make your dreams come true with
                            us</p>
                    </c:when>
                    <c:otherwise>
                        <c:forEach var="excursion" items="${excursions}" varStatus="count">
                            <div class="exc-content <c:if test="${count.index == 0}">first-exc</c:if>">
                                <div class="exc-img img-default">
                                        <%--                                class="img-fluid ???center-block"--%>
                                        <%--                                <img src='<c:url value="/files/korali.jpg"></c:url>' />--%>
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
                                </div>
                                <div class="exc-info">
                                    <c:if test="${excursion.categories.size() != 0}">
                                        <%--przygotuj wszystkie i wyświetl z hidden zaznaczonych na true--%>
                                        <ul class="category-items list-unstyled">
                                            <c:forEach var="category" items="${excursion.categories}">
                                                <li><c:out value="${category.name}"/></li>
                                            </c:forEach>
                                        </ul>
                                    </c:if>

                                    <h4 class="exc-info-item"><c:out value="${excursion.title}"/></h4>

                                    <p class="exc-info-item">Expense: <c:out value="${excursion.expense}"/> zł</p>

                                    <p class="exc-info-item">Organizer: <c:out
                                            value="${excursion.organizer.firstName}"/>
                                    </p>

                                    <p class="exc-info-item">Max members: <c:out value="${excursion.maxMembers}"/></p>

                                    <c:if test="${excursion.members.size() != 0}">
                                        <p class="exc-info-item">Members: <c:out value="${excursion.members.size()}"/><br>
                                        <c:forEach var="member" items="${excursion.members}">
                                            <a role="button" href="${contextPath}/app/user/show?id=${member.id}"><c:out value="${member.fullName}"/></a></p>
                                        </c:forEach>
                                    </c:if>

                                    <c:if test="${excursion.description ne null}">
                                        <p class="exc-info-item">Description: <br>
                                            <c:out value="${excursion.description}"/></p>
                                    </c:if>

                                    <button class="mt-3 mr-3 pl-1 pr-1 showExcursionDetailsButton" data-id="${excursion.id}">
                                        Details
                                    </button>
                                    <c:if test="${excursion.organizer.id == userId}">
                                        <button class="mt-3 mr-3 pl-1 pr-1 editButton" data-id="${excursion.id}">Edit</button>
                                        <button class="mt-3 pl-1 pr-1 deleteButton" data-id="${excursion.id}">Delete</button>
                                    </c:if>
                                </div>
                            </div>
                            <hr class="border-2">
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>

        <div class="col-lg-2 col-md-4"></div>
    </div>
</section>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>
</html>
