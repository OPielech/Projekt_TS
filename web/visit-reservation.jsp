<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>

<form action="ServletCheckHours" method="get">

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
    <button type="submit">Sprawdź dostępność</button>

    <%
//        out.print(request.getAttribute("mhm"));
        session.setAttribute("mhm", "kurwa");
    %>

</form>
</body>
</html>