<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <title>Join the footprints - Edit profile</title>
</head>
<body>

    <jsp:include page="/WEB-INF/views/fragment/main-navbar-app.jsp"/>

    <div class="container">
        <div class="row">
            <div class="col-lg-2 text-lg-center">
                <jsp:include page="/WEB-INF/views/fragment/app-navbar.jsp"/>
            </div>

            <div class="col-lg-10 push-lg-4  text-lg-center">
                <h2 class="text-center">Edit profile <c:out value="${sessionUser.firstName}"/></h2>
                <br>
                <br>
                <div class="personal-info">
                    <form:form modelAttribute="updateUserSession" method="post">
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">First name:</label>
                            <spring:bind path="firstName">
                                <div class="col-lg-9 ${status.error ? 'has-error' : ''}">
                                    <form:input path="firstName" class="form-control"/>
                                    <form:errors path="firstName" cssClass="error"/>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Surname:</label>
                            <spring:bind path="surname">
                                <div class="col-lg-9 ${status.error ? 'has-error' : ''}">
                                    <form:input path="surname" class="form-control"/>
                                    <form:errors path="surname" cssClass="error"/>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Email:</label>
                            <spring:bind path="email">
                                <div class="col-lg-9 ${status.error ? 'has-error' : ''}">
                                    <form:input path="email" class="form-control" type="email"/>
                                    <form:errors path="email" cssClass="error"/>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Password:</label>
                            <spring:bind path="password">
                                <div class="col-lg-9 ${status.error ? 'has-error' : ''}">
                                    <form:password path="password" class="form-control"/>
                                    <form:errors path="password" cssClass="error"/>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Confirm password:</label>
                            <spring:bind path="confirmPassword">
                                <div class="col-lg-9 ${status.error ? 'has-error' : ''}">
                                    <form:password path="confirmPassword" class="form-control" value="" />
                                    <form:errors path="confirmPassword" cssClass="error"/>
                                </div>
                            </spring:bind>
                        </div>
                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label">Date of birth:</label>
                            <spring:bind path="birthDate">
                                <div class="col-lg-9 pull-left ${status.error ? 'has-error' : ''}">
                                    <form:input type="date" pattern="yyyy-MM-dd" path="birthDate"/>
                                    <form:errors path="birthDate" cssClass="error"/>
                                </div>
                            </spring:bind>
                        </div>

                        <div class="form-group row">
                            <label class="col-lg-3 col-form-label form-control-label"></label>
                            <div class="col-lg-9">
<%--                                <button class="mt-3 pl-1 pr-1 btn btn-warning cancelSaveUserButton">Cancel</button>--%>
                                <button class="mt-3 pl-1 pr-1 btn btn-primary saveUserButton" data-id="${updateUserSession.id}">
                                    Save Changes
                                </button>
<%--                                <input type="reset" class="btn btn-secondary" value="Cancel" />--%>
<%--                                <input type="button" class="btn btn-primary" value="Save Changes" />--%>
                            </div>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

<%--        <div class="col-lg-4 pull-lg-8 text-xs-center">--%>
<%--            <img src="//placehold.it/150" class="m-x-auto img-fluid img-circle" alt="avatar" />--%>
<%--            <h6 class="m-t-2">Upload a different photo</h6>--%>
<%--            <label class="custom-file">--%>
<%--                <input type="file" id="file" class="custom-file-input">--%>
<%--                <span class="custom-file-control">Choose file</span>--%>
<%--            </label>--%>
<%--        </div>--%>
    </div>

    <jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>
</html>
