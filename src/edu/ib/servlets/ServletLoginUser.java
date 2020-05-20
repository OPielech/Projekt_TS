package edu.ib.servlets;

import edu.ib.dbutils.DBUtilUser;
import edu.ib.entities.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/ServletLoginUser")
public class ServletLoginUser extends HttpServlet {

    private String userLogin;
    private String userPassword;
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
        request.setCharacterEncoding("UTF-8");
        boolean isOk = false;

        try {
            if (validateUser(request, response)) {
                isOk = true;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        if (isOk) {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/user-menu.jsp");
            dispatcher.forward(request, response);

        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/user-login-error.jsp");
            dispatcher.forward(request, response);
        }


    }

    private boolean validateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {

        userLogin = request.getParameter("userLogin");
        userPassword = request.getParameter("userPassword");

        User user = dbUtilUser.getUser(userLogin);


        return user.getUserPassword().equals(userPassword);
    }


}//end of class
