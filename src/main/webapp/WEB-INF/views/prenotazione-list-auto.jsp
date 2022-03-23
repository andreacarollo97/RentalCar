
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Prenotazione Auto Management Application</title>


</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="contact-box">

    <table>
        <tr>
            <th>Targa</th>
            <th>Marca</th>
            <th>Modello</th>
        </tr>

        <!-- loop over and print our auto -->
        <c:forEach var="tempAuto" items="${autolist}">
            <tr>
                <td>${tempAuto.targa}</td>
                <td>${tempAuto.marca}</td>
                <td>${tempAuto.modello}</td>
            <td>
                <form action="savePrenotazione" method="post">

                    <input type="hidden" name="auto_id" value="${tempAuto.id}"/>

                    <input type="hidden" name="dateS" value="${dataInizio}"/>
                    <input type="hidden" name="dateE" value="${dataFine}"/>

                    <button type="submit" class="btn">Prenota</button>
                </form>
            </td>
            </tr>
        </c:forEach>

    </table>

</div>

</body>
</html>
