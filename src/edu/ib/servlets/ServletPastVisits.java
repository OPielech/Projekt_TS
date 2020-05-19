package edu.ib.servlets;

import edu.ib.dbutils.DBUtilUser;
import edu.ib.entities.VisitView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ServletPastVisits")
public class ServletPastVisits extends HttpServlet {
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


        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-visits-past.jsp");

        List<VisitView> visitViewList = null;

        HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("userLogin");
        try {
            visitViewList = dbUtilUser.getPastVisits(userLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("VISITS_LIST", visitViewList);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

}//end of class
