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
import java.sql.Date;
import java.util.List;

@WebServlet("/ServletUpcomingVisits")
public class ServletUpcomingVisits extends HttpServlet {
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


        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-visits-upcoming.jsp");

        List<VisitView> visitViewList = null;

        HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("userLogin");
        try {
            visitViewList = dbUtilUser.getUpcomingVisits(userLogin);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("VISITS_LIST", visitViewList);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            String command = request.getParameter("command");
            if (command == null)
                command = "LIST";

            switch (command) {
                case "LIST":
                    listVisits(request, response);
                    break;
                case "CANCEL":
                    cancelVisit(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void listVisits(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("userLogin");

        List<VisitView> visitViewList = dbUtilUser.getUpcomingVisits(userLogin);

        request.setAttribute("VISITS_LIST", visitViewList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user-visits-upcoming.jsp");
        dispatcher.forward(request, response);
    }

    private void cancelVisit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String userLogin = (String) session.getAttribute("userLogin");
        int specialistId = Integer.parseInt(request.getParameter("specialistId"));
        int placeId = Integer.parseInt(request.getParameter("placeId"));
        Date visitDate = Date.valueOf((request.getParameter("visitDate")));
        int hourId = Integer.parseInt(request.getParameter("hourId"));
        dbUtilUser.cancelVisit(userLogin, specialistId, placeId, visitDate, hourId);
        listVisits(request, response);
    }

}//end of class
