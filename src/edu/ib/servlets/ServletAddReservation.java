package edu.ib.servlets;

import edu.ib.dbutils.DBUtilUser;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ServletAddReservation")
public class ServletAddReservation extends HttpServlet {

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

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/test.jsp");
//        dispatcher.forward(request, response);
//        re
    }//end of doGet

}//end of class
