<%--
  Created by IntelliJ IDEA.
  User: oskar
  Date: 19.05.2020
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="pl">
<head>
    <title>Monster Clinic</title>
    <meta name="description" content="Umów się na wizytę z najlepszymi lekarzami w Polsce"/>
    <meta name="keywords" content="lekarz, najlepszy lekarz, wizyta lekarska"/>
    <meta name="author" content="Oskar Pielech">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <link rel='icon' href='images/favicon.ico' type='image/x-icon'/>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/cssMain.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<%--<form action="ServletVisitForm" method="post">--%>
<%--    <button type="submit">Zarezerwuj wizytę</button>--%>
<%--</form>--%>
<%--<form action="visit-reservation.jsp">--%>
<%--    <button type="submit">Zarezerwuj wizytę</button>--%>
<%--</form>--%>

<%--<form action="ServletUpcomingVisits" method="post">--%>
<%--    <button type="submit">Nadchodzące wizyty</button>--%>
<%--</form>--%>

<%--<form action="ServletPastVisits" method="post">--%>
<%--    <button type="submit">Odbyte wizyty</button>--%>
<%--</form>--%>

<%--<form action="index.jsp" method="get">--%>
<%--    <button type="submit">Strona główna</button>--%>
<%--</form>--%>

<div class="w-100"></div>
<div class="col-lg-2 offset-lg-5">
    <form action="visit-reservation.jsp">
        <button type="submit" class="button1">Zarezerwuj wizytę</button>
    </form>
</div>

<div class="w-100"></div>
<div class="col-lg-2 offset-lg-5">
    <form action="ServletUpcomingVisits" method="post">
        <button type="submit" class="button2">Nadchodzące wizyty</button>
    </form>
</div>

<div class="w-100"></div>
<div class="col-lg-2 offset-lg-5">
    <form action="ServletPastVisits" method="post">
        <button type="submit" class="button3">Odbyte wizyty</button>
    </form>
</div>

<div class="w-100"></div>
<div class="col-lg-2 offset-lg-5">
    <form action="index.jsp" method="get">
        <button type="submit" class="button4">Strona główna</button>
    </form>
</div>

<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("userLogin", request.getParameter("userLogin"));
    session1.setAttribute("userPassword", request.getParameter("userPassword"));
%>
</body>
<style>
    body {
        background-repeat: no-repeat;
        background-size: cover;
        background-color: black;
    }
</style>
</html>
