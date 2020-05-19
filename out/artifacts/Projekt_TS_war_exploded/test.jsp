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
<html>
<head>
    <title>Title</title>
</head>
<body>
Bardzo ładnie, wybierz godzinke!

<form action="ServletAddReservation" method="get">

    <%

//        out.println(request.getSession().getAttribute("userLogin"));
//        out.println(request.getSession().getAttribute("specialists"));
//        out.println(request.getParameter("hours"));
//        out.println("xD");
//        out.println(session.getAttribute("xD"));
//        out.println(session.getAttribute("userLogin"));
//        out.println(session.getAttribute("omg"));
//        out.println(session.getAttribute("mhm"));
//        out.println(session.getAttribute("hourValue"));
//        out.println(session.getAttribute("pap"));
//        out.println(session.getAttribute("omg"));

        out.println(session.getAttribute("userLogin"));
        out.println(session.getAttribute("userPassword"));
        out.println(request.getParameter("hours"));
        out.println(session.getAttribute("specialist"));
        out.println(session.getAttribute("place"));
        out.println(session.getAttribute("visitDate"));

        String userLogin = (String) session.getAttribute("userLogin");
        String specialistName = (String) session.getAttribute("specialist");
        String placeName = (String) session.getAttribute("place");
        String visitDate = (String) session.getAttribute("visitDate");
        String visitHour = request.getParameter("hours")+":00";

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

<%--    <button type="submit">Rezerwuj</button>--%>

</form>
</body>
</html>
