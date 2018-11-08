<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="../css/leftNavigation.css" />
    <link rel="stylesheet" href="../css/addTransaction.css" />
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <%@ include file="/WEB-INF/Element/leftNavigation.jsp" %>

        <div class="col-10">
            <h1 class="title"> Ajouter une transaction</h1>

            <div>
                <form id="formulaire" action="" method="POST">
                    <input class="input" type="text" id="libelle" name="libelle" placeholder="libelle"><br>
                    <input class="input" type="number" id="montant" name="montant" placeholder="montant"><br>
                    <input class="input" type="number" id="compte" name="compte" placeholder="compte"><br>
                    <input class="input" type="submit" value="Send">
                </form>
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
