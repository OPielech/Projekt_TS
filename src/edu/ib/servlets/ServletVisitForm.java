package edu.ib.servlets;

import edu.ib.dbutils.DBUtilUser;
import edu.ib.entities.Hour;
import edu.ib.entities.Place;
import edu.ib.entities.Specialist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/ServletVisitForm")
public class ServletVisitForm extends HttpServlet {
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
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        boolean isDateOk = false;
        boolean isAfter = false;

        String tempDate = request.getParameter("visitDate");

        if (tempDate.isEmpty())
            isDateOk=false;
        else
            isDateOk=true;

        if (isDateOk) {
            Date date = Date.valueOf(tempDate);
            LocalDate localDate = date.toLocalDate();

            if(localDate.isBefore(LocalDate.now()))
                isAfter = false;
            else
                isAfter = true;
        }

        if (isAfter && isDateOk) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("ServletCheckHours");
            dispatcher.forward(request, response);
        }
        else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/visit-reservation-error.jsp");
            dispatcher.forward(request, response);
        }    }

}//end of class
