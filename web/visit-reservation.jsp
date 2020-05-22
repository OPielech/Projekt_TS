<%@ page import="edu.ib.dbutils.DBUtilUser" %>
<%@ page import="edu.ib.entities.Specialist" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.ib.entities.Place" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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

<form action="ServletVisitForm" method="get">

    <%
        DBUtilUser dbUtilUser;
        String DB_URL = "jdbc:mysql://localhost:3306/clinic?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=CET";


        try {
            dbUtilUser = new DBUtilUser(DB_URL);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new ServletException(e);
        }

        List<Specialist> specialistList = null;
        List<Place> placeList = null;

        try {
            specialistList = dbUtilUser.getSpecialists();
            placeList = dbUtilUser.getPlaces();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("SPECIALISTS_LIST", specialistList);
        request.setAttribute("PLACES_LIST", placeList);
    %>

    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5" style="color: white;">
        Wybierz specialistę, placówkę oraz datę a następnie sprawdź czy są dostępne godziny
    </div>

    <br>
    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5">
        <select name="specialists" class="drop3">
            <c:forEach var="specialist" items="${SPECIALISTS_LIST}">
                <option value="${specialist.specialistName}">${specialist.specialistName}</option>
            </c:forEach>
        </select>
    </div>

    <br>
    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5">
        <select name="places" class="drop2">
            <c:forEach var="place" items="${PLACES_LIST}">
                <option value="${place.placeValue}">${place.placeValue}</option>
            </c:forEach>
        </select>
    </div>

    <br>
    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5">
        <label>
            <input type="date" name="visitDate" class="drop1">
        </label>
    </div>

    <br>
    <div class="w-100"></div>
    <div class="col-lg-2 offset-lg-5">
        <button type="submit" class="button5">Sprawdź dostępność</button>
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