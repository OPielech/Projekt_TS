package edu.ib.servlets;

import edu.ib.dbutils.DBUtilUser;
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

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin-view.jsp");

        List<Specialist> specialistList = null;
        try {
            specialistList = dbUtilUser.getSpecialists();
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("SPECIALISTS_LIST", specialistList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/nice.jsp");
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Specialist specialist = new Specialist();
//
//        try {
//
//            List<Specialist> specialists = dbUtilUser.getSpecialists();
//            request.setAttribute("SPECIALISTS_LIST", specialists);
//
//            RequestDispatcher dispatcher = request.getRequestDispatcher("nice.jsp");
//            dispatcher.forward(request, response);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new ServletException(e);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

}//end of class
