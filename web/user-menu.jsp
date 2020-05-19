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
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="ServletVisitForm" method="post">
    <button type="submit">Zarezerwuj wizytę</button>
</form>

<form action="index.jsp" method="get">
    <button type="submit">Nadchodzące wizyty</button>
</form>

<form action="ServletPastVisits" method="post">
    <button type="submit">Odbyte wizyty</button>
</form>

<form action="index.jsp" method="get">
    <button type="submit">Strona główna</button>
</form>

<%
    HttpSession session1 = request.getSession();
    session1.setAttribute("userLogin", request.getParameter("userLogin"));
    session1.setAttribute("userPassword", request.getParameter("userPassword"));
%>
</body>
</html>
