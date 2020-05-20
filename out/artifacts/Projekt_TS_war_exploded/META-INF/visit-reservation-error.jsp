<%@ page import="edu.ib.dbutils.DBUtilUser" %>
<%@ page import="edu.ib.entities.Specialist" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.ib.entities.Place" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
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

    <select name="specialists">
        <c:forEach var="specialist" items="${SPECIALISTS_LIST}">
            <option value="${specialist.specialistName}">${specialist.specialistName}</option>
        </c:forEach>
    </select>

    <br>

    <select name="places">
        <c:forEach var="place" items="${PLACES_LIST}">
            <option value="${place.placeValue}">${place.placeValue}</option>
        </c:forEach>
    </select>

    <br>

    <label>
        <input type="date" name="visitDate">
    </label>

    <br>
    Podaj poprawne dane

    <br>
    <button type="submit">Sprawdź dostępność</button>

</form>
</body>
</html>