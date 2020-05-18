<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
Bardzo ładny user

<label>
    <select name="category">
        <c:forEach var="specialist" items="${SPECIALISTS_LIST}">
            <option value="${specialist.specialistId}">${specialist.specialistName}</option>
        </c:forEach>
    </select>
</label>
</body>
</html>