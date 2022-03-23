
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Management Application</title>


</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="contact-box">

        <input type="button" value="Aggiungi Utente"
               onclick="window.location.href='showForm'; return false;"
               class="btn2" />

                <table>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>Data di Nascita</th>
                        <th>Username</th>
                    </tr>

                    <!-- loop over and print our users -->
                    <c:forEach var="tempUser" items="${users}">

                        <!-- construct an "update" link with user id -->
                        <c:url var="updateLink" value="/user/updateForm">
                            <c:param name="userId" value="${tempUser.id}" />
                        </c:url>

                        <!-- construct an "delete" link with user id -->
                        <c:url var="deleteLink" value="/user/delete">
                            <c:param name="userId" value="${tempUser.id}" />
                        </c:url>

                        <tr>
                            <td>${tempUser.id}</td>
                            <td>${tempUser.firstName}</td>
                            <td>${tempUser.lastName}</td>
                            <td>${tempUser.date}</td>
                            <td>${tempUser.username}</td>
                            <td>
                                <a href="${updateLink}">Update</a>
                                <a href="${deleteLink}"
                                   onclick="if (!(confirm('Confermi di voler cancellare questo utente?'))) return false">Elimina</a>
                            </td>

                        </tr>

                    </c:forEach>

                </table>

            </div>

</body>
</html>