<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <jsp:include page="/WEB-INF/views/fragment/header.jsp"/>
    <link href='<c:url value="/css/excursion-add.css"/>' rel="stylesheet" type="text/css">
    <title>Join the footprints - Add Excursion</title>
</head>

<body>

<jsp:include page="/WEB-INF/views/fragment/main-navbar-app.jsp"/>

<%--<section class="dashboard-section mt-0">--%>
    <div class="container">
        <div class="row form-val">

            <div class="col-lg-2 col-md-2">
                <jsp:include page="/WEB-INF/views/fragment/app-navbar.jsp"/>
            </div>

            <div class="col-lg-10 col-md-6 col-sm-4">
                <div class="m-4 p-3 width-medium text-color-darker">
                    <div class="form-content dashboard-content border-dashed p-3 m-4 view-height">
                        <div class="mt-4 ml-4 mr-4">
                            <div class="row border-bottom border-3">
                                <div class="col">
                                    <h3 class="color-header text-uppercase text-center">New excursion</h3>
                                </div>
                            </div>
                            <form:form method="post" modelAttribute="excursionForm">
                                <form:hidden path="organizer"/>
                                <c:if test="${excursionForm.id ne null}">
                                    <form:hidden path="id"/>
                                </c:if>
                                <div class="mt-5">
                                    <table class="table borderless">
                                        <tbody>
                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Title</th>
                                            <td class="col-7">
                                                <spring:bind path="title">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                                        <form:input path="title" cssClass="w-100 p-1"/>
                                                        <form:errors path="title" cssClass="error" element="div"/>
                                                    </div>
                                                </spring:bind>
                                            </td>
                                        </tr>

                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Countries</th>
                                            <td class="col-3">
                                                <spring:bind path="countries">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                                        <form:select path="countries" multiple="true">
                                                            <form:option value="" label="--Select destinations--"/>
                                                            <form:options items="${countryItems}" itemValue="id"
                                                                          itemLabel="name"/>
                                                        </form:select>
                                                        <form:errors path="countries" cssClass="error" element="div"/>
                                                    </div>
                                                </spring:bind>
                                                    <%--                                                Zdarzenie onClick, który kopiuje kraj i pokazuje w <li></li>--%>
                                                <c:if test="${countryItems.size() != 0}">
                                                    <ul class="list-unstyled">
                                                        <li><c:out value="wartość z country"/></li>
                                                    </ul>
                                                </c:if>
                                            </td>
                                        </tr>

                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Date</th>
                                            <td class="col-7">
                                                <div class="row">
                                                    <div class="col-md-6">
                                                        departure: <br>
                                                        <spring:bind path="dateOfDeparture">
                                                            <div class="form-group ${status.error ? 'has-error' : ''}">

                                                                <form:input path="dateOfDeparture" type="date"
                                                                            formatter="yyyy-MM-dd" class="w-100 p-1"/>
                                                                <form:errors path="dateOfDeparture" cssClass="error"
                                                                             element="div"/>
                                                            </div>
                                                        </spring:bind>
                                                    </div>

                                                    <div class="col-md-6">
                                                        arrive: <br>
                                                        <spring:bind path="dateOfArrival">
                                                            <div class="form-group ${status.error ? 'has-error' : ''}">
                                                                <form:input path="dateOfArrival" type="date"
                                                                            formatter="yyyy-MM-dd" class="w-100 p-1"/>
                                                                <form:errors path="dateOfArrival" cssClass="error"
                                                                             element="div"/>
                                                            </div>
                                                        </spring:bind>
                                                    </div>
                                                </div>
                                            </td>
                                        </tr>

                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Expense</th>
                                            <td class="col-3">
                                                <spring:bind path="expense">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                                        <form:input path="expense" class="w-100 p-1"/>
                                                        <form:errors path="expense" cssClass="error" element="div"/>
                                                    </div>
                                                </spring:bind>
                                            </td>
                                        </tr>
<%--                                        <tr class="d-flex">--%>
<%--                                            <th scope="row" class="col-2">Expense</th>--%>
<%--                                            <td class="col-3">--%>
<%--                                                <spring:bind path="testExpense">--%>
<%--                                                    <div class="form-group ${status.error ? 'has-error' : ''}">--%>
<%--                                                        <form:input path="testExpense" class="w-100 p-1"/>--%>
<%--                                                        <form:errors path="testExpense" cssClass="error" element="div"/>--%>
<%--                                                    </div>--%>
<%--                                                </spring:bind>--%>
<%--                                            </td>--%>
<%--                                        </tr>--%>

                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Members limit:</th>
                                            <td class="col-3">
                                                <spring:bind path="maxMembers">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                                        <form:input path="maxMembers" type="number" class="w-100 p-1"/>
                                                        <form:errors path="maxMembers" cssClass="error" element="div"/>
                                                    </div>
                                                </spring:bind>
                                            </td>
                                        </tr>

                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Categories</th>
                                            <td class="col-3">
                                                <spring:bind path="categories">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                                        <form:select path="categories" multiple="true">
                                                            <form:option value="" label="--Select caterogies--"/>
                                                            <form:options items="${categoryItems}" itemValue="id"
                                                                          itemLabel="name"/>
                                                        </form:select>
                                                        <form:errors path="categories" cssClass="error" element="div"/>
                                                    </div>
                                                </spring:bind>
                                            </td>
                                        </tr>

                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Description</th>
                                            <td class="col-7">
                                                <spring:bind path="description">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                                        <form:textarea path="description" class="w-100 p-1"
                                                                       rows="5"
                                                                       placeholder="Email contact, ecxursion details..."/>
                                                    </div>
                                                </spring:bind>
                                            </td>
                                        </tr>

                                        <tr class="d-flex">
                                            <th scope="row" class="col-2">Phone number</th>
                                            <td class="col-3">
                                                <spring:bind path="phoneNumber">
                                                    <div class="form-group ${status.error ? 'has-error' : ''}">
                                                        <form:input path="phoneNumber" class="w-100 p-1"/>
                                                        <form:errors path="phoneNumber" cssClass="error" element="div"/>
                                                    </div>
                                                </spring:bind>
                                            </td>
                                        </tr>

<%--                                        <tr class="d-flex">--%>
<%--                                            <form method="POST" action="getdata.php" enctype="multipart/form-data">--%>
<%--                                                <th scope="row" class="col-2">Add photo</th>--%>
<%--                                                <td class="col-3">--%>
<%--                                                    <input type="file" name="myimage" class="w-100 p-1">--%>
<%--                                                    <input type="submit" name="submit_image" value="Upload">--%>
<%--                                                </td>--%>
<%--                                            </form>--%>
<%--                                        </tr>--%>

                                        </tbody>
                                    </table>
                                    <div class="col-11 d-flex justify-content-end mt-5 mb-2">
                                        <button type="submit" class="btn btn-color rounded-4 pt-0 pb-0 pr-4 pl-4">Add
                                        </button>
                                    </div>
                                </div>
                            </form:form>
                            <button class="mt-3 pl-1 pr-1" id="backButton">Back</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

<jsp:include page="/WEB-INF/views/fragment/footer.jsp"/>

</body>

</html>