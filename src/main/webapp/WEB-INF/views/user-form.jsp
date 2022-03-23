
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>User Management Application</title>



</head>
<body>
<%@include file="/WEB-INF/views/header.jsp"%>
<div class="contact-box">

                <form:form action="saveUser" method="post" modelAttribute="user">
                            <form:hidden path="id" value="${user.id}"/>

                            <form:input path="firstName" class ="input-field" placeholder="Nome" required="required"/>

                            <form:input path="lastName" class="input-field" placeholder="Cognome" required="required"/>

                            <form:input type="date" path="date" class="input-field" required="required"/>

                            <form:input path="username" class="input-field" placeholder="Username" required="required"/>

                            <form:input type="password" path="password" class="input-field" placeholder="Password" required="required"/>

                            <form:button class="btn">Aggiungi Utente</form:button>

                </form:form>

</div>
</body>
</html>