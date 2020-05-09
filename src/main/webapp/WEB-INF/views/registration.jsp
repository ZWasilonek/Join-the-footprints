<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <link href='<c:url value="css/register.css"/>' rel="stylesheet" type="text/css">
    <title>Sign Up</title>
</head>

<body>

<jsp:include page="/WEB-INF/views/fragment/main-navbar.jsp"/>

    <div class="container">
        <div class="register-page">
            <div class="logo">Join to us</div>
            <div class="form">
                <form:form class="login-form" method="post" modelAttribute="userForm">
                    <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input placeholder="First name" path="firstName"/><br>
                        <form:errors path="firstName" cssClass="error" element="div"/>
                    </div>
                    </spring:bind>

                    <spring:bind path="surname">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input placeholder="Surname" path="surname"/>
                        <form:errors path="surname" cssClass="error"/>
                    </div>
                    </spring:bind>

                    <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input placeholder="email" type="email" path="email"/>
                        <form:errors path="email" cssClass="error"/>
                    </div>
                    </spring:bind>

                    <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:password placeholder="password" path="password"/>
                        <form:errors path="password" cssClass="error"/>
                    </div>
                    </spring:bind>

                    <spring:bind path="confirmPassword">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:password placeholder="repeat password" path="confirmPassword"/>
                        <form:errors path="confirmPassword" cssClass="error"/>
                    </div>
                    </spring:bind>

                    <spring:bind path="birthDate">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:input type="date" pattern="yyyy-MM-dd" path="birthDate"/>
                        <form:errors path="birthDate" cssClass="error"/>
                    </div>
                    </spring:bind>
                    <button type="submit">Sign Up</button>
                    <p class="message">Already registered? <a href="${contextPath}/login">Sign In</a></p>
                </form:form>
            </div>
        </div>
    </div>


<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>
</html>
