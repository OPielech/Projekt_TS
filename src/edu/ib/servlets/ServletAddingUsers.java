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
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@WebServlet("/ServletAddingUsers")
public class ServletAddingUsers extends HttpServlet {

    private DBUtilUser dbUtilUser;
    private final String DB_URL = "jdbc:mysql://localhost:3306/clinic?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=CET";

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            dbUtilUser = new DBUtilUser(DB_URL);
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            throw new ServletException(e);
        }
    }//end of init

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }//end of doPost

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        boolean isOk = true;

        try {
            addUser(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-menu.html");
        dispatcher.forward(request, response);

    }

    private void addUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");
        String userSurname = request.getParameter("userSurname");
        String userEmail = request.getParameter("userEmail");
        Date userBirthDate = Date.valueOf(request.getParameter("userBirthDate"));
        String userCity = request.getParameter("userCity");
        String userPostcode = request.getParameter("userPostcode");
        String userPhone = request.getParameter("userPhone");
        String userLogin = request.getParameter("userLogin");
        String userPassword = request.getParameter("userPassword");

        User user = new User(userLogin, userPassword, userName, userSurname, userEmail, userBirthDate, userCity, userPostcode, userPhone);
        dbUtilUser.addUser(user);
    }


}//end of class
