<%--
  Created by IntelliJ IDEA.
  User: dsarrazy
  Date: 09/06/2021
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib
        uri="http://java.sun.com/jsp/jstl/core"
        prefix="c" %>
<html>
<head>
    <title>Menu</title>
</head>
<body>

<a href="<c:url value="/auth/listProduct" />"> Liste des produits </a>
<a href="<c:url value="/auth/addProduct" />">Ajouter un produit </a>
<a href="<c:url value="/logout" />">Se déconnecter</a>
<a href="<c:url value="/login" />">Se connecter</a>

</body>
</html>
