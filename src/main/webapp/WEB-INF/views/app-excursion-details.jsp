<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <link href='<c:url value="/css/excursions.css"/>' rel="stylesheet" type="text/css">
    <title>Join the footprints - Excursions list</title>
</head>
<body>

<jsp:include page="/WEB-INF/views/fragment/main-navbar-app.jsp"/>

<div class="container">
    <div class="row">
        <div class="col-lg-2">

            <jsp:include page="/WEB-INF/views/fragment/app-navbar.jsp"/>

        </div>
        <div class="col-lg-8">
            <div class="main-content">
                <div class="exc-list">
                    <div class="exc-content">
                        <div class="exc-img img-default">
<%--                            <form:hidden path="excursion.id"/>--%>
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
                                <ul class="category-items">
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

                            <c:choose>
                                <c:when test="${excursion.organizer.id == userId}">
                                    <button class="mt-3 mr-3 pl-1 pr-1 editButton" data-id="${excursion.id}">Edit</button>
                                    <button class="mt-3 pl-1 pr-1 deleteButton" data-id="${excursion.id}">Delete</button>
                                </c:when>
                                <c:otherwise>
                                    <c:choose>
                                        <c:when test="${hasThisMemberAlready == false or excursion.organizer.id == userId}">
                                            <button class="mt-3 mr-3 pl-1 pr-1 joinButton" data-id="${excursion.id}" data-user_id="${userId}">
                                                JOIN
                                            </button>
                                        </c:when>
                                        <c:otherwise>
                                            <button class="mt-3 mr-3 pl-1 pr-1 resignExcursionButton" data-id="${excursion.id}" data-user_id="${userId}">
                                                RESIGN
                                            </button>
                                        </c:otherwise>
                                    </c:choose>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                    <hr>
                </div>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>
</html>






