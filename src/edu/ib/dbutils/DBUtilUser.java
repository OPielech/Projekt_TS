package edu.ib.dbutils;

import edu.ib.entities.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

            String  sql = "insert into users(user_login, user_password, user_name, user_surname, user_email, user_birth_date, user_city, user_postcode, user_phone) values (?,?,?,?,?,?,?,?,?)";

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
            close(connection,preparedStatement,null);
        }
    }//end of addUser
}//end of class
