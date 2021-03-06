package edu.ib.servlets;

import edu.ib.dbutils.DBUtilUser;
import edu.ib.entities.Hour;
import edu.ib.entities.Place;
import edu.ib.entities.Specialist;
import jdk.jfr.DataAmount;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/ServletCheckHours")
public class ServletCheckHours extends HttpServlet {

    private DBUtilUser dbUtilUser;
    private final String DB_URL = "jdbc:mysql://localhost:3306/clinic?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=CET";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            dbUtilUser = new DBUtilUser(DB_URL);
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }//end of init

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }//end of doPost

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        List<Hour> hourList = null;

        boolean isOk = false;

        String specialistName = request.getParameter("specialists");
        Date visitDate = Date.valueOf(request.getParameter("visitDate"));
        String placeValue = request.getParameter("places");

        try {
            if (isAvailable(specialistName, visitDate, placeValue))
                isOk = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isOk) {

            try {
                hourList = dbUtilUser.getHours(specialistName, visitDate, placeValue);
            } catch (Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("HOURS_LIST", hourList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/visit-reservation-hours.jsp");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/visit-reservation-error.jsp");
            dispatcher.forward(request, response);
        }

    }

    private boolean isAvailable(String specialistName, Date visitDate, String placeValue) throws Exception {

        int result = dbUtilUser.checkAvailability(specialistName, visitDate, placeValue);

        return result == 1;
    }//end of isAvailable

}//end of class
