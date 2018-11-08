<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="messages"/>
<fmt:setLocale value="fr"/>


<html>
<head>
    <title>Mes comptes</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/leftNavigation.css" />
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/Element/leftNavigation.jsp" %>

        <div class="col-10">
            <h1><fmt:message key="bienvenue"/> <c:out value="${userCon.getNom()}"/> <c:out
                    value="${userCon.getPrenom()}"/> </b></h1>
            <h3> vos comptes</h3>

            <div class="container">
                <div class="row">
                        <c:forEach items="${comptes}" var="compte" varStatus="status">
                            <div class="col-4">
                                <p>id <c:out value="${compte.getId()}"/> : <c:out value="${compte.getSolde()}"/> €</p>
                                <button><a href="/banque/transaction?id=${compte.getId()}">Details</a></button>
                            </div>
                        </c:forEach>
                </div>
            </div>


        </div>
    </div>

</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
