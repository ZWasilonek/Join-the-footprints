<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<header>
    <link href='<c:url value="/css/nav.css"/>' rel="stylesheet" type="text/css">
</header>
<div class="dashboard-section position-fixed center">
    <div class="row dashboard">
        <ul class="nav flex-column long-bg text-center">
            <li class="nav-item-app">
                <a class="nav-link" href="${contextPath}/app">
                    <span>Dashboard</span>
                </a>
            </li>
            <hr>
            <li class="nav-item-app">
                <a class="nav-link" href="${contextPath}/app/excursion">
                    <span>My Excursions</span>
                </a>
            </li>
            <hr>
            <li class="nav-item-app">
                <a class="nav-link" href="${contextPath}/app/excursion/find">
                    <span>Find Excursions</span>
                </a>
            </li>
        </ul>
    </div>
</div>