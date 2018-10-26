<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="messages"/>
<fmt:setLocale value="fr"/>


<html>
<head>
    <title>Mes comptes</title>
</head>
<body>
<h1><fmt:message key="bienvenue"/> <c:out value="${userCon.getNom()}" /> <c:out value="${userCon.getPrenom()}" /> </b></h1>
<p> vos comptes</p>
<div>
    <c:forEach items="${userCon.getComptes()}" var="compte" varStatus="status" >
    <p>id <c:out value="${compte.getId()}" /> : <c:out value="${compte.getSolde()}" /> €</p>
    </c:forEach>
</div>

</body>
</html>
