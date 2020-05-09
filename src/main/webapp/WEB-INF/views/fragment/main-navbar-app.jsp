<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <link href='<c:url value="/css/nav.css"/>' rel="stylesheet" type="text/css">
</head>
<%--<header class="page-header">--%>
    <nav class="navbar navbar-expand-lg justify-content-around fixed-top">
        <a href="${contextPath}/" class="navbar-brand main-logo">
            <span><img class="main-img" src='<c:url value="/images/map.jpg"></c:url>'/></span>
            <span>Join the footprints</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link about-color" href="#about">About the application</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="${contextPath}/list">Excursions</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="#contact">Contact</a>
            </li>
        </ul>

        <div class="dropdown">
                <a class="nav-link log" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                   aria-expanded="false">
                    <span class="mr-2 text-uppercase">
                        <c:out value="${sessionUser.firstName}"/></span>
                    <svg class="bi bi-person-square" width="2em" height="2em" viewBox="0 0 16 16" fill="currentColor"
                         xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd"
                              d="M14 1H2a1 1 0 00-1 1v12a1 1 0 001 1h12a1 1 0 001-1V2a1 1 0 00-1-1zM2 0a2 2 0 00-2 2v12a2 2 0 002 2h12a2 2 0 002-2V2a2 2 0 00-2-2H2z"
                              clip-rule="evenodd"/>
                        <path fill-rule="evenodd" d="M2 15v-1c0-1 1-4 6-4s6 3 6 4v1H2zm6-6a3 3 0 100-6 3 3 0 000 6z"
                              clip-rule="evenodd"/>
                    </svg>
                </a>
            <div class="dropdown-menu">
                <a href="${contextPath}/app/excursion" class="dropdown-item">My Excursions</a>
                <div class="dropdown-divider"></div>
                <a href="${contextPath}/app/user/edit" class="dropdown-item">Edit profile</a>
                <div class="dropdown-divider"></div>
                <a href="${contextPath}/app/user/logout" class="dropdown-item">Logout</a>
            </div>
        </div>
    </nav>
<%--</header>--%>