
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


        <c:forEach var="tempPrenotazione" items="${prenotazioniConfermate}">

            <tr>
                <td>${tempPrenotazione.id}</td>
                <td>${tempPrenotazione.dateStart}</td>
                <td>${tempPrenotazione.dateEnd}</td>
            </tr>

        </c:forEach>

    </table>

</div>

</body>
</html>
