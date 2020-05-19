package edu.ib.servlets;

import edu.ib.dbutils.DBUtilUser;
import edu.ib.entities.Place;
import edu.ib.entities.Specialist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
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
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

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

        RequestDispatcher dispatcher = request.getRequestDispatcher("/visit-reservation.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}//end of class
