
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Auto Management Application</title>



</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="contact-box">

    <form:form action="saveAuto" method="post" modelAttribute="auto">
        <form:hidden path="id" value="${auto.id}"/>

        <form:input path="targa" class ="input-field" placeholder="Targa" required="required"/>

        <form:input path="marca" class="input-field" placeholder="Marca" required="required"/>

        <form:input path="modello" class="input-field" placeholder="Modello" required="required"/>

        <form:button class="btn">Aggiungi Auto</form:button>

    </form:form>

</div>
</body>
</html>