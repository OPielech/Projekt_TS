package edu.ib.dbutils;

import edu.ib.entities.Specialist;
import edu.ib.entities.User;

import java.sql.*;
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
            connection = DriverManager.getConnection(url, "root", "OsKaR_1998");

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
            connection = DriverManager.getConnection(url, "root", "OsKaR_1998");

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

    public List<Specialist> getSpecialists() throws Exception{
        List<Specialist> specialists = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, "root", "OsKaR_1998");
            String sql = "select * from specialists";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()){
                int specialistId = resultSet.getInt("specialist_id");
                String specialistName = resultSet.getString("specialist_name");

                specialists.add(new Specialist(specialistId, specialistName));
            }

        } finally {
            close(connection, statement, resultSet);
        }

        return specialists;
    }//end of getSpecialists
}//end of class
