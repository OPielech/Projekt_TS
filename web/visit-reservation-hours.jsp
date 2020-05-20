<%--
  Created by IntelliJ IDEA.
  User: oskar
  Date: 19.05.2020
  Time: 12:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Bardzo ładnie, wybierz godzinke!

<form action="user-visit-add.jsp" method="get">

    <select name="hours">
        <c:forEach var="hour" items="${HOURS_LIST}">
            <option value="${hour.hourValue}">${hour.hourValue}</option>
        </c:forEach>
    </select>

    <%
        HttpSession session1 = request.getSession();
        session1.setAttribute("place", request.getParameter("places"));
        session1.setAttribute("specialist", request.getParameter("specialists"));
        session1.setAttribute("visitDate", request.getParameter("visitDate"));
        session1.setAttribute("hourValue", request.getParameter("hours"));
    %>

    <button type="submit">Rezerwuj</button>

</form>
</body>
</html>
