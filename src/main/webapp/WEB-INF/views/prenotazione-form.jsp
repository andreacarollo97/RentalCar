
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Prenotazioni Management Application</title>



</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="contact-box">

    <form action="listAuto" method="post">

        <h5>Data di Inizio Prenotazione</h5>
        <input type="date" name="dateStart" class="input-field" required="required"/>

        <h5>Data di Fine Prenotazione</h5>
        <input type="date" name="dateEnd" class="input-field" required="required"/>

        <button class="btn3">Mostra Auto disponibili in questo Intervallo</button>

    </form>

</div>
</body>
</html>
