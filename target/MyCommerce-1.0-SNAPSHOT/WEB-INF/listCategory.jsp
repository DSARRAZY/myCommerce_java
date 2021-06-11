<%--
  Created by IntelliJ IDEA.
  User: dsarrazy
  Date: 10/06/2021
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des catégories</title>
</head>
<body>
<%@ include file="/WEB-INF/header.jsp" %>
<table>
    <c:forEach items="${category}" var="t">
        <tr>
            <td><c:out value="${t.name}" /></td>
<%--            <td>--%>
<%--                <a href="${pageContext.request.contextPath}/auth/show-product?id=${t.id}">Voir</a>--%>
<%--                <a href="${pageContext.request.contextPath}/auth/removeProduct?id=${t.id}">Supprimer</a>--%>
<%--            </td>--%>
        </tr>
    </c:forEach>
</table>

<%@ include file="/WEB-INF/footer.jsp" %>
</body>
</html>
