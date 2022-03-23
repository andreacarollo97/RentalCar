<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Auto Management Application</title>


</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="contact-box">
    <security:authorize access="isAuthenticated()">
        <security:authorize access="hasRole('ADMIN')">
            <input type="button" value="Aggiungi Auto"
                   onclick="window.location.href='showForm'; return false;"
                   class="btn2" />
        </security:authorize>


    <table>
        <tr>
            <th>ID</th>
            <th>Targa</th>
            <th>Marca</th>
            <th>Modello</th>
        </tr>

        <c:forEach var="tempAuto" items="${auto}">

            <c:url var="updateLink" value="/auto/updateForm">
                <c:param name="autoId" value="${tempAuto.id}" />
            </c:url>

            <c:url var="deleteLink" value="/auto/delete">
                <c:param name="autoId" value="${tempAuto.id}" />
            </c:url>

            <tr>
                <td>${tempAuto.id}</td>
                <td>${tempAuto.targa}</td>
                <td>${tempAuto.marca}</td>
                <td>${tempAuto.modello}</td>
                <security:authorize access="hasRole('ADMIN')">
                    <td>
                        <a href="${updateLink}">Update</a>
                        <a href="${deleteLink}"
                           onclick="if (!(confirm('Confermi di voler cancellare questa auto?'))) return false">Elimina</a>
                    </td>
                </security:authorize>



            </tr>

        </c:forEach>
        </security:authorize>
    </table>

</div>

</body>
</html>
