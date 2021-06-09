<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib
        uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>
<!DOCTYPE html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="UTF-8">
    <title>Formulaire</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<form method="post" action="login">
  <p>
    <label for="name">Nom : </label>
    <input type="text" name="name" id="name" />
  </p>

  <input type="submit" />
</form>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>