<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link href='<c:url value="css/nav.css"/>' rel="stylesheet" type="text/css">
</head>
<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="/" class="navbar-brand main-logo">
            <span><img class="main-img" src='<c:url value="images/map.jpg"></c:url>' /></span>
            <span>Join the footprints</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link" href="#about">About the application</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="${contextPath}/list">Excursions</a>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#contact">Contact</a>
            </li>
        </ul>
        <a class="nav-link log ml-0 pl-0" href="${contextPath}/login">
            <span><img class="log-img" src='<c:url value="images/hand.jpg"></c:url>'/></span>
        </a>
    </nav>
</header>
