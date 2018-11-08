<%--
  Created by IntelliJ IDEA.
  User: eckran
  Date: 07/11/2018
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <form action="/banque/addCompte" method="post">
                    <table class="table table-user-information ">
                        <tbody>
                        <tr>
                            <td>solde: </td>
                            <td>
                                <input name="solde" focus/>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                    <input id="id" name="login" type="hidden" value="${userCon.getLogin()}">
                    <input type="submit" class="btn btn-primary btn-block" value="créer">
                </form>
            </div>
        </div>
    </div>


    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>