
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Prenotazioni Management Application</title>


</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="contact-box">


    <table>
        <tr>
            <th>ID</th>
            <th>Data di Inizio Prenotazione</th>
            <th>Data di Fine Prenotazione</th>
        </tr>


        <c:forEach var="tempPrenotazione" items="${prenotazioni}">


            <c:url var="confermaLink" value="/prenotazione/conferma">
                <c:param name="prenotazioneId" value="${tempPrenotazione.id}" />
            </c:url>


            <c:url var="deleteLink" value="/prenotazione/delete">
                <c:param name="prenotazioneId" value="${tempPrenotazione.id}" />
            </c:url>

            <tr>
                <td>${tempPrenotazione.id}</td>
                <td>${tempPrenotazione.dateStart}</td>
                <td>${tempPrenotazione.dateEnd}</td>
                <td>
                    <c:if test="${tempPrenotazione.stato == 0}">
                        <a href="${confermaLink}"
                        onclick="if (!(confirm('Confermare questa prenotazione?'))) return false">Conferma</a>
                    </c:if>
                    <c:if test="${tempPrenotazione.stato == 1}">
                        <p>Confermata</p>
                    </c:if>
                    <a href="${deleteLink}"
                       onclick="if (!(confirm('Confermi di voler cancellare questa prenotazione?'))) return false">Elimina</a>
                </td>

            </tr>

        </c:forEach>

    </table>

</div>

</body>
</html>