<%--
  Created by IntelliJ IDEA.
  User: oskar
  Date: 19.05.2020
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<form action="user-visit-add.jsp" method="get">

    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5" style="color: white;">
        Wybierz godzinę spośród dostępnych na liście i potwierdź wizytę
    </div>
    <br>
    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5">
        <select name="hours" class="drop2">
            <c:forEach var="hour" items="${HOURS_LIST}">
                <option value="${hour.hourValue}">${hour.hourValue}</option>
            </c:forEach>
        </select>
    </div>
    <br>

    <%
        HttpSession session1 = request.getSession();
        session1.setAttribute("place", request.getParameter("places"));
        session1.setAttribute("specialist", request.getParameter("specialists"));
        session1.setAttribute("visitDate", request.getParameter("visitDate"));
        session1.setAttribute("hourValue", request.getParameter("hours"));
    %>

    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5">
        <button type="submit" class="button5">Potwierdź</button>
    </div>

</form>
</body>
<style>
    body {
        background-repeat: no-repeat;
        background-size: cover;
        background-color: black;
    }
</style>
</html>
