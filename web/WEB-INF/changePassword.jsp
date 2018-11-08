<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<fmt:setBundle basename="messages"/>
<fmt:setLocale value="fr"/>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/leftNavigation.css" />
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/Element/leftNavigation.jsp" %>

        <div class="col-10">

            <form action="/banque/changePassword" method="post">
                <table class="table table-user-information ">
                    <tbody>
                    <tr>
                        <td>Mot de passe Actuel:</td>
                        <td>
                            <input icon="password-icon" name="currentPassword" type="password" focus/>
                        </td>
                    </tr>
                    <tr>
                        <td>Nouveau Mot De Passe:</td>
                        <td>
                            <Input icon="password-icon" name="newPassword" type="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Confirmation:</td>
                        <td>
                            <Input icon="password-icon" name="newConfirmPassword" type="password"/>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <input id="id" name="id" type="hidden" value="${userCon.getLogin()}">
                <input id="pass" name="password" type="hidden" value="${userCon.getPassword()}">
                <input type="submit" class="btn btn-primary btn-block" value="changer">
            </form>

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
