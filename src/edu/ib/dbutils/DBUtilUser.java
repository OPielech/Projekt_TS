package edu.ib.dbutils;

import edu.ib.entities.*;

import java.sql.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DBUtilUser extends DBUtil {
    private String url;

    public DBUtilUser(String url) {
        this.url = url;
    }

    public void addUser(User user) throws Exception {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");

            String sql = "insert into users(user_login, user_password, user_name, user_surname, user_email, user_birth_date, user_city, user_postcode, user_phone) values (?,?,?,?,?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getUserLogin());
            preparedStatement.setString(2, user.getUserPassword());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getUserSurname());
            preparedStatement.setString(5, user.getUserEmail());
            preparedStatement.setDate(6, user.getUserBirthDate());
            preparedStatement.setString(7, user.getUserCity());
            preparedStatement.setString(8, user.getUserPostcode());
            preparedStatement.setString(9, user.getUserPhone());
            preparedStatement.execute();
        } finally {
            close(connection, preparedStatement, null);
        }
    }//end of addUser


    public User getUser(String login) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        User user = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");

            String sql = "select * from users where (user_login=\"" + login + "\")";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int userId = resultSet.getInt("user_id");
                String userLogin = resultSet.getString("user_login");
                String userPassword = resultSet.getString("user_password");
                String userName = resultSet.getString("user_name");
                String userSurname = resultSet.getString("user_surname");
                String userEmail = resultSet.getString("user_email");
                Date userBirthDate = Date.valueOf(resultSet.getString("user_birth_date"));
                String userCity = resultSet.getString("user_city");
                String userPostcode = resultSet.getString("user_postcode");
                String userPhone = resultSet.getString("user_phone");

                user = new User(userId, userLogin, userPassword, userName, userSurname, userEmail, userBirthDate, userCity, userPostcode, userPhone);
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return user;
    }//end of get User

    public List<Specialist> getSpecialists() throws Exception {
        List<Specialist> specialists = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select * from specialists";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int specialistId = resultSet.getInt("specialist_id");
                String specialistName = resultSet.getString("specialist_name");

                specialists.add(new Specialist(specialistId, specialistName));
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return specialists;
    }//end of getSpecialists

    public List<Place> getPlaces() throws Exception {
        List<Place> places = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select * from places";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int placeId = resultSet.getInt("place_id");
                String placeValue = resultSet.getString("place_value");

                places.add(new Place(placeId, placeValue));
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return places;
    }//end of getPlaces

    public List<Hour> getHours(String specialistName, Date visitDate, String placeValue) throws Exception {
        List<Hour> hours = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "call free_hours(\"" + specialistName + "\", \"" + visitDate + "\", \"" + placeValue + "\")";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                int hourId = resultSet.getInt("hour_id");
                Time hourValue = resultSet.getTime("hour_value");
                LocalTime localTimeHourValue = hourValue.toLocalTime();

                hours.add(new Hour(hourId, localTimeHourValue));
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return hours;
    }//end of getHours

    public List<VisitView> getPastVisits(String userLogin) throws Exception {
        List<VisitView> visitViews = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "call past_visits(\""+userLogin+"\")";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String specialistName = resultSet.getString("specialist_name");
                String placeValue = resultSet.getString("place_value");
                Date visitDate = resultSet.getDate("visit_date");
                String hourValue = resultSet.getString("hour_value");

                visitViews.add(new VisitView(specialistName,placeValue,visitDate,hourValue));
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return visitViews;
    }//end of getPastVisits

    public List<VisitView> getUpcomingVisits(String userLogin) throws Exception {
        List<VisitView> visitViews = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "call upcoming_visits(\""+userLogin+"\")";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String specialistName = resultSet.getString("specialist_name");
                String placeValue = resultSet.getString("place_value");
                Date visitDate = resultSet.getDate("visit_date");
                String hourValue = resultSet.getString("hour_value");

                visitViews.add(new VisitView(specialistName,placeValue,visitDate,hourValue));
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return visitViews;
    }//end of getUpcomingVisits

    public int checkAvailability(String specialistName, Date visitDate, String placeValue) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select free_terms (\"" + specialistName + "\", \"" + visitDate + "\", \"" + placeValue + "\")as free_terms";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result = resultSet.getInt("free_terms");
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return result;
    }

        public void addReservation(String userLogin, String specialistName, String placeName, Date visitDate, Time visitHour) throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");

            String sql = "insert into visits (visit_user_id, visit_specialist_id, visit_place_id, visit_date, visit_hour_id) values (?,?,?,?,?)";

            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, getUserId(userLogin));
            preparedStatement.setInt(2, getSpecialistId(specialistName));
            preparedStatement.setInt(3, getPlaceId(placeName));
            preparedStatement.setDate(4, visitDate);
            preparedStatement.setInt(5, getHourId(visitHour));
            preparedStatement.execute();
        } finally {
            close(connection, preparedStatement, null);
        }
    }//end of addUser

    public int getUserId(String userLogin) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select user_id from users where user_login=\"" + userLogin + "\"";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result = resultSet.getInt("user_id");
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return result;
    }

    public int getSpecialistId(String specialistName) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select specialist_id from specialists where specialist_name=\"" + specialistName + "\"";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result = resultSet.getInt("specialist_id");
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return result;
    }

    public int getPlaceId(String placeName) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select place_id from places where place_value=\"" + placeName + "\"";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result = resultSet.getInt("place_id");
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return result;
    }

    public int getHourId(Time hourValue) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select hour_id from hours where hour_value=\"" + hourValue + "\"";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result = resultSet.getInt("hour_id");
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return result;
    }

    public void cancelVisit(String userLogin, String specialistId, String placeId, Date visitDate, String hourId) throws Exception {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "call cancel_visit(\""+userLogin+"\",\""+specialistId+"\",\""+placeId+"\",\""+visitDate+"\",\""+hourId+"\");";
            statement = connection.createStatement();
            statement.executeQuery(sql);
        } finally {
            close(connection, statement, null);
        }
    }

    public boolean isLoginAvailable (String userLogin) throws Exception {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        int result = 0;

        try {
            connection = DriverManager.getConnection(url, "user", "user");
            String sql = "select free_login(\""+userLogin+"\") as free_login";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                result = resultSet.getInt("free_login");
            }

            return result == 1;

        } finally {
            close(connection, statement, null);
        }
    }//end of isLoginAvailable

}//end of class
