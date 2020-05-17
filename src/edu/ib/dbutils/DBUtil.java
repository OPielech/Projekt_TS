package edu.ib.dbutils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBUtil {

    public static void close(Connection conn, Statement statement, ResultSet resultSet) {

        try {

            if (resultSet != null)
                resultSet.close();

            if (statement != null)
                statement.close();

            if (conn != null)
                conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//end of close

}//end of class
