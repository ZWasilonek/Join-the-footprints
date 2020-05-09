<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <link href='<c:url value="css/login.css"/>' rel="stylesheet" type="text/css">
    <title>Sign In</title>
</head>

<body>

<jsp:include page="/WEB-INF/views/fragment/main-navbar.jsp"/>

<div class="container">
    <div class="login-page">
        <div class="form">
            <form:form class="login-form" method="post" modelAttribute="userLogin">
                <div class="form-group">
<%--                    <span>${message}</span>--%>
                    <form:input path="email" type="text" class="form-control" placeholder="Email"
                                autofocus="true"/>
                    <form:input path="password" type="password" class="form-control" placeholder="Password"/>
                    <span>${error}</span>
                </div>

                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign In</button>
                <p class="message">Not registered? <a href="${contextPath}/register">Create an account</a></p>
            </form:form>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>
</html>










