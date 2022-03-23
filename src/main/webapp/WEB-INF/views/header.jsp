<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file="/WEB-INF/style.css" %>
    </style>
</head>
<body>
<header>
    <div class="header">
        <div class="inner_header">
            <div class="logo_container">
                <h1>Rental <span>CAR</span></h1>
            </div>
            <security:authorize access="isAuthenticated()">
            <security:authorize access="hasRole('ADMIN')">
            <ul class="navigation">
                    <c:url var="AutoList" value="/auto/list"></c:url>
                <a href=${AutoList}>
                    <li>Parco Auto</li>
                </a>

                    <c:url var="UserList" value="/user/list"></c:url>
                <a href=${UserList}>
                    <li>Elenco Utenti</li>
                </a>

                    <c:url var="PrenotazioneList" value="/prenotazione/list"></c:url>
                <a href=${PrenotazioneList}>
                    <li>Prenotazioni</li>
                </a>

                    <c:url var="logout" value="/logout"></c:url>
                <a href=${logout}>
                    <li>Logout</li>
                </a>
                </security:authorize>
                <security:authorize access="hasRole('CUSTOMER')">
                <ul class="navigation">
                        <c:url var="AutoList" value="/auto/list"></c:url>
                    <a href=${AutoList}>
                        <li>Parco Auto</li>
                    </a>

                        <c:url var="PrenotazioneList" value="/prenotazione/showForm"></c:url>
                    <a href=${PrenotazioneList}>
                        <li>Prenota un'Auto</li>
                    </a>

                        <c:url var="PrenotazioniConfermateList" value="/prenotazione/listPrenotazioniConfermate"></c:url>
                    <a href=${PrenotazioniConfermateList}>
                        <li>Le tue Prenotazioni</li>
                    </a>


                        <c:url var="logout" value="/logout"></c:url>
                    <a href=${logout}>
                        <li>Logout</li>
                    </a>
                    </security:authorize>
                    </security:authorize>
                    <security:authorize access="!isAuthenticated()">
                    <ul class="navigation">
                        <c:url var="login" value="/login"></c:url>
                        <a href=${login}>
                            <li>Login</li>
                        </a>
                    </ul>
                    </security:authorize>


        </div>
    </div>
</header>
</body>
</html>
