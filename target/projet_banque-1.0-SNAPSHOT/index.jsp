<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setBundle basename="messages"/>
<fmt:setLocale value="fr" scope="session"/>



<html>
  <head>
    <title>Welcome</title>
  </head>
  <body>
  <fmt:message key="bienvenue"/>
  <button onclick="changeLocale('fr')">Francais</button>
  <button onclick="changeLocale('en')">English</button>
  $END$
  <script>
      var changeLocale = function(language) {
          <fmt:setLocale value="language" scope="session"/>
          console.log(language);
          console.log(<fmt:setLocale value="language" scope="session"/>)
      };
  </script>
  </body>
</html>
