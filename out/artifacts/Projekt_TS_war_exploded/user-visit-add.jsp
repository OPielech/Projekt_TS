<%@ page import="edu.ib.servlets.ServletCheckHours" %>
<%@ page import="edu.ib.dbutils.DBUtilUser" %>
<%@ page import="java.sql.Date" %>
<%@ page import="java.sql.Time" %>
<%@ page import="java.time.LocalTime" %>
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

<form action="ServletLoginUser" method="get">
    <section class="clinic">
        <div class="container">
            <div class="row">

                <div class="col-lg-3 offset-lg-4">
                    Potwierdzenie wizyty:
                </div>

                <div class="w-100"></div>
                <div class="w-100"></div>
                <div class="col-lg-3 offset-lg-4">
                    Specialista:
                </div>
                <div class="col-lg-3">
                    <label>
                        <%out.println(session.getAttribute("specialist")); %>
                    </label>
                </div>

                <div class="w-100"></div>
                <div class="col-lg-3 offset-lg-4">
                    Placówka:
                </div>
                <div class="col-lg-3">
                    <label>
                        <%out.println(session.getAttribute("place")); %>
                    </label>
                </div>

                <div class="w-100"></div>
                <div class="col-lg-3 offset-lg-4">
                    Data:
                </div>
                <div class="col-lg-3">
                    <label>
                        <%out.println(session.getAttribute("visitDate")); %>
                    </label>
                </div>

                <div class="w-100"></div>
                <div class="col-lg-3 offset-lg-4">
                    Godzina:
                </div>
                <div class="col-lg-3">
                    <label>
                        <%out.println(request.getParameter("hours")); %>
                    </label>
                </div>

                <%

                    String userLogin = (String) session.getAttribute("userLogin");
                    String specialistName = (String) session.getAttribute("specialist");
                    String placeName = (String) session.getAttribute("place");
                    String visitDate = (String) session.getAttribute("visitDate");
                    String visitHour = request.getParameter("hours") + ":00";

                    DBUtilUser dbUtilUser;
                    String DB_URL = "jdbc:mysql://localhost:3306/clinic?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=CET";

                    dbUtilUser = new DBUtilUser(DB_URL);
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    try {
                        dbUtilUser.addReservation(userLogin, specialistName, placeName, Date.valueOf(visitDate), Time.valueOf(visitHour));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


                %>

                <div class="w-100"></div>
                <div class="col-lg-3 offset-lg-5">
                    <button type="submit" class="button5">Powrót</button>
                </div>
            </div>
        </div>
    </section>

</form>
</body>
<style>
    body {
        background-repeat: no-repeat;
        background-size: cover;
        background-color: black;
        color: white;
    }
</style>
</html>
