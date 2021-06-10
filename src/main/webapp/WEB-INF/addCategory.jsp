<%--
  Created by IntelliJ IDEA.
  User: dsarrazy
  Date: 09/06/2021
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajouter une catégorie</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<form action="<c:url value="/auth/addCategorie" />" method="post">
    <label for="name">Category name :</label>
    <input type="text" name="name" id="name">

    <input type="submit" value="Ajouter">
</form>
<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
